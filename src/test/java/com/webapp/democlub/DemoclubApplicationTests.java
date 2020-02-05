package com.webapp.democlub;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.webapp.democlub.domain.Association;
import com.webapp.democlub.domain.Employee;
import com.webapp.democlub.domain.Organization;
import com.webapp.democlub.domain.Player;
import com.webapp.democlub.domain.Team;
import com.webapp.democlub.domain.Tournament;
import com.webapp.democlub.repository.AssociationRepository;
import com.webapp.democlub.repository.OrganizationRepository;
import com.webapp.democlub.repository.TeamRepository;
import com.webapp.democlub.repository.TournamentRepository;

@SpringBootTest
class DemoclubApplicationTests {
	
	@Autowired
	private TournamentRepository repo;
	
	@Autowired
	private TeamRepository teamrepo;
	
	@Autowired
	private OrganizationRepository orgRepo;
	
	@Autowired
	private AssociationRepository asrepo;
//	@Test
//	void contextLoads() {
//		Dt dt = new Dt();
//		dt.setFirstName("loko");
//		dt.setAverage_salary((float)1232465.00);
//		//dt.setHability(5);
//		dt.setLastName("Rami");
//		List<Player> jugadoresEquipo1 = new ArrayList<>();
//		Player juga = new Player();
//		juga.setFirstName("oola");
//		juga.setPosition("Arquero");
//		juga.setSalary((float)12000.00);
//		jugadoresEquipo1.add( juga);
//		
//		Team equipo1 = new Team();
//		equipo1.setDivision("Primera");
//		equipo1.setName("Equipo1");
//		equipo1.setSalary_prom(367000);
//		equipo1.setPlayers(jugadoresEquipo1);
//		
//		
//	}
	
	@Test
	void crearTorneos() {
		
		Team equipo1 = new Team();
		equipo1.setDivision("Primera");
		equipo1.setName("Equipo1");
		equipo1.setSalary_average(20000.0);
		List<Player> jugadoresEquipo1 = new ArrayList<>();
		Player jug = new Player();
		jug.setFirstName("mario");
		jug.setHability(60);
		jug.setLastName("Todeo");
		jug.setPosition("medio campo");
		jug.setSalary(20000.0);
		jug.setTeam(equipo1);
		jug.setTrophies_number(9);
		jugadoresEquipo1.add(jug);
		equipo1.setPlayers(jugadoresEquipo1);
		equipo1.setTournamentPosicion(1);
		teamrepo.save(equipo1);
		
		Team team = new Team();
		team.setName("sin team");
		
		Association asociacion = new Association();
		asociacion.setName("aso de empleados");
		asociacion.setType("empleados");
		List<Employee> members = new ArrayList<>();
		asociacion.setMembers(members);
		asrepo.save(asociacion);
		
		Organization ong = new Organization();
		ong.setName("ong Principal");
		//ong.setType("ong");
		ong.setYearOld(7);
		orgRepo.save(ong);
		
		Organization ong2 = new Organization();
		ong2.setName("ong secundaria");
		//ong2.setType("ong2");
		ong2.setYearOld(3);
		orgRepo.save(ong2);
		
		Tournament apertura = new Tournament();
		apertura.setName("nacionales de primera");
		apertura.setType("profesionalNacional");
		repo.save(apertura);
		
		Tournament ascenso = new Tournament();
		ascenso.setName("nacionales de ascenso");
		ascenso.setType("inferiores");
		repo.save(ascenso);
		
		Tournament internacionales = new Tournament();
		internacionales.setName("internacionales");
		internacionales.setType("internacional");
		internacionales.setWinner("equipo 1");
		repo.save(internacionales);
		
		Tournament copa = new Tournament();
		copa.setName("copa de la liga");
		copa.setType("copa");
		repo.save(copa);
		
	}

}
