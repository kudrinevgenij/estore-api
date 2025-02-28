package ru.kudrin.estore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kudrin.estore.entity.ElectroShop;

public interface ElectroShopRepository extends JpaRepository<ElectroShop, Long> {
}
