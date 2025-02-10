package ru.kudrin.estore.service;

import ru.kudrin.estore.entity.ElectroItem;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ElectroItem> findAllProducts();

    ElectroItem createProduct(String name,
                              Long price,
                              Integer count,
                              Long electrotypeId,
                              boolean isArchive,
                              String description);

    Optional<ElectroItem> findProduct(int productId);

    void updateProduct(Integer id, String title, String details);

    void deleteProduct(Integer id);
}