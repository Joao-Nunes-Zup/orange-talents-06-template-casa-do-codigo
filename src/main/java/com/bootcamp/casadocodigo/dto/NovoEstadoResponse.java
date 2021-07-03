package com.bootcamp.casadocodigo.dto;

import com.bootcamp.casadocodigo.model.Pais;

public class NovoEstadoResponse {

    private String nome;
    private Pais pais;

    public NovoEstadoResponse(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public String getNome() {
        return nome;
    }
}
