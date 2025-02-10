package ru.kudrin.estore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "electro_shop")
public class ElectroShop implements Serializable {

    @Id
    @Column(name = "shop_id", nullable = false)
    Long shopId;

    @Id
    @Column(name = "electroitem_id", nullable = false)
    Long electroItemId;

    @Column(name = "count", nullable = false)
    Integer count;
}