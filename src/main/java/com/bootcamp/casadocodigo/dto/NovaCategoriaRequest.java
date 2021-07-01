package com.bootcamp.casadocodigo.dto;

import com.bootcamp.casadocodigo.model.Categoria;
import com.bootcamp.casadocodigo.validator.Unique;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NovaCategoriaRequest {

    @NotNull
    @NotBlank
    @Unique(field = "nome", theClass = Categoria.class)
    private String nome;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public NovaCategoriaRequest(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Categoria toEntity() {
        return new Categoria(this.nome);
    }
}
