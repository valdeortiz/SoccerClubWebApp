package com.webapp.democlub.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.webapp.democlub.domain.Dt;

@RepositoryRestResource(collectionResourceRel = "dt", path = "dt")
public interface DtRepository extends PagingAndSortingRepository<Dt, Long> {
	
}
