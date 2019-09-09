package com.dgw.sgco.repositories.pessoa;

import com.dgw.sgco.domain.pessoa.Pais;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * PaisRepository
 */
@Repository
public interface PaisRepository extends JpaRepository<Pais, Integer> {

}
