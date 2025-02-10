package ru.kudrin.estore.entity;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "store_employee")
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_", unique = true, nullable = false)
	Long id_;

	@Column(name = "lastname", nullable = false, length = 100)
	String lastName;

	@Column(name = "firstname", nullable = false, length = 100)
	String firstName;

	@Column(name = "patronymic", nullable = false, length = 100)
	String patronymic;

	@Column(name = "birthDate", nullable = false)
	Date birthDate;

	@Column(name = "positionId", nullable = false)
	Long positionId;

	@Column(name = "gender", nullable = false)
	boolean gender;
}