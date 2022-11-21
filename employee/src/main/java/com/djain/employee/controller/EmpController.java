package com.djain.employee.controller;

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

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import com.djain.employee.model.Employee;
import com.djain.employee.service.EmployeeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
public class EmpController {

	@Autowired
	EmployeeService eserv;
	
	private static final Logger log = LogManager.getLogger(EmpController.class);
	
	@PostMapping("/employee/create")
	public Employee createEmployee(@Valid @RequestBody Employee e) {
		log.info("inside create employee"+e.getEname());
		return eserv.createEmployee(e);
	}
	
	@GetMapping("/employee/get")
	public List<Employee> getEmployee(){
		log.info("inside get employees");
		return eserv.getEmployees();
	}
	
	@GetMapping("/employee/get/{id}")
	public Employee getEmployeebyId(@PathVariable("id") Integer id){
		log.info("inside get employeesbyid");
		Employee e = eserv.getEmployeesbyid(id).get();
		log.info("employee is:::"+e);
		return eserv.getEmployeesbyid(id).get();
	}
	
	@PutMapping("/employee/update/{empname}")
	public Employee updateEmployee(@PathVariable("empname") String empname, @RequestBody Employee e) {
		log.info("employee update called");
		return eserv.updateEmployee(e, empname);
	}
	
	@DeleteMapping("/employee/delete/{empname}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("empname") String empname){
		eserv.deleteEmployee(empname);
		return new ResponseEntity<>("Emploee deleted.",HttpStatus.OK);
	}
	
}