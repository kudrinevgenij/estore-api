package ru.kudrin.estore.entity;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@AllArgsConstructor
@Table(name = "purchase")
public class Purchase implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Long id;

    @Column(name = "electroitem_id", nullable = false)
    Long electroItemId;

    @Column(name = "purchase_date", nullable = false)
    LocalDateTime purchaseDate;

    @Column(name = "store_employee", nullable = false)
    Long employeeId;

    @Column(name = "type_id", nullable = false)
    Long typeId;

    @Column(name = "shop_id", nullable = false)
    Long shopId;
}