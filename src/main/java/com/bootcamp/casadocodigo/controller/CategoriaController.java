package com.bootcamp.casadocodigo.controller;

import com.bootcamp.casadocodigo.dto.NovaCategoriaRequest;
import com.bootcamp.casadocodigo.dto.NovaCategoriaResponse;
import com.bootcamp.casadocodigo.model.Categoria;
import com.bootcamp.casadocodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> criar(@RequestBody @Valid NovaCategoriaRequest categoriaRequest) {
        Categoria categoria = categoriaRequest.toEntity();
        categoriaRepository.save(categoria);
        NovaCategoriaResponse categoriaResponse = categoria.toDto();
        return ResponseEntity.ok(categoriaResponse);
    }
}
