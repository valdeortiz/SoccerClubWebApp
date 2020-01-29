package com.webapp.democlub;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.webapp.democlub.domain.Dt;
import com.webapp.democlub.domain.Player;
import com.webapp.democlub.domain.Team;

@SpringBootTest
class DemoclubApplicationTests {

	@Test
	void contextLoads() {
		Dt dt = new Dt();
		dt.setFirstName("loko");
		dt.setAverage_salary((float)1232465.00);
		//dt.setHability(5);
		dt.setLastName("Rami");
		List<Player> jugadoresEquipo1 = new ArrayList<>();
		Player juga = new Player();
		juga.setFirstName("oola");
		juga.setPosition("Arquero");
		juga.setSalary((float)12000.00);
		jugadoresEquipo1.add( juga);
		
		Team equipo1 = new Team();
		equipo1.setDivision("Primera");
		equipo1.setName("Equipo1");
		equipo1.setSalary_prom(367000);
		equipo1.setPlayers(jugadoresEquipo1);
		
		
	}

}
