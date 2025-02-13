package ru.kudrin.estore.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kudrin.estore.entity.ElectroType;
import ru.kudrin.estore.repository.ElectroTypeRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DefaultElectroTypeService {
    private final ElectroTypeRepository repository;

    public List<ElectroType> findAll() {
        return repository.findAll();
    }

    @Transactional
    public ElectroType createElectroType(String name) {
        return repository.save(new ElectroType(null, name));
    }

    public Optional<ElectroType> findElectroType(long id) {
        return repository.findById(id);
    }

    @Transactional
    public void updateElectroType(Long id, String name) {
        repository.findById(id)
                .ifPresentOrElse(electroType -> {
                    electroType.setName(name);
                }, () -> {
                    throw new NoSuchElementException();
                });
    }

    @Transactional
    public void deleteElectroType(Long id) {
        repository.deleteById(id);
    }
}