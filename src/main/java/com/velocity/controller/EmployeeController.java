package com.velocity.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.velocity.model.Employee;
import com.velocity.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@GetMapping
	public List<Employee> getAllEmployee() {
		return service.getAllEmployees();
	}

	@GetMapping("/emp{id}")
	public Optional<Employee> getEmployeeById(@PathVariable int id) {
		return service.getEmployeeById(id);
	}

	@PostMapping
	public Employee saveEmployee(@RequestBody Employee employee) {
		return service.saveEmployee(employee);
	}

	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable int id, @RequestBody Employee updateEmployee) {
		Employee existingEmployee = service.getEmployeeById(id).get();

		if (existingEmployee != null) {

			existingEmployee.setFirstname(updateEmployee.getFirstname());
			existingEmployee.setLastname(updateEmployee.getLastname());
			existingEmployee.setEmail(updateEmployee.getEmail());
			existingEmployee.setDepartment(updateEmployee.getDepartment());
			existingEmployee.setSalary(updateEmployee.getSalary());
			return service.saveEmployee(existingEmployee);
		}
		return null;
	}

	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable int id) {
		service.deleteEmployee(id);
	}

}
