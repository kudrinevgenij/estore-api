package ru.kudrin.estore.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kudrin.estore.dto.EmployeeViewDTO;
import ru.kudrin.estore.entity.Employee;
import ru.kudrin.estore.repository.EmployeeRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DefaultEmployeeService implements EmployeeService {
    private final EmployeeRepository repository;

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Employee createEmployee(String firstName,
                                   String lastName,
                                   String patronymic,
                                   LocalDate birthDate,
                                   Long positionId,
                                   Long shopId,
                                   Boolean gender) {
        return repository.save(new Employee(null, firstName, lastName, patronymic, birthDate, positionId, shopId, gender));
    }

    @Override
    public Optional<Employee> findEmployee(long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public void updateEmployee(Long id,
                               String firstName,
                               String lastName,
                               String patronymic,
                               LocalDate birthDate,
                               Long positionId,
                               Long shopId,
                               Boolean gender) {
        repository.findById(id)
                .ifPresentOrElse(employee -> {
                    employee.setFirstName(firstName);
                    employee.setLastName(lastName);
                    employee.setPatronymic(patronymic);
                    employee.setBirthDate(birthDate);
                    employee.setPositionId(positionId);
                    employee.setShopId(shopId);
                    employee.setGender(gender);
                }, () -> {
                    throw new NoSuchElementException();
                });
    }

    @Override
    @Transactional
    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<EmployeeViewDTO> findAllWithShopAndPosition() {
        return repository.findAllWithShopAndPosition();
    }
}