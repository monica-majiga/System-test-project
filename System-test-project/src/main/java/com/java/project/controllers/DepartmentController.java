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

import com.java.project.model.Department;
import com.java.project.services.DepartmentServices;

@RestController
public class DepartmentController {
	@Autowired
	DepartmentServices departmentServices;

	@GetMapping(value = "/departments")
	public List<Department> getDepartments() {
		return departmentServices.findAllDepartments();
	}

	@PostMapping(value = "/departments")
	public ResponseEntity<?> save(@RequestBody Department department) {
		try {
			departmentServices.saveDepartment(department);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/departments/{id}")
	public void delete(@PathVariable Long id) {
		departmentServices.deleteDepartment(id);
	}

	@PutMapping("/departments/{id}")
	public ResponseEntity<?> update(@RequestBody Department department, @PathVariable Long id) {
		try {
			Department existDepartment = departmentServices.findById(id);
			departmentServices.saveDepartment(department);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
