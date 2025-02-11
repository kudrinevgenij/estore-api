package ru.kudrin.estore.controller.payload;

import lombok.Data;

@Data
public class ProductPayload {
    String name;

    Long price;

    Integer count;

    Long electrotypeId;

    Boolean isArchive;

    String description;
}
