package ru.kudrin.estore.entity;

import java.time.LocalDate;

import javax.persistence.*;

import lombok.*;

@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "lastname", nullable = false, length = 100)
	private String lastName;

	@Column(name = "firstname", nullable = false, length = 100)
	private String firstName;

	@Column(name = "patronymic", nullable = false, length = 100)
	private String patronymic;

	@Column(name = "birthdate", nullable = false)
	private LocalDate birthDate;

	@Column(name = "position_id", nullable = false)
	private Long positionId;

	@Column(name = "shop_id", nullable = false)
	private Long shopId;

	@Column(name = "gender", nullable = false)
	private boolean gender;
}