package ru.kudrin.estore.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import ru.kudrin.estore.controller.payload.EmployeePayload;
import ru.kudrin.estore.controller.payload.ProductPayload;
import ru.kudrin.estore.entity.ElectroItem;
import ru.kudrin.estore.entity.Employee;
import ru.kudrin.estore.repository.EmployeeRepository;
import ru.kudrin.estore.service.EmployeeService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@Tag(name = "Employee", description = "Сервис для выполнения операций над сотрудниками магазина")
@RequestMapping("/estore/api/employee")
@RequiredArgsConstructor
public class EmployeeController {
	private final EmployeeService service;

	@GetMapping("/find-all")
	public List<Employee> findAll() {
		return  service.findAll();
	}

	@GetMapping("/find/{id}")
	public Employee findById(@PathVariable("id") long id) {
		return  service.findEmployee(id).orElseThrow(() -> new NoSuchElementException("Работник не найден."));
	}

	@PostMapping("/create")
	public ResponseEntity<Employee> createEmployee(@RequestBody EmployeePayload payload) {
		Employee product = service.createEmployee(payload.getFirstName(), payload.getLastName(), payload.getPatronymic(),
				payload.getBirthDate(), payload.getPositionId(), payload.getGender());
		return ResponseEntity.ok(product);
	}

	@PostMapping("/update/{id}")
	public ResponseEntity<Void> updateEmployee(@PathVariable("id") long id, @RequestBody EmployeePayload payload) {
		service.updateEmployee(id, payload.getFirstName(), payload.getLastName(), payload.getPatronymic(),
				payload.getBirthDate(), payload.getPositionId(), payload.getGender());
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable("id") long id) {
		service.deleteEmployee(id);
		return ResponseEntity.noContent().build();
	}

}