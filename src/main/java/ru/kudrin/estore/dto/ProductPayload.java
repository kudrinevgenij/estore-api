package ru.kudrin.estore.dto;

import lombok.Data;

@Data
public final class ProductPayload {
    private final String name;

    private final Long price;

    private final Integer count;

    private final Long electrotypeId;

    private final Boolean isArchive;

    private final String description;
}
