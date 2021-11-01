package com.legiscam.restapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.legiscam.restapi.models.Parlamentar;

public interface ParlamentarRepository extends JpaRepository<Parlamentar, Long> {

}
