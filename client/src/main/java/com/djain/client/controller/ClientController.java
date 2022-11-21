package com.djain.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.djain.client.model.Employee;
import com.djain.client.service.ClientService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ClientController {
	
	@Autowired
	ClientService cs;
	
	@PostMapping("/client")
	public Employee showdetails(@RequestBody Employee emp){
		log.info("inside client controller");
		return cs.showdetails(emp);
	}
	
	@GetMapping("/get/{emp}")
	public Employee getdetails(@PathVariable("emp") Integer empid) {
		log.info("inside get controller 1");
		return cs.getdetails(empid);
	}
}
