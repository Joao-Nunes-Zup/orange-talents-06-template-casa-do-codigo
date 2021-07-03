package com.bootcamp.casadocodigo.controller;

import com.bootcamp.casadocodigo.dto.NovoEstadoRequest;
import com.bootcamp.casadocodigo.dto.NovoEstadoResponse;
import com.bootcamp.casadocodigo.model.Estado;
import com.bootcamp.casadocodigo.repository.EstadoRepository;
import com.bootcamp.casadocodigo.repository.PaisRepository;
import com.bootcamp.casadocodigo.validator.ProibeEstadosComMesmoNomeEMesmoPais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private ProibeEstadosComMesmoNomeEMesmoPais proibeEstadosComMesmoNomeEMesmoPais;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(proibeEstadosComMesmoNomeEMesmoPais);
    }

    @Transactional
    @PostMapping
    public ResponseEntity<NovoEstadoResponse> criar(@RequestBody @Valid NovoEstadoRequest estadoRequest) {
        Estado estado = estadoRequest.toEntity(paisRepository);
        // estadoRepository.save(estado);
        return ResponseEntity.ok(estado.toDto());
    }
}
