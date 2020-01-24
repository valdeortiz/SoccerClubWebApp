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
	private Integer salario;
	private Integer net_salary;
	private Integer average_salary;
	

	public Integer getAverage_salary() {
		return average_salary;
	}

	public void setAverage_salary(Integer average_salary) {
		this.average_salary = average_salary;
	}

	public Integer impuestoCalc(){
		// calculamos el monto de impuestos de cada empleado.
		// y retornamos el salario neto
		return this.net_salary;
	}

	public void getSalario(Integer salario){
		this.salario = salario;
	}
	
	public Integer getSalario(){
		return salario;
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
