package com.bootcamp.casadocodigo.validator;

import com.bootcamp.casadocodigo.dto.NovoClienteRequest;
import com.bootcamp.casadocodigo.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ProibeUmEstadoQueNaoFazParteDoPaisDefinido implements Validator {

    @Autowired
    EstadoRepository estadoRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return NovoClienteRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        if (errors.hasErrors()) return;

        NovoClienteRequest clienteRequest = (NovoClienteRequest) obj;

        if (clienteRequest.getEstadoId() != null) {
            Long paisId = estadoRepository.encontraOIdDoPaisPeloIdDoEstado(clienteRequest.getEstadoId());

            if (paisId != clienteRequest.getPaisId()) {
                errors.rejectValue(
                        "estadoId",
                        null,
                        "O estado deve pertencer ao país enviado na requisição."
                );
            }
        }
    }
}
