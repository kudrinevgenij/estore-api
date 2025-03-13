package ru.kudrin.estore.entity;

import javax.persistence.*;

import lombok.*;
@Getter
@Setter
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "electro_shop")
public class ElectroShop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "shop_id", nullable = false)
    private Long shopId;

    @Column(name = "electroitem_id", nullable = false)
    private Long electroItemId;

    @Column(name = "count", nullable = false)
    private Integer count;
}