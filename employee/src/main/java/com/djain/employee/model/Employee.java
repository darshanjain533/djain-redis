package com.djain.employee.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


@Data
@Entity
public class Employee  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer eid;
	String ename;
	String edays;
	String ephone;
}
