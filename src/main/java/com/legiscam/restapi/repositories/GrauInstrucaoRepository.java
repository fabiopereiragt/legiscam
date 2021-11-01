package com.legiscam.restapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.legiscam.restapi.models.GrauInstrucao;

@Repository
public interface GrauInstrucaoRepository extends JpaRepository<GrauInstrucao, Long> {

}
