package com.dgw.sgco.repositories.pessoa;

import java.util.List;

import com.dgw.sgco.domain.pessoa.Pais;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * PaisRepository
 */
@Repository
public interface PaisRepository extends JpaRepository<Pais, Integer> {

    @Transactional(readOnly = true)
    public List<Pais> findAllByOrderByNome();

}
