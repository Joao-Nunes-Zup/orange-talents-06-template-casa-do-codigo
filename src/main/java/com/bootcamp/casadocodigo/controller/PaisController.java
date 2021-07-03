package com.bootcamp.casadocodigo.controller;

import com.bootcamp.casadocodigo.dto.NovoPaisRequest;
import com.bootcamp.casadocodigo.dto.NovoPaisResponse;
import com.bootcamp.casadocodigo.model.Pais;
import com.bootcamp.casadocodigo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/paises")
public class PaisController {

    @Autowired
    PaisRepository paisRepository;

    @Transactional
    @PostMapping
    public ResponseEntity<NovoPaisResponse> criar(@RequestBody @Valid NovoPaisRequest paisRequest) {
        Pais pais = paisRequest.toEntity();
        paisRepository.save(pais);
        return ResponseEntity.ok(pais.toDto());
    }
}
