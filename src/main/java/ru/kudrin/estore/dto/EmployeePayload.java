package ru.kudrin.estore.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public final class EmployeePayload {

    private final Long id;

    private final String lastName;

    private final String firstName;

    private final String patronymic;

    private final LocalDate birthDate;

    private final Long positionId;

    private final Long shopId;

    private final Boolean gender;
}
