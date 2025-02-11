package ru.kudrin.estore.controller.payload;

import lombok.Data;

@Data
public class ProductPayload {
    private final String name;

    private final Long price;

    private final Integer count;

    private final Long electrotypeId;

    private final Boolean isArchive;

    private final String description;
}
