package com.legiscam.restapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.legiscam.restapi.models.Orgao;

@Repository
public interface OrgaoRepository extends JpaRepository<Orgao, Long>   {

}
