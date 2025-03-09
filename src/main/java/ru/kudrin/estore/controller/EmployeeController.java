package ru.kudrin.estore.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.tags.Tag;
import ru.kudrin.estore.dto.EmployeePayload;
import ru.kudrin.estore.entity.Employee;
import ru.kudrin.estore.service.EmployeeService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@Tag(name = "Employee", description = "Сервис для выполнения операций над сотрудниками магазина")
@RequestMapping("/estore/api/employees")
@RequiredArgsConstructor
public class EmployeeController {
	private final EmployeeService service;

	@GetMapping
	public List<Employee> findAll() {
		return  service.findAll();
	}

	@GetMapping("/{id}")
	public Employee findById(@PathVariable("id") long id) {
		return  service.findEmployee(id).orElseThrow(() -> new NoSuchElementException("Работник не найден."));
	}

	@PostMapping
	public ResponseEntity<Employee> createEmployee(@RequestBody EmployeePayload payload) {
		Employee employee = service.createEmployee(payload.getFirstName(), payload.getLastName(), payload.getPatronymic(),
				payload.getBirthDate(), payload.getPositionId(), payload.getShopId(), payload.getGender());
		return ResponseEntity.ok(employee);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Void> updateEmployee(@PathVariable("id") long id, @RequestBody EmployeePayload payload) {
		service.updateEmployee(id, payload.getFirstName(), payload.getLastName(), payload.getPatronymic(),
				payload.getBirthDate(), payload.getPositionId(), payload.getShopId(), payload.getGender());
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable("id") long id) {
		service.deleteEmployee(id);
		return ResponseEntity.noContent().build();
	}
}