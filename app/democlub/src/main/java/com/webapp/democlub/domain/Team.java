package com.webapp.democlub.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Team{
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String division;
	private String name;
	private Integer salary_prom;	
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}

	public void setDivision(String division){
		this.division = division;
	}
	
	public String getDivision(){
		return division;
	}

	
	public void setId(long id){
		this.id = id;
	}
	
	public long getId(){
		return id;
	}

	public Integer getSalary_prom() {
		return salary_prom;
	}

	public void setSalary_prom(Integer salary_prom) {
		this.salary_prom = salary_prom;
	}

	
}
