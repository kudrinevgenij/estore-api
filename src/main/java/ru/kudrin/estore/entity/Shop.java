package ru.kudrin.estore.entity;

import javax.persistence.*;

import lombok.*;

import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "shop")
public class Shop implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	Long shopId;

	@Column(name = "shop_name", nullable = false)
	String name;

	@Column(name = "address", nullable = false)
	String address;
}
