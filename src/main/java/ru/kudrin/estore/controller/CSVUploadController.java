package ru.kudrin.estore.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.kudrin.estore.service.CSVUploadService;

import java.io.IOException;

@RestController
@Tag(name = "CSV upload", description = "Сервис для загрузки zip архива с файлами csv для заполнения базы данных")
@RequiredArgsConstructor
@RequestMapping("/estore/api/uploads")
public class CSVUploadController {

    private final CSVUploadService service;


    @Operation(
            summary = "Загрузка файла",
            description = "Принимает файлы в формате multipart/form-data",
            requestBody = @RequestBody(
                    content = @Content(mediaType = "multipart/form-data",
                            schema = @Schema(type = "string", format = "binary"))
            )
    )
    @PostMapping
    public ResponseEntity<String> uploadZipFile(@RequestPart("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Не выбран файл для загрузки.");
        }

        try {
            service.handle(file.getBytes());
            return ResponseEntity.ok("Файл успешно загружен и обработан.");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Ошибка при загрузке файла: " + e.getMessage());
        }
    }
}