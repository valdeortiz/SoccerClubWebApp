package com.webapp.democlub.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee extends Person{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String profession;
	private Integer salario;
	private Integer net_salary;
	private Integer average_salary;
	
	
	public Integer getAverageSalary() {
		return average_salary;
	}

	public void setAverageSalary(Integer average_salary) {
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

	
	public void getId(long id){
		this.id = id;
	}
	
	public long getId(){
		return id;
	}
	
}
