package com.bootcamp.casadocodigo.controller;

import com.bootcamp.casadocodigo.dto.NovaCategoriaRequest;
import com.bootcamp.casadocodigo.dto.NovaCategoriaResponse;
import com.bootcamp.casadocodigo.dto.NovoAutorRequest;
import com.bootcamp.casadocodigo.dto.NovoAutorResponse;
import com.bootcamp.casadocodigo.model.Autor;
import com.bootcamp.casadocodigo.model.Categoria;
import com.bootcamp.casadocodigo.repository.AutorRepository;
import com.bootcamp.casadocodigo.repository.CategoriaRepository;
import com.bootcamp.casadocodigo.validator.ValidaDuplicidadeDeEmail;
import com.bootcamp.casadocodigo.validator.ValidadorDuplicidadeDeCategorias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ValidadorDuplicidadeDeCategorias validadadorDuplicidadeDeCategorias;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(validadadorDuplicidadeDeCategorias);
    }

    @PostMapping
    public ResponseEntity<?> criar(@RequestBody @Valid NovaCategoriaRequest categoriaRequest) {
        Categoria categoria = categoriaRequest.toEntity();
        categoriaRepository.save(categoria);
        NovaCategoriaResponse categoriaResponse = categoria.toDto();
        return ResponseEntity.ok(categoriaResponse);
    }
}
