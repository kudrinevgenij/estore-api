package ru.kudrin.estore.service;

import ru.kudrin.estore.entity.Purchase;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PurchaseService {
    List<Purchase> findAll();

    Purchase createPurchase(Long electroItemId,
                            LocalDateTime purchaseDate,
                            Long employeeId,
                            Long typeId,
                            Long shopId);

    Optional<Purchase> findPurchase(long id);

    void updatePurchase(Long id,
                        Long electroItemId,
                        Long employeeId,
                        Long typeId,
                        Long shopId,
                        LocalDateTime purchaseDate);

    void deletePurchase(Long id);

}