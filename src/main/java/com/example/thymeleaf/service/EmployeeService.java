package com.example.thymeleaf.service;

import java.util.List;

import com.example.thymeleaf.model.Employee;

public interface EmployeeService {
	
	List<Employee> getAllEmployees();
	void saveEmployee(Employee emp);
	Employee getEmployeeByID(long id);
	void deleteEmployeeById(long id);

}
