package ru.kudrin.estore.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class ElectroEmployeeId implements Serializable {
    Long employeeId;
    Long electroTypeId;
}