package ru.kudrin.estore.dto;

import lombok.Data;
import ru.kudrin.estore.entity.Shop;

@Data
public class ShopWithCashDTO {

    private final String shopName;

    private final Long totalCash;
}
