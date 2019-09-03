package com.dgw.sgco.repositories.pessoa;

import com.dgw.sgco.domain.pessoa.Estado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * EstadoRepository
 */
@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

}