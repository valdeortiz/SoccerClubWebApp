package com.webapp.democlub;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.webapp.democlub.domain.Association;
import com.webapp.democlub.domain.Tournament;
import com.webapp.democlub.repository.TournamentRepository;

@SpringBootTest
class DemoclubApplicationTests {
	
	@Autowired
	private TournamentRepository repo;
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
		
		Association asociacion = new Association();
		asociacion.setName("Aso de empleados");
		asociacion.setType("empleados");
		
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
		internacionales.setType("profesionalInternacional");
		repo.save(internacionales);
		
		Tournament copa = new Tournament();
		copa.setName("copa de la liga");
		copa.setType("copa");
		repo.save(copa);
		
	}

}
