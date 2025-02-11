package ru.kudrin.estore.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.tags.Tag;
import ru.kudrin.estore.controller.payload.ShopPayload;
import ru.kudrin.estore.entity.Shop;
import ru.kudrin.estore.service.ShopService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@Tag(name = "Shop", description = "Сервис для выполнения операций над магазинами")
@RequestMapping("/estore/api/shop")
@RequiredArgsConstructor
public class ShopController {
    private final ShopService service;

    @GetMapping("/find-all")
    public List<Shop> findAll() {
        return  service.findAll();
    }

    @GetMapping("/find/{id}")
    public Shop findById(@PathVariable("id") long id) {
        return  service.findShop(id).orElseThrow(() -> new NoSuchElementException("Магазин не найден."));
    }

    @PostMapping("/create")
    public ResponseEntity<Shop> createShop(@RequestBody ShopPayload payload) {
        Shop shop = service.createShop(payload.getName(), payload.getAddress());
        return ResponseEntity.ok(shop);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Void> updateShop(@PathVariable("id") long id, @RequestBody ShopPayload payload) {
        service.updateShop(id, payload.getName(), payload.getAddress());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteShop(@PathVariable("id") long id) {
        service.deleteShop(id);
        return ResponseEntity.noContent().build();
    }
}
