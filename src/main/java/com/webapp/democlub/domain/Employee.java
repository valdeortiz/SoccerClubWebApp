package com.webapp.democlub.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Employee extends Person{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String profession;
	private Double salary;
	private Double net_salary;
	private Double average_salary;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "association_id")
	private Association association;
	
	private String teamName;
		
	public String getTeam() {
		return teamName;
	}
	
	public void setTeamName(String team) {
		this.teamName = team;
	}

	public String getAssociation() {
		if (association != null) {
			return association.getName();
		}else {
			return "Not Association";
		}
		
	}

	public void setAssociation(Association association) {
		this.association = association;
	}

	public Double getAverage_salary() {
		average_salary = salary / 12;
		return average_salary;
	}

//	public void setAverage_salary(Double average_salary) {
//		
//		this.average_salary = average_salary;
//	}

	public Double impuestoCalc(Double salary){
		// calculamos el monto de impuestos de cada empleado.
		// y retornamos el salary neto para guardar en la variable salario
		net_salary = salary - salary*0.4 - salary*0.2; // descontamos el impuesto por tecn(4%) y prom(2%)
		net_salary -= net_salary*0.1; // IRP del 10% sobre prom y tecn 
		return this.net_salary;
	}

	public void setSalary(Double salary){
		this.salary = impuestoCalc(salary);
	}
	
	public Double getSalary(){
		
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
