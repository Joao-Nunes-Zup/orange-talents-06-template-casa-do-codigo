package com.bootcamp.casadocodigo.controller;

import com.bootcamp.casadocodigo.dto.NovoClienteRequest;
import com.bootcamp.casadocodigo.dto.NovoClienteResponse;
import com.bootcamp.casadocodigo.model.Cliente;
import com.bootcamp.casadocodigo.repository.ClienteRepository;
import com.bootcamp.casadocodigo.repository.EstadoRepository;
import com.bootcamp.casadocodigo.repository.PaisRepository;
import com.bootcamp.casadocodigo.validator.ProibeEstadosComMesmoNomeEMesmoPais;
import com.bootcamp.casadocodigo.validator.ProibeEstadosNulosQuandoOPaisPossuiEstadosRegistrados;
import com.bootcamp.casadocodigo.validator.ProibeUmEstadoQueNaoFazParteDoPaisDefinido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProibeEstadosNulosQuandoOPaisPossuiEstadosRegistrados proibeEstadosNulosQuandoOPaisPossuiEstadosRegistrados;

    @Autowired
    private ProibeUmEstadoQueNaoFazParteDoPaisDefinido proibeUmEstadoQueNaoFazParteDoPaisDefinido;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(
                proibeEstadosNulosQuandoOPaisPossuiEstadosRegistrados,
                proibeUmEstadoQueNaoFazParteDoPaisDefinido
        );
    }

    @PostMapping
    public ResponseEntity<NovoClienteResponse> criar(@RequestBody @Valid NovoClienteRequest clienteRequest) {
        Cliente cliente = clienteRequest.toEntity(paisRepository, estadoRepository);
        clienteRepository.save(cliente);
        return ResponseEntity.ok(cliente.toDto());
    }

}
