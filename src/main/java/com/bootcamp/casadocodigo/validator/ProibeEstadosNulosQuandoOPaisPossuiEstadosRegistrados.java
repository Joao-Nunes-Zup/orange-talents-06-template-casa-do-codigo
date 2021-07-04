package com.bootcamp.casadocodigo.validator;

import com.bootcamp.casadocodigo.dto.NovoClienteRequest;
import com.bootcamp.casadocodigo.model.Estado;
import com.bootcamp.casadocodigo.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

@Component
public class ProibeEstadosNulosQuandoOPaisPossuiEstadosRegistrados implements Validator {

    @Autowired
    EstadoRepository estadoRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return NovoClienteRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        if(errors.hasErrors()) return;

        NovoClienteRequest clienteRequest = (NovoClienteRequest) obj;
        List<Estado> estados = estadoRepository.findByPaisId(clienteRequest.getPaisId());

        if (estados.size() > 0 && clienteRequest.getEstadoId() == null) {
            errors.rejectValue(
                    "estadoId",
                    null,
                    "O estado não pode ser nulo quando o país possui estados registrados."
            );
        }
    }
}
