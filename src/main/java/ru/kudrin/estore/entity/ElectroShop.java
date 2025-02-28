package ru.kudrin.estore.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@IdClass(ElectroShopId.class)
@Table(name = "electro_shop")
public class ElectroShop implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    Long shopId;

    @Id
    @Column(name = "electroitem_id", nullable = false)
    Long electroItemId;

    @Column(name = "count", nullable = false)
    Integer count;
}