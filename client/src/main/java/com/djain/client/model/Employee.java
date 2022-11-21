package com.djain.client.model;

import lombok.Data;


@Data
public class Employee {
	Integer eid;
	String ename;
	String edays;
	String ephone;
	
	public Employee(String ename, String edays, String ephone) {
		this.ename = ename;
		this.edays = edays;
		this.ephone = ephone;
	}
	
}
