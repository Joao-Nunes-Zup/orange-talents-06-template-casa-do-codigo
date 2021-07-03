package com.bootcamp.casadocodigo.validator;

import com.bootcamp.casadocodigo.dto.NovoEstadoRequest;
import com.bootcamp.casadocodigo.model.Estado;
import com.bootcamp.casadocodigo.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ProibeEstadosComMesmoNomeEMesmoPais implements Validator {

    @Autowired
    EstadoRepository estadoRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return NovoEstadoRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        if(errors.hasErrors()) return;

        NovoEstadoRequest estadoRequest = (NovoEstadoRequest) obj;
        Optional<Estado> estado =
                estadoRepository.findByNomeAndPaisId(estadoRequest.getNome(), estadoRequest.getPaisId());

        if (estado.isPresent()) {
            errors.rejectValue("nome", null, "Já existe um estado com este nome neste país");
        }
    }
}
