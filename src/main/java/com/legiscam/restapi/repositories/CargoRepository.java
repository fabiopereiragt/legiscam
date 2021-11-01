package com.legiscam.restapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.legiscam.restapi.models.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long>{

}
