package ru.kudrin.estore.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kudrin.estore.entity.PositionType;
import ru.kudrin.estore.service.DefaultPositionTypeService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("estore/api/position-types")
public class PositionTypeController {
    private final DefaultPositionTypeService service;

    @GetMapping
    public List<PositionType> findAll() {
        return  service.findAll();
    }

    @GetMapping("/{id}")
    public PositionType findById(@PathVariable("id") long id) {
        return  service.findPositionType(id).orElseThrow(() -> new NoSuchElementException("Тип не найден."));
    }

    @PostMapping
    public ResponseEntity<PositionType> createPositionType(@RequestBody PositionType positionType) {
        PositionType type = service.createPositionType(positionType.getName());
        return ResponseEntity.ok(type);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updatePositionType(@PathVariable("id") long id, @RequestBody PositionType positionType) {
        service.updatePositionType(id, positionType.getName());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePositionType(@PathVariable("id") long id) {
        service.deletePositionType(id);
        return ResponseEntity.noContent().build();
    }
}
