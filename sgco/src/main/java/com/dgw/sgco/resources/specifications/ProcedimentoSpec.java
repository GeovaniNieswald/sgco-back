package com.dgw.sgco.resources.specifications;

import com.dgw.sgco.domain.agendamento.Procedimento;

import org.springframework.data.jpa.domain.Specification;

import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.LikeIgnoreCase;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;

/**
 * ProcedimentoSpec
 */
@And({
        @Spec(path = "nome", params = "nome", spec = LikeIgnoreCase.class),
        @Spec(path = "ativo", params = "ativo", spec = Equal.class)
})
public interface ProcedimentoSpec extends Specification<Procedimento> {

}
