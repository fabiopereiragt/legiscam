package com.legiscam.restapi.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.legiscam.restapi.models.Bairro;

@Repository
public interface BairroRepository extends JpaRepository<Bairro, Long> {
	
	@Query("select b from Bairro as b where b.cidade.nome = :nomeCidade")
	List<Bairro> findByCidadeNome(@Param("nomeCidade") String nomeCidade);
	
	@Query("select b from Bairro as b where b.cidade.id = :cidadeId")
	List<Bairro> findByCidadeId(@Param("cidadeId") long cidadeId);
	
	Bairro findByNome(String nome);
}
