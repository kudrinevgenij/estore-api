package ru.kudrin.estore.entity;

import java.time.LocalDate;

import javax.persistence.*;

import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "store_employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id_;

	@Column(name = "lastname", nullable = false, length = 100)
	private String lastName;

	@Column(name = "firstname", nullable = false, length = 100)
	private String firstName;

	@Column(name = "patronymic", nullable = false, length = 100)
	private String patronymic;

	@Column(name = "birthDate", nullable = false)
	private LocalDate birthDate;

	@Column(name = "positionId", nullable = false)
	private Long positionId;

	@Column(name = "gender", nullable = false)
	private boolean gender;
}