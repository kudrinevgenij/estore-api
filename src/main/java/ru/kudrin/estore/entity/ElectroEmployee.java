package ru.kudrin.estore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "electro_employee")
public class ElectroEmployee implements Serializable {

    @Id
    @Column(name = "employee_id", nullable = false)
    Long employeeId;

    @Id
    @Column(name = "electrotype_id", nullable = false)
    Long electroTypeId;
}