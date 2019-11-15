package com.dgw.sgco.repositories.pessoa;

import java.util.List;

import com.dgw.sgco.domain.pessoa.Cidade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * CidadeRepository
 */
@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

    @Query("SELECT obj FROM Cidade obj WHERE obj.estado.id = :idEstado ORDER BY obj.nome")
    public List<Cidade> findCidades(@Param("idEstado") Integer idEstado);

}
