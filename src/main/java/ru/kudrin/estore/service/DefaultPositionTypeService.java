package ru.kudrin.estore.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kudrin.estore.entity.PositionType;
import ru.kudrin.estore.repository.PositionTypeRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DefaultPositionTypeService {
    private final PositionTypeRepository repository;

    public List<PositionType> findAll() {
        return repository.findAll();
    }

    @Transactional
    public PositionType createPositionType(String name) {
        return repository.save(new PositionType(null, name));
    }

    public Optional<PositionType> findPositionType(long id) {
        return repository.findById(id);
    }

    @Transactional
    public void updatePositionType(Long id, String name) {
        repository.findById(id)
                .ifPresentOrElse(positionType -> {
                    positionType.setName(name);
                }, () -> {
                    throw new NoSuchElementException();
                });
    }

    @Transactional
    public void deletePositionType(Long id) {
        repository.deleteById(id);
    }
}