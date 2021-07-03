package com.bootcamp.casadocodigo.dto;

import com.bootcamp.casadocodigo.model.Estado;
import com.bootcamp.casadocodigo.model.Pais;
import com.bootcamp.casadocodigo.repository.PaisRepository;
import com.bootcamp.casadocodigo.validator.ExistentId;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class NovoEstadoRequest {

    @NotBlank(message = "Campo obrigatório")
    private String nome;

    @NotNull(message = "Campo obrigatório")
    @ExistentId(field = "id", theClass = Pais.class, message = "País não registrado")
    private Long paisId;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public NovoEstadoRequest(String nome, Long paisId) {
        this.nome = nome;
        this.paisId = paisId;
    }

    public String getNome() {
        return nome;
    }

    public Long getPaisId() {
        return paisId;
    }

    public Estado toEntity(PaisRepository paisRepository) {
        Optional<Pais> pais = paisRepository.findById(this.paisId);
        return new Estado(this.nome, pais.get());
    }
}
