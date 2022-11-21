package com.djain.client.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import com.djain.client.model.Employee;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ClientService {
	RestTemplate restTemplate = new RestTemplate();
	
	public Employee showdetails(Employee emp) {
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		Map<String, String> map = new HashMap<String, String>();
		//map.put("Content-Type", "application/json");
		headers.setAll(map);
		HttpEntity<?> httprequest = new HttpEntity<>(emp, headers);
		log.info("5");
		return restTemplate.postForEntity("http://localhost:8080/employee/create", httprequest, Employee.class).getBody();
	}

	public Employee getdetails(Integer emp) {
		return restTemplate.getForEntity("http://localhost:8080/employee/get/"+emp, Employee.class).getBody();
		
	}
	
	 
	
}
