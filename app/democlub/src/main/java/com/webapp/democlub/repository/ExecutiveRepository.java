package com.webapp.democlub.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.webapp.democlub.domain.Executive;
/*Importamos paginAndSorting para poder usar los servicios crud en nuestro service/controller */
@RepositoryRestResource(collectionResourceRel = "executive", path = "executive")
public interface ExecutiveRepository extends PagingAndSortingRepository<Executive, Long> {
}
