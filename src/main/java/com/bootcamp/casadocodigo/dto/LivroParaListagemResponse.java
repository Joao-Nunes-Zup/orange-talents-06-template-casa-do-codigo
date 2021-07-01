package com.bootcamp.casadocodigo.dto;

public class LivroParaListagemResponse {

    private Long id;
    private String titulo;

    public LivroParaListagemResponse(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}
