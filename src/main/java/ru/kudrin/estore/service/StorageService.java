package ru.kudrin.estore.service;

import com.google.common.base.CaseFormat;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Service
public class StorageService {
    public void handle(byte[] zipData) throws IOException {
        try (ZipInputStream zipInputStream = new ZipInputStream(new ByteArrayInputStream(zipData))) {
            ZipEntry entry;
            while ((entry = zipInputStream.getNextEntry()) != null) {
                if (entry.getName().endsWith(".csv")) {
                    handleCsvFile(zipInputStream, entry.getName());
                }
                zipInputStream.closeEntry();
            }
        }
    }

    private void handleCsvFile(ZipInputStream zipInputStream, String fileName) throws IOException {
        System.out.println("Обрабатываем CSV файл: " + fileName);
        fileName = fileName.substring(0, fileName.lastIndexOf("."));
        String tableName = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, fileName);
        System.out.println("Пишем в таблицу: " + tableName);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int bytesRead;

        while ((bytesRead = zipInputStream.read(buffer)) != -1) {
            byteArrayOutputStream.write(buffer, 0, bytesRead);
        }

        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
             BufferedReader reader = new BufferedReader(new InputStreamReader(byteArrayInputStream, "Windows-1251"));
             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)) {

            for (CSVRecord record : csvParser) {
                System.out.println("Строка CSV: " + record.toString());
            }
        }
    }
}
