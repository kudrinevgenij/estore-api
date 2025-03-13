package ru.kudrin.estore.entity;

import javax.persistence.*;

import lombok.*;

@Getter
@Setter
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "electro_employee")
public class ElectroEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Long id;

    @Column(name = "employee_id", nullable = false)
    Long employeeId;

    @Column(name = "electrotype_id", nullable = false)
    Long electroTypeId;
}