package com.webapp.democlub.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.webapp.democlub.domain.Team;

@RepositoryRestResource(collectionResourceRel = "tournament", path = "tournament")
public interface TorneoRepository extends PagingAndSortingRepository<Team, Long> {
}
