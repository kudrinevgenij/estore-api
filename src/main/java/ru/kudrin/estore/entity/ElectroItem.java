package ru.kudrin.estore.entity;

import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "electro_item")
public class ElectroItem {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "price", nullable = false, length = 100)
    private Long price;

    @Column(name = "count", nullable = false)
    private Integer count;

    @Column(name = "electrotype_id", nullable = false)
    private Long electrotypeId;

    @Column(name = "archive", nullable = false)
    private boolean isArchive;

    @Column(name = "description", nullable = false)
    private String description;
}