package com.djain.employee.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.djain.employee.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	Optional<Employee> findByEname(String empname);
	long deleteByEname(String empname);
}
