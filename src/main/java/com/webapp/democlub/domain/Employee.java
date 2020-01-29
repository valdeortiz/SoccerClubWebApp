package com.webapp.democlub.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee extends Person{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String profession;
	private Float salary;
	private Float net_salary;
	private Float average_salary;
	

	public Float getAverage_salary() {
		average_salary = salary / 12;
		return average_salary;
	}

	public void setAverage_salary(Float average_salary) {
		
		this.average_salary = average_salary;
	}

	public Float impuestoCalc(){
		// calculamos el monto de impuestos de cada empleado.
		// y retornamos el salary neto
		return this.net_salary;
	}

	public void setSalary(Float salary){
		this.salary = salary;
	}
	
	public Float getSalary(){
		return salary;
	}

	public void setProfession(String profession){
		this.profession = profession;
	}
	
	public String getProfession(){
		return profession;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
