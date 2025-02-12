package ru.kudrin.estore.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kudrin.estore.entity.Purchase;
import ru.kudrin.estore.repository.PurchaseRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DefaultPurchaseService implements PurchaseService {
    private final PurchaseRepository repository;

    @Override
    public List<Purchase> findAll() {
        return null;
    }

    @Override
    public Purchase createPurchase(Long electroItemId,
                                   LocalDateTime purchaseDate,
                                   Long employeeId,
                                   Long typeId,
                                   Long shopId) {
        return repository.save(new Purchase(null, electroItemId, purchaseDate, employeeId, typeId, shopId));
    }

    @Override
    public Optional<Purchase> findPurchase(long id) {
        return repository.findById(id);
    }

    @Override
    public void updatePurchase(Long id,
                               Long electroItemId,
                               Long employeeId,
                               Long typeId,
                               Long shopId,
                               LocalDateTime purchaseDate) {
        repository.findById(id)
                .ifPresentOrElse(purchase -> {
                    purchase.setEmployeeId(employeeId);
                    purchase.setElectroItemId(electroItemId);
                    purchase.setTypeId(typeId);
                    purchase.setShopId(shopId);
                    purchase.setPurchaseDate(purchaseDate);
                }, () -> {
                    throw new NoSuchElementException();
                });
    }

    @Override
    public void deletePurchase(Long id) {
        repository.deleteById(id);
    }
}
