package ru.kudrin.estore.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.kudrin.estore.service.CSVUploadService;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/estore/api/upload")
public class CSVUploadController {

    private final CSVUploadService service;

    @PostMapping
    public ResponseEntity<String> uploadZipFile(@RequestParam("file") MultipartFile file) {
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