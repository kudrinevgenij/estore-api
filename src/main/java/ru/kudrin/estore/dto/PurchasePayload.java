package ru.kudrin.estore.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public final class PurchasePayload {

    private final Long id;

    private final Long electroItemId;

    private final LocalDateTime purchaseDate;

    private final Long employeeId;

    private final Long typeId;

    private final Long shopId;
}
