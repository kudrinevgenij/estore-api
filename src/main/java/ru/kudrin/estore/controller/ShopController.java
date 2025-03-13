package ru.kudrin.estore.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.tags.Tag;
import ru.kudrin.estore.dto.ShopPayload;
import ru.kudrin.estore.dto.ShopWithCashDTO;
import ru.kudrin.estore.entity.Shop;
import ru.kudrin.estore.service.ShopService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@Tag(name = "Shop", description = "Сервис для выполнения операций над магазинами")
@RequestMapping("/estore/api/shops")
@RequiredArgsConstructor
public class ShopController {
    private final ShopService service;

    @GetMapping
    public List<Shop> findAll() {
        return  service.findAll();
    }

    @GetMapping("/{id}")
    public Shop findById(@PathVariable("id") long id) {
        return  service.findShop(id).orElseThrow(() -> new NoSuchElementException("Магазин не найден."));
    }

    @GetMapping("/with-cash/{id}")
    public ShopWithCashDTO findByIdWithCashPayment(@PathVariable("id") long id) {
        return  service.findByIdWithCash(id).orElseThrow(() -> new NoSuchElementException("Данные по этому магазину отсутствуют."));
    }

    @PostMapping
    public ResponseEntity<Shop> createShop(@RequestBody ShopPayload payload) {
        Shop shop = service.createShop(payload.getName(), payload.getAddress());
        return ResponseEntity.ok(shop);
    }

    @PostMapping("/save")
    public ResponseEntity<Shop> createShopFromRestClient(@RequestParam String name, String address) {
        Shop shop = service.createShop(name, address);
        return ResponseEntity.ok(shop);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateShop(@PathVariable("id") long id, @RequestBody ShopPayload payload) {
        service.updateShop(id, payload.getName(), payload.getAddress());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShop(@PathVariable("id") long id) {
        service.deleteShop(id);
        return ResponseEntity.noContent().build();
    }
}
