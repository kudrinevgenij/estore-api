package ru.kudrin.estore.entity;

import javax.persistence.*;

import lombok.*;

@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "shop")
public class Shop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	Long shopId;

	@Column(name = "name", nullable = false)
	String name;

	@Column(name = "address", nullable = false)
	String address;
}