package com.webapp.democlub.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.webapp.democlub.domain.Tournament;

@RepositoryRestResource(collectionResourceRel = "tournament", path = "tournament")
public interface TournamentRepository extends PagingAndSortingRepository<Tournament, Long> {
}
