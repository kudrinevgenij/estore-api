package ru.kudrin.estore.service;

import com.google.common.base.CaseFormat;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ru.kudrin.estore.repository.RepositoryRegistry;

import java.io.*;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Service
public class CSVUploadService {
    private final Map<String, List<CSVRecord>> csvFiles = new HashMap<>();

    @Autowired
    private RepositoryRegistry repositoryRegistry;

    Map<String, List<String>> csvToEntityMapping = Map.of(
            "lastName", List.of("lastname"),
            "firstName", List.of("firstname"),
            "birthDate", List.of("birthdate"),
            "positionId", List.of("position"),
            "electroItemId", List.of("electroId", "electroItemId"),
            "electroTypeId", List.of("etypeId", "etype"),
            "isArchive", List.of("archive")
    );


    public void importData(Map<String, List<CSVRecord>> csvData) {
        List<String> tableLoadOrder = List.of("shop",
                                                "electro_type",
                                                "position_type",
                                                "purchase_type",
                                                "electro_item",
                                                "employee",
                                                "purchase",
                                                "electro_employee",
                                                "electro_shop"
                                                );

        for (String tableName : tableLoadOrder) {
            if (csvData.containsKey(tableName)) {
                saveToDatabase(tableName, csvData.get(tableName));
            }
        }
    }

    public void handle(byte[] zipData) throws IOException {
        try (ZipInputStream zipInputStream = new ZipInputStream(new ByteArrayInputStream(zipData))) {
            ZipEntry entry;
            while ((entry = zipInputStream.getNextEntry()) != null) {
                if (entry.getName().endsWith(".csv")) {
                    String tableName = getTableName(entry.getName());
                    List<CSVRecord> records = getCSVRecords(new ByteArrayInputStream(zipInputStream.readAllBytes()));
                    csvFiles.put(tableName, records);
                }
                zipInputStream.closeEntry();
            }
        }
        importData(csvFiles);
    }

    private List<CSVRecord> getCSVRecords(InputStream inputStream) throws IOException {
        String csvContent = preprocessCsvContent(inputStream);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "Windows-1251"));
        try (CSVParser csvParser = CSVFormat.DEFAULT.builder()
                .setDelimiter(';')
                .setHeader()
                .setIgnoreSurroundingSpaces(true)
                .setTrim(true)
                .build()
                .parse(new StringReader(csvContent))) {
            return csvParser.getRecords();
        }
    }

    private String preprocessCsvContent(InputStream inputStream) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "Windows-1251"))) {
            return reader.lines()
                    .map(line -> line.replaceAll(";$", ""))
                    .collect(Collectors.joining("\n"));
        }
    }

    private String getTableName(String entityName) {
        return CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, entityName.substring(0, entityName.lastIndexOf(".")));
    }

    private void saveToDatabase(String tableName, List<CSVRecord> records) {
        JpaRepository repository = repositoryRegistry.getRepository(tableName);
        if (repository == null) {
            throw new IllegalStateException("Не найден репозиторий для таблицы: " + tableName);
        }
        Class<?> entityClass = repositoryRegistry.getEntityClass(tableName);
        List<Object> entities = records.stream()
                .map(record -> mapToEntity(entityClass, record))
                .collect(Collectors.toList());

        repository.saveAll(entities);
    }

    private Object mapToEntity(Class<?> entityClass, CSVRecord record) {
        try {
            Object entity = entityClass.getDeclaredConstructor().newInstance();
            for (Field field : entityClass.getDeclaredFields()) {
                field.setAccessible(true);
                String fieldName = field.getName();
                for (String value : csvToEntityMapping.getOrDefault(fieldName, List.of(fieldName))) {
                    if (record.isMapped(value)) {
                        field.set(entity, convertValue(field.getType(), record.get(value)));
                    }
                }
            }
            return entity;
        } catch (Exception e) {
            throw new RuntimeException("Ошибка при маппинге CSV -> Entity: " + entityClass.getSimpleName(), e);
        }
    }

    private Object convertValue(Class<?> fieldType, String value) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        if (fieldType == String.class) return value;
        if (fieldType == Integer.class || fieldType == int.class) return Integer.parseInt(value);
        if (fieldType == Long.class || fieldType == long.class) return Long.parseLong(value);
        if (fieldType == Double.class || fieldType == double.class) return Double.parseDouble(value);
        if (fieldType == Boolean.class || fieldType == boolean.class) return "1".equals(value) || "true".equalsIgnoreCase(value);
        if (fieldType == LocalDate.class) return LocalDate.parse(value, dateFormatter);
        if (fieldType == LocalDateTime.class) return LocalDateTime.parse(value, dateTimeFormatter);
        return value;
    }
}

