package com.bootcamp.casadocodigo.controller;

import com.bootcamp.casadocodigo.dto.NovoAutorRequest;
import com.bootcamp.casadocodigo.dto.NovoAutorResponse;
import com.bootcamp.casadocodigo.model.Autor;
import com.bootcamp.casadocodigo.repository.AutorRepository;
import com.bootcamp.casadocodigo.validator.ValidaDuplicidadeDeEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private ValidaDuplicidadeDeEmail validadaDuplicidadeDeEmail;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(validadaDuplicidadeDeEmail);
    }

    @PostMapping
    public ResponseEntity<?> criar(@RequestBody @Valid NovoAutorRequest autorRequest) {
        Autor autor = autorRequest.toEntity();
        autorRepository.save(autor);
        NovoAutorResponse autorResponse = autor.toDto();
        return ResponseEntity.ok(autorResponse);
    }
}
