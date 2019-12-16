package com.webapp.democlub.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Average{
	
	private Integer salary_av;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	public void Average(Integer salary_av) {
		this.salary_av = salary_av; 
	}
	
	public Integer getPromedio(){
		return salary_av;
	}
	
}
