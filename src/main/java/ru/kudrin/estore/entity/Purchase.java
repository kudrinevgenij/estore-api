package ru.kudrin.estore.entity;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "purchase")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Long id;

    @Column(name = "electroitem_id", nullable = false)
    Long electroItemId;

    @Column(name = "purchase_date", nullable = false)
    LocalDateTime purchaseDate;

    @Column(name = "employee_id", nullable = false)
    Long employeeId;

    @Column(name = "type_id", nullable = false)
    Long typeId;

    @Column(name = "shop_id", nullable = false)
    Long shopId;
}