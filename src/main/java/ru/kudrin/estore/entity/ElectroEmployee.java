package ru.kudrin.estore.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@IdClass(ElectroEmployeeId.class)
@Table(name = "electro_employee")
public class ElectroEmployee {

    @Id
    @Column(name = "employee_id", nullable = false)
    Long employeeId;

    @Id
    @Column(name = "electrotype_id", nullable = false)
    Long electroTypeId;
}