package ru.kudrin.estore.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.tags.Tag;
import ru.kudrin.estore.dto.PurchasePayload;
import ru.kudrin.estore.entity.Purchase;
import ru.kudrin.estore.service.PurchaseService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@Tag(name = "Purchase", description = "Сервис для выполнения операций над покупкамии")
@RequestMapping("/estore/api/purchases")
@RequiredArgsConstructor
public class PurchaseController {
    private final PurchaseService service;

    @GetMapping
    public List<Purchase> findAll() {
        return  service.findAll();
    }

    @GetMapping("/{id}")
    public Purchase findById(@PathVariable("id") long id) {
        return  service.findPurchase(id).orElseThrow(() -> new NoSuchElementException("Покупка не найдена."));
    }

    @PostMapping
    public ResponseEntity<Purchase> createShop(@RequestBody PurchasePayload payload) {
        Purchase purchase = service.createPurchase(payload.getElectroItemId(),
                                                    payload.getPurchaseDate(),
                                                    payload.getEmployeeId(),
                                                    payload.getTypeId(),
                                                    payload.getShopId());
        return ResponseEntity.ok(purchase);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updatePurchase(@PathVariable("id") long id, @RequestBody PurchasePayload payload) {
        service.updatePurchase(id,
                payload.getElectroItemId(),
                payload.getEmployeeId(),
                payload.getTypeId(),
                payload.getShopId(),
                payload.getPurchaseDate());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShop(@PathVariable("id") long id) {
        service.deletePurchase(id);
        return ResponseEntity.noContent().build();
    }
}
