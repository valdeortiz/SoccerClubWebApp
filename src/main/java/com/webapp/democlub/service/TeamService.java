package com.webapp.democlub.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.democlub.domain.Employee;
import com.webapp.democlub.domain.Organization;
import com.webapp.democlub.domain.Player;
import com.webapp.democlub.domain.Team;
import com.webapp.democlub.domain.Tournament;
import com.webapp.democlub.exception.InscripcionException;
import com.webapp.democlub.repository.OrganizationRepository;
import com.webapp.democlub.repository.TeamRepository;
import com.webapp.democlub.repository.TournamentRepository;

@Service
public class TeamService {

	@Autowired
	private TeamRepository teamRepository;
		
	@Autowired
	private OrganizationRepository orgRepository;
	
	@Autowired
	private TournamentRepository tournamentRepository;
	
		
	public Team findById(Long id) {
		Team team = teamRepository.findById(id).orElse(null);
		return team;
	}
	public List<Team> findByDivision(String div) {
		List<Team> team = teamRepository.findByDivision(div);
		return team;
	}
	public List<String> average(String name) {
		Team team = teamRepository.findByName(name);
		List<Player> playes = team.getPlayers();
		List<Employee> employs = team.Empleados();
		List<String> resul = new ArrayList<>();
		resul.add("---> Equipo " + team.getName() + ": " + team.getSalary_average());
		resul.add("** Nombre ** : ** salario promedio **");
		resul.add("******************************************************");
		for (Player player : playes) {
			resul.add(player.getFirstName() + " " + player.getLastName() + ": " + player.getAverage_salary());
		}
		resul.add(team.DtObj().getFirstName() + " " + team.DtObj().getLastName() + ": " + team.DtObj().getAverage_salary());
		for (Employee employee : employs) {
			resul.add(employee.getFirstName() + " " + employee.getLastName() + ": "+ employee.getAverage_salary());
		}
		return resul;
	}

	
	public List<Team> findAll() {
		List<Team> teams = new ArrayList<>();
		Iterator<Team> iteratorTeams = teamRepository.findAll().iterator();
		while (iteratorTeams.hasNext()) {
			teams.add(iteratorTeams.next());
		}
		return teams;
	}
	
	public Team save(Team team)throws InscripcionException {
		//int cont = 0;
//		for (Player player : this.getPlayers() ) {
//			if(player.getId() == dt.getId() ) {
//			//	cont = 1;
//				System.out.println("Existe el dt en el team");
//			}
//		}
//		if (dt.getTrophies_number() < 1) {
//			InscripcionException inscripcionException =  new InscripcionException(
//					"No se permite la inscripción para jugadores con menos de 1 titulo ganado con el club: " + dt.getTrophies_number());
//			inscripcionException.setContacto("contacto@gmail.com");
//		}
		
		Tournament tourn = tournamentRepository.findByName(team.getTournament());
		Team equipo = teamRepository.findByName(team.getName());
		
		if (tourn == null || equipo != null) {
			InscripcionException inscripcionException =  new InscripcionException(
					"Asegurese de que escribio correctamente el TORNEO o que el nombre del equipo no existe: ");
			inscripcionException.setContacto("contacto@gmail.com");
			System.err.println("tourn o equipo es null");
			throw inscripcionException;
		}else {
			if (team.DtObj() != null) {
				throw new RuntimeException("Para poder registrar un dt, haga post a /dt. con el nombre del equipo");
			}
			if (tourn.getType() == "internacional") {
				throw new RuntimeException("No se puede inscribir de esta manera a una competencia internacional, realice un put a tournament");
			}
			List<Team> teamsav = findAll();
			Double av = 0.0;
			for (Team team2 : teamsav) {
				av += team2.getSalary_average();
			}
			av = av + 0.2*av + 0.3*1.2*av; // es el prom de sueldos mas el 20% que se puede pasar mas los  impuestos
			if (team.getSalary_average() > av && av != 0.0) { //team.getSalary_average() != null &&
				Double impuesto = impLujo(team.getSalary_average(), av);
				if (impuesto == 0.0) {
					System.err.println("EL salario es mas alto que 2xProm " + team.getAnnual_salary());
					throw new RuntimeException("EL salario es mas alto que 2xProm " + team.getAnnual_salary());
					//lanzar la exception
				}else {
					List<Organization> ongs = team.orgObj();
					if (ongs.isEmpty()) {
						ongs.add(orgRepository.findByName("ong secundaria"));
					}
					team.salaryDiscount(impuesto); // verificar
					
					Double money = impuesto / ongs.size();
					for (Organization organization : ongs) {
						Organization ong = orgRepository.findByName(organization.getName());
						if (ong != null && ong.getYearOld() > 5) {
							ong.addteam(team);
							ong.addMoney(money);
							System.out.println("La ong fue beneficiada con: " + money);
							team.setOrgs(ongs);
						}else {
							System.err.println("La org no existe o es muy reciente: " + ong.getName());
						}
					}
				
				}
				
				System.err.println("EL salario prom es muy alto. Lujo:" + impuesto);
			}
			tourn.addTeam(team);
			team.setTournament(tourn);
			return teamRepository.save(team);
		}
			
		
	}
	
	public Double impLujo(Double salary, Double average){
		System.out.println("salary: " + salary + "av: " + average);
		if(salary < average*2) {
			return salary * 0.3;
		}else {
			return 0.0;
		}
		
	}

	public void delete(Long id) {
		teamRepository.deleteById(id);
	}

	public void deleteAll() {
		teamRepository.deleteAll();
	}

}
