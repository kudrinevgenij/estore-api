package ru.kudrin.estore.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kudrin.estore.controller.payload.ProductPayload;
import ru.kudrin.estore.entity.ElectroItem;
import ru.kudrin.estore.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/estore/api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping("/test")
    @Operation(summary = "Тестовый метод", responses = {
            @ApiResponse(description = "Тестовая фраза")
    })
    public ResponseEntity<String> test() {

        return ResponseEntity.ok("test");
    }
    @GetMapping("/find-all")
    public List<ElectroItem> findAll() {
        return  productService.findAllProducts();
    }

    @PostMapping("/create-product")
    public ResponseEntity<ElectroItem> createProduct(  @RequestBody ProductPayload payload) {
        ElectroItem product = productService.createProduct(payload.getName(), payload.getPrice(), payload.getCount(),
                payload.getElectrotypeId(), payload.isArchive(), payload.getDescription());
        return ResponseEntity.ok(product);
    }
}
