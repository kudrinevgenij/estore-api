package ru.kudrin.estore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.kudrin.estore.entity.Shop;

public interface ShopRepository extends JpaRepository<Shop, Long> {
	
}
