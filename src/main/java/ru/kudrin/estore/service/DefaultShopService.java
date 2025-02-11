package ru.kudrin.estore.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kudrin.estore.entity.Shop;
import ru.kudrin.estore.repository.ShopRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DefaultShopService implements ShopService{
    private final ShopRepository repository;

    @Override
    public List<Shop> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Shop createShop(String name, String address) {
        return repository.save(new Shop(null, name, address));
    }

    @Override
    public Optional<Shop> findShop(long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public void updateShop(Long id, String name, String address) {
        repository.findById(id)
                .ifPresentOrElse(shop -> {
                    shop.setName(name);
                    shop.setAddress(address);
                }, () -> {
                    throw new NoSuchElementException();
                });
    }

    @Override
    @Transactional
    public void deleteShop(Long id) {
        repository.deleteById(id);
    }
}