package ru.kudrin.estore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ru.kudrin.estore.dto.EmployeeViewDTO;
import ru.kudrin.estore.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	@Query("SELECT new ru.kudrin.estore.dto.EmployeeViewDTO(e.id, e.lastName, e.firstName, e.patronymic, e.birthDate, p.name, s.name) " + "" +
			"FROM Employee e " +
			"JOIN Shop s ON e.shopId = s.id " +
			"JOIN PositionType p ON e.positionId = p.id " +
			"ORDER BY e.id ASC")
    List<EmployeeViewDTO> findAllWithShopAndPosition();

	@Query("SELECT e FROM Employee e " +
			"JOIN Purchase p ON p.employeeId = e.id " +
			"JOIN ElectroItem ei ON p.electroItemId = ei.id " +
			"JOIN PositionType pt ON e.positionId = pt.id " +
			"JOIN ElectroType et ON ei.electroTypeId = et.id " +
			"WHERE et.name = 'Умные часы' " +
			"AND pt.name = 'Младший продавец-консультант' " +
			"GROUP BY e.id " +
			"ORDER BY COUNT(p) DESC")
	List<Employee> findBestSmartWatchSeller();
}