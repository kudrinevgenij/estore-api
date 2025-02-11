package ru.kudrin.estore.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kudrin.estore.entity.ElectroItem;
import ru.kudrin.estore.repository.ProductRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DefaultProductService implements ProductService{
    private final ProductRepository productRepository;
    @Override
    public List<ElectroItem> findAllProducts() {
        return  productRepository.findAll();
    }

    @Override
    @Transactional
    public ElectroItem createProduct(String name,
                                     Long price,
                                     Integer count,
                                     Long electrotypeId,
                                     boolean isArchive,
                                     String description) {

        return productRepository.save(new ElectroItem(null, name, price, count, electrotypeId, isArchive, description));
    }

    @Override
    public Optional<ElectroItem> findProduct(long productId) {
        return productRepository.findById(productId);
    }

    @Override
    @Transactional
    public void updateProduct(Long id,
                              String name,
                              Long price,
                              Integer count,
                              Long electrotypeId,
                              Boolean isArchive,
                              String description) {
        productRepository.findById(id)
                .ifPresentOrElse(product -> {
                    product.setName(name);
                    product.setPrice(price);
                    product.setCount(count);
                    product.setElectrotypeId(electrotypeId);
                    product.setArchive(isArchive);
                    product.setDescription(description);
                }, () -> {
                    throw new NoSuchElementException();
                });
    }

    @Override
    @Transactional
    public void deleteProduct(Long id) {
            productRepository.deleteById(id);
    }
}