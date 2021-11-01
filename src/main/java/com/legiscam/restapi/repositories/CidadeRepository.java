package com.legiscam.restapi.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.legiscam.restapi.models.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
	
	@Query("select c from Cidade as c inner join Estado as e on e.id = c.estado.id " +
			"where e.pais.id = :idPais")
	List<Cidade> findByPais(@Param("idPais") long idPais);
	
	@Query("select c from Cidade as c where c.estado.nome = :nomeEstado")
	List<Cidade> findByNomeEstado(@Param("nomeEstado") String nomeEstado);
	
	@Query("select c from Cidade as c where c.estado.id = :idEstado")
	List<Cidade> findByIdEstado(@Param("idEstado") long idEstado);
	
	Cidade findByNome(String nome);
}
