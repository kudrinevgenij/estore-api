package ru.kudrin.estore.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kudrin.estore.entity.PurchaseType;
import ru.kudrin.estore.service.DefaultPurchaseTypeService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("estore/api/purchase-types")
public class PurchaseTypeController {
    private final DefaultPurchaseTypeService service;

    @GetMapping
    public List<PurchaseType> findAll() {
        return  service.findAll();
    }

    @GetMapping("/{id}")
    public PurchaseType findById(@PathVariable("id") long id) {
        return  service.findPurchaseType(id).orElseThrow(() -> new NoSuchElementException("Тип не найден."));
    }

    @PostMapping
    public ResponseEntity<PurchaseType> createPurchaseType(@RequestBody PurchaseType purchaseType) {
        PurchaseType type = service.createPurchaseType(purchaseType.getName());
        return ResponseEntity.ok(type);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updatePurchaseType(@PathVariable("id") long id, @RequestBody PurchaseType purchaseType) {
        service.updatePurchaseType(id, purchaseType.getName());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePurchaseType(@PathVariable("id") long id) {
        service.deletePurchaseType(id);
        return ResponseEntity.noContent().build();
    }
}
