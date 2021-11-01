package com.legiscam.restapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.legiscam.restapi.models.Legislatura;

@Repository
public interface LegislaturaRepository extends JpaRepository<Legislatura, Long> {

}
