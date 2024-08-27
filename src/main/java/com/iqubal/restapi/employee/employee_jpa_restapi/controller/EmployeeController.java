package com.iqubal.restapi.employee.employee_jpa_restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.iqubal.restapi.employee.employee_jpa_restapi.Entity.Employee;
import com.iqubal.restapi.employee.employee_jpa_restapi.repository.EmployeeRepository;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeRepository emprepository;

	// get All the employee
	// localhost:8080/employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployes() {
		List<Employee> employees = emprepository.findAll();
		return employees;
	}

	// GetEmployee by empid
	// localhost:8080/employees/1
	@GetMapping("/employees/{empId}")
	public Employee getEmployee(@PathVariable long empId) {
		Employee emp = emprepository.findById(empId).get();
		return emp;

	}
	@PostMapping("/employee/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void saveEmployee(@RequestBody Employee employee) {
		emprepository.save(employee);
		
	}
	
	@PutMapping("/employee/update/{empId}")
	 public Employee updateEmployee(@PathVariable long empId){
		Employee employee=emprepository.findById(empId).get();
		
		employee.setFirstName("wani");
		employee.setLastName("Iqbal");
		employee.setEmail("wani.iqubal@gmail.com");
		emprepository.save(employee);
		 return employee;
	 }
	
	// Delete employee based on id 
	@DeleteMapping("/employee/delete/{empId}")
	public void deleteEmployee(@PathVariable long empId) {
		
		//emprepository.deleteById(empId);
		Employee employee=emprepository.findById(empId).get();
		emprepository.delete(employee);
	}

}
