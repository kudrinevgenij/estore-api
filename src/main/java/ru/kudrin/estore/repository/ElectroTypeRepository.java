package ru.kudrin.estore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kudrin.estore.entity.ElectroType;

public interface ElectroTypeRepository extends JpaRepository<ElectroType, Long> {
}
