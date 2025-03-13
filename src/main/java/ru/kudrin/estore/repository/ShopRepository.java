package ru.kudrin.estore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import ru.kudrin.estore.dto.ShopWithCashDTO;
import ru.kudrin.estore.entity.Shop;

import java.util.Optional;

public interface ShopRepository extends JpaRepository<Shop, Long> {

    @Query("SELECT new ru.kudrin.estore.dto.ShopWithCashDTO(s.name, SUM(e.price)) " +
            "FROM Shop s " +
            "JOIN Purchase p ON p.shopId = s.id " +
            "JOIN ElectroItem e ON e.id = p.electroItemId " +
            "WHERE s.id = ?1 AND p.typeId = 1 " +
            "GROUP BY s.name")
    Optional<ShopWithCashDTO> findByIdWithCash(Long id);
}
