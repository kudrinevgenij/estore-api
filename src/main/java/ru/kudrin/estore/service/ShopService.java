package ru.kudrin.estore.service;

import ru.kudrin.estore.dto.ShopWithCashDTO;
import ru.kudrin.estore.entity.Shop;

import java.util.List;
import java.util.Optional;

public interface ShopService {
    List<Shop> findAll();

    Shop createShop(String name, String address);

    Optional<Shop> findShop(long id);

    void updateShop(Long id, String name, String address);

    void deleteShop(Long id);

    Optional<ShopWithCashDTO> findByIdWithCash(Long id);

}