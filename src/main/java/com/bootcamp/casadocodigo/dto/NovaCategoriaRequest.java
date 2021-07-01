package com.bootcamp.casadocodigo.dto;

import com.bootcamp.casadocodigo.model.Categoria;
import com.bootcamp.casadocodigo.validator.Unique;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaRequest {

    @NotBlank(message = "Campo obrigatório")
    @Unique(field = "nome", theClass = Categoria.class, message = "Já existe uma categoria com este nome")
    private String nome;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public NovaCategoriaRequest(String nome) {
        this.nome = nome;
    }

    public Categoria toEntity() {
        return new Categoria(this.nome);
    }
}
