package com.webapp.democlub.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.webapp.democlub.domain.Jugador;

@RepositoryRestResource(collectionResourceRel = "jugador", path = "jugador")
public interface JugadorRepository extends PagingAndSortingRepository<Jugador, Long> {
}
