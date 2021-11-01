package com.legiscam.restapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.legiscam.restapi.models.Mandato;

@Repository
public interface MandatoRepository extends JpaRepository<Mandato, Long> {
	
	@Query("select m from Mandato as m where m.legislatura.id = :idLegislatura")
	List<Mandato> findByIdLegislatura(@Param("idLegislatura") long idLegislatura);
	
	@Query("select m from Mandato as m where m.parlamentar.id = :idParlamentar")
	List<Mandato> findByIdParlamentar(@Param("idParlamentar") long idParlamentar);

}
