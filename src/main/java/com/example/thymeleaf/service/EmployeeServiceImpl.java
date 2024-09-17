package com.example.thymeleaf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.thymeleaf.model.Employee;
import com.example.thymeleaf.repo.IEmployee;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private IEmployee repo;
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void saveEmployee(Employee emp) {
		// TODO Auto-generated method stub
		repo.save(emp);
	}

	@Override
	public Employee getEmployeeByID(long id) {
		// TODO Auto-generated method stub
		Optional<Employee>  optional = repo.findById(id);
		Employee emp;
		if(optional.isPresent()) {
			emp = optional.get();
		}else {
			throw new RuntimeException("ID not found");
		}
		
		return emp;
	}

	@Override
	public void deleteEmployeeById(long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);

	}

}
