package com.webapp.democlub.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.webapp.democlub.domain.Organization;
/*Importamos paginAndSorting para poder usar los servicios crud en nuestro service/controller */
@RepositoryRestResource(collectionResourceRel = "organization", path = "organization")
public interface OrganizationRepository extends PagingAndSortingRepository<Organization, Long> {
	public Organization findByName(String name);
	
}
