package com.webapp.democlub.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.webapp.democlub.domain.Association;
/*Importamos paginAndSorting para poder usar los servicios crud en nuestro service/controller */
@RepositoryRestResource(collectionResourceRel = "association", path = "association")
public interface AssociationRepository extends PagingAndSortingRepository<Association, Long> {
}
