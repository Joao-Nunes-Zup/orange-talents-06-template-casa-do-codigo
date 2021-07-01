package com.bootcamp.casadocodigo.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NovoAutorResponse {

    private String nome;
    private String email;
    private String descricao;
    private String dataCriacao;

    public NovoAutorResponse(String nome, String email, String descricao, LocalDateTime dataCriacao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
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

    public String getDataCriacao() {
        return dataCriacao;
    }
}
