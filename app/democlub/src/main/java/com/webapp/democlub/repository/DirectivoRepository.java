package com.webapp.democlub.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.webapp.democlub.domain.Directivo;
/*Importamos paginAndSorting para poder usar los servicios crud en nuestro service/controller */
@RepositoryRestResource(collectionResourceRel = "directivo", path = "directivo")
public interface DirectivoRepository extends PagingAndSortingRepository<Directivo, Long> {
}
