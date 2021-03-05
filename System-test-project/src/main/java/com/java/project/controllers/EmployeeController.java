package com.java.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.project.model.Employee;
import com.java.project.services.EmployeeServices;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeServices employeeServices;

	@GetMapping(value = "/employees")
	public List<Employee> getEmployees() {
		return employeeServices.findAllEmployees();
	}

	@PostMapping(value = "/employees")
	public ResponseEntity<?> save(@RequestBody Employee employee) {
		try {
			employeeServices.saveEmployee(employee);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/employees/{id}")
	public void delete(@PathVariable Long id) {
		employeeServices.deleteEmployee(id);
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<?> update(@RequestBody Employee employee, @PathVariable Long id) {
		try {
			Employee existEmployee = employeeServices.findById(id);
			employeeServices.saveEmployee(employee);;
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
