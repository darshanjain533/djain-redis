package com.djain.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.djain.employee.exception.ResourceNotFoundException;
import com.djain.employee.model.Employee;
import com.djain.employee.repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeService {

	@Autowired
	EmployeeRepository er;
	
	public Employee createEmployee(Employee e) {
		log.info("inside service");
		return er.save(e);
	}
	
	public List<Employee> getEmployees() {
		log.info("inside get employess service");
		return er.findAll();
	}
	
	public Employee updateEmployee(Employee e, String empname) {
		Employee emp = er.findByEname(empname).orElseThrow(() -> new ResourceNotFoundException("TheatreName does not exists"));
		emp.setEdays(e.getEdays());
		emp.setEname(e.getEname());
		emp.setEphone(e.getEphone());
		return er.save(emp);
	}
	
	public void deleteEmployee(String empname) {
		er.deleteByEname(empname);
	}

	public Optional<Employee> getEmployeesbyid(Integer id) {
		return er.findById(id);
	}

}
