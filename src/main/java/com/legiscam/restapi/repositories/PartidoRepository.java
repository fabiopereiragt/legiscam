package com.legiscam.restapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.legiscam.restapi.models.Partido;;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Long> {

}
