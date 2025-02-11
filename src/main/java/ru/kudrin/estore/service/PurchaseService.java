package ru.kudrin.estore.service;

import ru.kudrin.estore.entity.Purchase;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PurchaseService {
    List<Purchase> findAll();

    Purchase createPurchase(Long electroItemId,
                            Long typeId,
                            Long shopId,
                            LocalDate purchaseDate);

    Optional<Purchase> findPurchase(long id);

    void updatePurchase(Long id,
                        Long electroItemId,
                        Long typeId,
                        Long shopId,
                        LocalDate purchaseDate);

    void deletePurchase(Long id);

}