package ru.kudrin.estore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Entity
@Table(name = "purchase_type")
public class PurchaseType implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    Long id;

    @Column(name = "name", nullable = false)
    String name;
}