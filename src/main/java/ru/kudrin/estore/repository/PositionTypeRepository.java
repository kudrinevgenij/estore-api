package ru.kudrin.estore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kudrin.estore.entity.PositionType;

public interface PositionTypeRepository extends JpaRepository<PositionType, Long> {
}
