package ru.kudrin.estore.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kudrin.estore.entity.ElectroItem;
import ru.kudrin.estore.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DefaultProductService implements ProductService{
    private final ProductRepository productRepository;
    @Override
    public List<ElectroItem> findAllProducts() {
        return  productRepository.findAll();
    }

    @Transactional
    @Override
    public ElectroItem createProduct(String name,
                                     Long price,
                                     Integer count,
                                     Long electrotypeId,
                                     boolean isArchive,
                                     String description) {

        return productRepository.save(new ElectroItem(null, name, price, count, electrotypeId, isArchive, description));
    }

    @Override
    public Optional<ElectroItem> findProduct(int productId) {
        return Optional.empty();
    }

    @Override
    public void updateProduct(Integer id, String title, String details) {

    }

    @Override
    public void deleteProduct(Integer id) {

    }
}
