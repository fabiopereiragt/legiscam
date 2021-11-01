package com.legiscam.restapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.legiscam.restapi.models.Estado;


@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {
	
	Estado findByNome(String nome);
	
	@Query("select e from Estado as e where e.pais.nome = :nomePais")
	List<Estado> findByNomePais(@Param("nomePais") String nomePais);
	
	@Query("select e from Estado as e where e.pais.id = :idPais")
	List<Estado> findByIdPais(@Param("idPais") long idPais);
}
