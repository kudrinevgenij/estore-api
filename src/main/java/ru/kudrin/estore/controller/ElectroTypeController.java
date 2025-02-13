package ru.kudrin.estore.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kudrin.estore.entity.ElectroType;
import ru.kudrin.estore.service.DefaultElectroTypeService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("estore/api/electro-types")
public class ElectroTypeController {
    private final DefaultElectroTypeService service;

    @GetMapping
    public List<ElectroType> findAll() {
        return  service.findAll();
    }

    @GetMapping("/{id}")
    public ElectroType findById(@PathVariable("id") long id) {
        return  service.findElectroType(id).orElseThrow(() -> new NoSuchElementException("Тип не найден."));
    }

    @PostMapping
    public ResponseEntity<ElectroType> createElectroType(@RequestBody ElectroType electroType) {
        ElectroType type = service.createElectroType(electroType.getName());
        return ResponseEntity.ok(type);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateElectroType(@PathVariable("id") long id, @RequestBody ElectroType electroType) {
        service.updateElectroType(id, electroType.getName());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteElectroType(@PathVariable("id") long id) {
        service.deleteElectroType(id);
        return ResponseEntity.noContent().build();
    }
}