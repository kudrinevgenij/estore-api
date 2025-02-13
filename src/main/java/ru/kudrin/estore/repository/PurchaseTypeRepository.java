package ru.kudrin.estore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kudrin.estore.entity.PurchaseType;

public interface PurchaseTypeRepository extends JpaRepository<PurchaseType,Long> {
}
