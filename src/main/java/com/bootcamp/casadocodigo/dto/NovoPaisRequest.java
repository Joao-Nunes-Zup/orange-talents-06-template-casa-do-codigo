package com.bootcamp.casadocodigo.dto;

import com.bootcamp.casadocodigo.model.Pais;
import com.bootcamp.casadocodigo.validator.Unique;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.constraints.NotBlank;

public class NovoPaisRequest {

    @NotBlank(message = "Campo obrigatório")
    @Unique(field = "nome", theClass = Pais.class)
    private String nome;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public NovoPaisRequest(String nome) {
        this.nome = nome;
    }

    public Pais toEntity() {
        return new Pais(this.nome);
    }
}
