package ru.kudrin.estore.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kudrin.estore.controller.payload.ProductPayload;
import ru.kudrin.estore.entity.ElectroItem;
import ru.kudrin.estore.service.ProductService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/estore/api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/find-all")
    public List<ElectroItem> findAll() {
        return  productService.findAllProducts();
    }

    @GetMapping("/find/{id}")
    public ElectroItem findById(@PathVariable("id") long id) {
        return  productService.findProduct(id).orElseThrow(() -> new NoSuchElementException("Товар не найден."));
    }

    @PostMapping("/create")
    public ResponseEntity<ElectroItem> createProduct(@RequestBody ProductPayload payload) {
        ElectroItem product = productService.createProduct(payload.getName(), payload.getPrice(), payload.getCount(),
                payload.getElectrotypeId(), payload.getIsArchive(), payload.getDescription());
        return ResponseEntity.ok(product);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Void> updateProduct(@PathVariable("id") long id, @RequestBody ProductPayload payload) {
        productService.updateProduct(id, payload.getName(), payload.getPrice(), payload.getCount(),
                payload.getElectrotypeId(), payload.getIsArchive(), payload.getDescription());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") long productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }
}