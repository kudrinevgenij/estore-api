package ru.kudrin.estore.service;

import ru.kudrin.estore.entity.ElectroItem;

import javax.transaction.Transactional;
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

    Optional<ElectroItem> findProduct(long productId);

    void updateProduct(Long id,
                       String name,
                       Long price,
                       Integer count,
                       Long electrotypeId,
                       Boolean isArchive,
                       String description);

    void deleteProduct(Long id);
}