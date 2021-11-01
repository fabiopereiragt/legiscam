package com.legiscam.restapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.legiscam.restapi.models.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {
	
	Pais findByNome(String nome);
}
