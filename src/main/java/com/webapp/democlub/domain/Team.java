package com.webapp.democlub.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Team{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String division;
	@Column(nullable = false, unique = true)
	private String name;
	private Double annual_salary;
	private Double salary_average;
	private Integer tournamentPosicion;
	@OneToMany(mappedBy="team",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Player> players;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tournament_id")
	private Tournament tournament;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="dt_id")
	private Dt dt; // quitar cascada para no eliminar dt al eliminar team
	// guardar en la lista de employee asi no creamos otra columna 
	
	@ElementCollection
	private List<Employee> empleados = new ArrayList<>();
	
	@ManyToMany
	@JoinColumn(name="org_id")
	private List<Organization> orgs = new ArrayList<>();
	
	// **************************************************************************
	
	public void setDt(Dt dt) {
		//dt.setTeam(this);
		
		players.remove(dt);
		
		this.dt = dt;
	}
	
	public boolean isPlayer(Player dt) {
		return players.contains(dt);
	}
	
	public Integer getTournamentPosicion() {
		return tournamentPosicion;
	}

	public void setTournamentPosicion(Integer tournamentPosicion) {
		this.tournamentPosicion = tournamentPosicion;
	}

	public void salaryDiscount(Double discount) {
		if (annual_salary != null) {
			this.annual_salary -= discount; 
		}else {
			this.annual_salary = salaryCalc();
			this.annual_salary -= discount;
		}
		
	}
	public List<Organization> orgObj(){
		return orgs;
	}
	public List<String> getOrgs() {
		List<String> resul = new ArrayList<>();
		for (Organization organization : orgs) {
			resul.add(organization.getName());
		}
		return resul;
	}

	public void setOrgs(List<Organization> orgs) {
		this.orgs = orgs;
	}

	public void addEmployee(Employee employee) {
		if (!empleados.contains(employee)) {
			empleados.add(employee);
		}else {
			System.err.println("Ya existe el empleado");
		}
	}
	public List<String> getEmpleados() {
		List<String> resul = new ArrayList<>();
		for (Employee employee : empleados) {
			resul.add(employee.getFirstName() + " " + employee.getLastName() + " - " + employee.getProfession());
		}
		return resul;
	}
	
	public List<Employee> Empleados() {
		return empleados;
	}

	public void setEmpleados(List<Employee> empleados) {
		for (Employee employee : empleados) {
			addEmployee(employee);
		}
	}
	public void setSalary_average(Double salary_average) {
		if (salary_average != null) {
			this.salary_average = salary_average;
		}else {
			this.salary_average = calcAv();
		}
		
	}
	
	public Double getAnnual_salary() {
		if (annual_salary == null) {
			return salaryCalc();
		}else {
			return annual_salary;
		}
		
	}

	public void setAnnual_salary(Double annual_salary) {
		if (annual_salary != null) {
			this.annual_salary = annual_salary;
		}else {
			this.annual_salary = salaryCalc();
		}
		
	}
	public Double salaryCalc() {
		Double suma = 0.0;
		for (Player player : players) {
			suma += player.getSalary();
		}
		for (Employee employee : empleados) {
			suma += employee.getSalary();
		}
		if (dt != null) {
			suma += dt.getSalary();
		}
		return suma;
	}
	
	public Double calcAv() {
		Double suma = salaryCalc();
		Double nEmployee = (double)empleados.size() + (double)players.size() + 1;
		salary_average = suma/nEmployee ;
		return salary_average;
	}
	
	public Double getSalary_average() {
		if (salary_average == null) {
			return calcAv();
		}else {
			return salary_average;
		}
		
	}
		
	public String getDt() {
		if (dt != null) {
			return dt.getFirstName()+ " " + dt.getLastName();
		}else {
			return "no dt";
		}
		
	}
	public Dt DtObj() {
		
		return this.dt;
	}
	
	public String getTournament() {
		if(tournament != null) {
			return tournament.getName();	
		}else {
			return "not tournament";
		}
		
	}
	public Tournament tournamentObj() {
		return this.tournament;
	}
	
	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}
//*********************************************************
	public Team() {
		players = new ArrayList<>();
	}
	
	public void addPlayer(Player player) {
		if (!players.contains(player)) {
			players.add(player);
			player.setTeam(this);
		}	
	}
	public List<Player> getPlayers() {
		return players;
	}
	
	public void setPlayers(List<Player> players) {
		for(Player i : players) {
			addPlayer(i);
		}
		this.players = players;
	}

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

	
	public void setId(Long id){
		this.id = id;
	}
	
	public Long getId(){
		return id;
	}

	
}
