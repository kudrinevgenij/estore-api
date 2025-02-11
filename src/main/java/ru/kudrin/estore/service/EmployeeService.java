package ru.kudrin.estore.service;

import ru.kudrin.estore.entity.Employee;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> findAll();

    Employee createEmployee(String firstName,
                              String lastName,
                              String patronymic,
                              LocalDate birthDate,
                              Long positionId,
                              Boolean gender);

    Optional<Employee> findEmployee(long productId);

    void updateEmployee(Long id,
                       String firstName,
                       String lastName,
                       String patronymic,
                       LocalDate birthDate,
                       Long positionId,
                       Boolean gender);

    void deleteEmployee(Long id);

}