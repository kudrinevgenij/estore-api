package ru.kudrin.estore.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class ElectroShopId implements Serializable {
    Long shopId;
    Long electroItemId;
}