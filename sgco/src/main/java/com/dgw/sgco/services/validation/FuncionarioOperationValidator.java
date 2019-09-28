package com.dgw.sgco.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.dgw.sgco.domain.pessoa.Funcionario;
import com.dgw.sgco.dto.pessoa.FuncionarioDTO;
import com.dgw.sgco.repositories.pessoa.FuncionarioRepository;
import com.dgw.sgco.resources.exceptions.FieldMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

/**
 * FuncionarioOperationValidator
 */
public class FuncionarioOperationValidator implements ConstraintValidator<FuncionarioOperation, FuncionarioDTO> {

    @Autowired
    private FuncionarioRepository repo;

    @Autowired
    private HttpServletRequest request;

    @Override
    public void initialize(FuncionarioOperation ann) {
    }

    @Override
    public boolean isValid(FuncionarioDTO objDto, ConstraintValidatorContext context) {

        @SuppressWarnings("unchecked")
        Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);

        String idRequest = map.get("id");

        if (idRequest != null) {
            objDto.setId(Integer.parseInt(idRequest));
        }

        List<FieldMessage> list = new ArrayList<>();

        Funcionario aux = repo.findByCpf(objDto.getCpf());

        if (objDto.getId() == null) {
            if (aux != null) {
                list.add(new FieldMessage("cpf", "CPF já existente"));
            }
        } else {
            if (aux != null && objDto.getId() != aux.getId()) {
                list.add(new FieldMessage("cpf", "CPF já existente"));
            }
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName()).addConstraintViolation();
        }

        return list.isEmpty();
    }
}
