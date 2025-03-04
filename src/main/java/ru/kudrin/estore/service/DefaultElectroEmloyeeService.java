package ru.kudrin.estore.service;

import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import ru.kudrin.estore.entity.ElectroEmployee;
import ru.kudrin.estore.repository.ElectroEmployeeRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DefaultElectroEmloyeeService {
    private final ElectroEmployeeRepository repository;

    public List<ElectroEmployee> findAll() {
        return repository.findAll();
    }

    @Transactional
    public ElectroEmployee createElectroEmployee(Long employeeId, Long electroTypeId) {
        return repository.save(new ElectroEmployee(null, employeeId,electroTypeId));
    }

    @Transactional
    public void createElectroEmployeeFromCSV(CSVParser file) {
        for (CSVRecord record : file) {
        }
    }

    public Optional<ElectroEmployee> findElectroEmployee(long id) {
        return repository.findById(id);
    }

    @Transactional
    public void updateElectroEmployee(Long employeeId, Long electroTypeId) {
        repository.findById(employeeId)
                .ifPresentOrElse(electroEmployee -> {
                    electroEmployee.setElectroTypeId(electroTypeId);
                }, () -> {
                    throw new NoSuchElementException();
                });
    }

    @Transactional
    public void deleteElectroEmployee(Long id) {
        repository.deleteById(id);
    }
}