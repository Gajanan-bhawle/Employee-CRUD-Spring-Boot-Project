package com.velocity.service;

import java.util.List;
import java.util.Optional;

import com.velocity.model.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();

	Optional<Employee> getEmployeeById(int id);

	Employee saveEmployee(Employee employee);

	void deleteEmployee(int id);

	Employee updateEmployee(int id);

}
