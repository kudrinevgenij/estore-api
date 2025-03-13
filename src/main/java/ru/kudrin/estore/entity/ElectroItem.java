package ru.kudrin.estore.entity;

import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "electro_item")
public class ElectroItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "price", nullable = false, length = 100)
    private Long price;

    @Column(name = "count", nullable = false)
    private Integer count;

    @Column(name = "electrotype_id", nullable = false)
    private Long electroTypeId;

    @Column(name = "archive", nullable = false)
    private boolean isArchive;

    @Column(name = "description", nullable = false)
    private String description;
}