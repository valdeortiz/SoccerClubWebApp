package com.webapp.democlub.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.webapp.democlub.domain.Directivo;

@RepositoryRestResource(collectionResourceRel = "directivo", path = "directivo")
public interface DirectivoRepository extends PagingAndSortingRepository<Directivo, Long> {
}
