package com.bootcamp.casadocodigo.validator;

import com.bootcamp.casadocodigo.dto.NovaCategoriaRequest;
import com.bootcamp.casadocodigo.dto.NovoAutorRequest;
import com.bootcamp.casadocodigo.model.Autor;
import com.bootcamp.casadocodigo.model.Categoria;
import com.bootcamp.casadocodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ValidadorDuplicidadeDeCategorias implements Validator {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return NovaCategoriaRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        NovaCategoriaRequest categoriaRequest = (NovaCategoriaRequest) obj;
        Optional<Categoria> categoria = categoriaRepository.findByNome(categoriaRequest.getNome());

        if (categoria.isPresent()) {
            errors.rejectValue(
                    "nome",
                    null,
                    "O nome, " + categoriaRequest.getNome() + ", já foi cadastrado."
            );
        }
    }
}
