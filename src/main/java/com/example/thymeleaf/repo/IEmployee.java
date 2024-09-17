package com.example.thymeleaf.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.thymeleaf.model.Employee;
@Repository	
public interface IEmployee extends JpaRepository<Employee, Long> {

}
