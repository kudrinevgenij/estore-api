package ru.kudrin.estore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kudrin.estore.entity.ElectroEmployee;

public interface ElectroEmployeeRepository extends JpaRepository<ElectroEmployee, Long> {
}
