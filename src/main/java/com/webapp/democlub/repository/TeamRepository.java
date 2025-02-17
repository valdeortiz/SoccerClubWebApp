package com.webapp.democlub.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.webapp.democlub.domain.Team;

@RepositoryRestResource(collectionResourceRel = "team", path = "team")
public interface TeamRepository extends PagingAndSortingRepository<Team, Long> {
	public List<Team> findByDivision(String division);
	public Team findByName(String name);
	
	
	
}
