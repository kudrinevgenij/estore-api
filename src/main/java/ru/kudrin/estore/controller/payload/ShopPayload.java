package ru.kudrin.estore.controller.payload;

import lombok.Data;

@Data
public final class ShopPayload {

    private final Long shopId;

    private final String name;

    private final String address;
}
