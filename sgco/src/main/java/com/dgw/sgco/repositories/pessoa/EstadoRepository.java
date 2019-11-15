package com.dgw.sgco.repositories.pessoa;

import java.util.List;

import com.dgw.sgco.domain.pessoa.Estado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * EstadoRepository
 */
@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

    @Query("SELECT obj FROM Estado obj WHERE obj.pais.id = :idPais ORDER BY obj.nome")
    public List<Estado> findEstados(@Param("idPais") Integer idPais);

}
