package com.bootcamp.casadocodigo.validator;

import com.bootcamp.casadocodigo.dto.NovoAutorRequest;
import com.bootcamp.casadocodigo.model.Autor;
import com.bootcamp.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ValidaDuplicidadeDeEmail implements Validator {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return NovoAutorRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        NovoAutorRequest autorRequest = (NovoAutorRequest) obj;
        Optional<Autor> autor = autorRepository.findByEmail(autorRequest.getEmail());

        if (autor.isPresent()) {
            errors.rejectValue(
                    "email",
                    null,
                    "E-mail, " + autorRequest.getEmail() + ", já está em uso."
            );
        }
    }
}
