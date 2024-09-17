package com.example.thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.thymeleaf.model.Employee;
import com.example.thymeleaf.service.EmployeeService;

@Controller

public class EmployeeController {
	
	@Autowired
	private EmployeeService empServ;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listEmployees", empServ.getAllEmployees());
		return "index";
	}
	
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		Employee emp = new Employee();
		
		model.addAttribute("employee",emp);
		return "new_employee";
	}
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee emp) {
		empServ.saveEmployee(emp);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value="id") long id,Model model) {
		Employee empl = empServ.getEmployeeByID(id);
		model.addAttribute("employee",empl);
		return "update_employee";
		
	}
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable long id) {
		
		empServ.deleteEmployeeById(id);
		return "redirect:/";
	}
	
}
