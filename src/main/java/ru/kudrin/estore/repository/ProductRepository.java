package ru.kudrin.estore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kudrin.estore.entity.ElectroItem;

public interface ProductRepository extends JpaRepository<ElectroItem, Long> {
}
