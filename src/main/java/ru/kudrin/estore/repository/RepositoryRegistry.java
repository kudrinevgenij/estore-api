package ru.kudrin.estore.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import ru.kudrin.estore.entity.*;

import java.util.HashMap;
import java.util.Map;

@Component
public class RepositoryRegistry {

    private final Map<String, JpaRepository<?, ?>> repositories = new HashMap<>();

    private final Map<String, Class<?>> entityClasses = new HashMap<>();

    @Autowired
    public RepositoryRegistry(ElectroEmployeeRepository electroEmployeeRepository,
                              ElectroShopRepository electroShopRepository,
                              ElectroTypeRepository electroTypeRepository,
                              EmployeeRepository employeeRepository,
                              PositionTypeRepository positionTypeRepository,
                              ProductRepository productRepository,
                              PurchaseTypeRepository purchaseTypeRepository,
                              PurchaseRepository purchaseRepository,
                              ShopRepository shopRepository
                                ) {
        repositories.put("electro_shop", electroShopRepository);
        repositories.put("electro_type", electroTypeRepository);
        repositories.put("employee", employeeRepository);
        repositories.put("position_type", positionTypeRepository);
        repositories.put("electro_item", productRepository);
        repositories.put("purchase_type", purchaseTypeRepository);
        repositories.put("electro_employee", electroEmployeeRepository);
        repositories.put("shop", shopRepository);
        repositories.put("purchase", purchaseRepository);

        entityClasses.put("electro_shop", ElectroShop.class);
        entityClasses.put("electro_type", ElectroType.class);
        entityClasses.put("employee", Employee.class);
        entityClasses.put("position_type", PositionType.class);
        entityClasses.put("electro_item", ElectroItem.class);
        entityClasses.put("purchase_type", PurchaseType.class);
        entityClasses.put("electro_employee", ElectroEmployee.class);
        entityClasses.put("shop", Shop.class);
        entityClasses.put("purchase", Purchase.class);
    }


    public JpaRepository<?, ?> getRepository(String tableName) {
        return repositories.get(tableName);
    }

    public Class<?> getEntityClass(String name) {
        return entityClasses.get(name);
    }
}
