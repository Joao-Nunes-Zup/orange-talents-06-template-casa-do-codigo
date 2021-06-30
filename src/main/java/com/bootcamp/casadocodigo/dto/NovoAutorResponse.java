package com.bootcamp.casadocodigo.dto;

import com.bootcamp.casadocodigo.model.Autor;

import java.time.LocalDateTime;

public class NovoAutorResponse {

    private String nome;
    private String email;
    private String descricao;
    private LocalDateTime dataCriacao;

    public NovoAutorResponse(String nome, String email, String descricao, LocalDateTime dataCriacao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
}
