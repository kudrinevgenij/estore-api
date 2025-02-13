package ru.kudrin.estore.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kudrin.estore.entity.PurchaseType;
import ru.kudrin.estore.repository.PurchaseTypeRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DefaultPurchaseTypeService {
    private final PurchaseTypeRepository repository;

    public List<PurchaseType> findAll() {
        return repository.findAll();
    }

    @Transactional
    public PurchaseType createPurchaseType(String name) {
        return repository.save(new PurchaseType(null, name));
    }

    public Optional<PurchaseType> findPurchaseType(long id) {
        return repository.findById(id);
    }

    @Transactional
    public void updatePurchaseType(Long id, String name) {
        repository.findById(id)
                .ifPresentOrElse(purchaseType -> {
                    purchaseType.setName(name);
                }, () -> {
                    throw new NoSuchElementException();
                });
    }

    @Transactional
    public void deletePurchaseType(Long id) {
        repository.deleteById(id);
    }
}