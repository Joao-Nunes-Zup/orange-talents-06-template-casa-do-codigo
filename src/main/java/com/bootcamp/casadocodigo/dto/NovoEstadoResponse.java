package com.bootcamp.casadocodigo.dto;

import com.bootcamp.casadocodigo.model.Pais;

public class NovoEstadoResponse {

    private Long id;
    private String nome;
    private Pais pais;

    public NovoEstadoResponse(Long id, String nome, Pais pais) {
        this.id = id;
        this.nome = nome;
        this.pais = pais;
    }

    public String getNome() {
        return nome;
    }

    public Long getId() {
        return id;
    }
}
