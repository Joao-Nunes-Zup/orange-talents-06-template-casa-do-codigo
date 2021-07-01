package com.bootcamp.casadocodigo.dto;

import com.bootcamp.casadocodigo.model.Autor;
import com.bootcamp.casadocodigo.model.Categoria;

import java.math.BigDecimal;
import java.time.LocalDate;

public class NovoLivroResponse {

    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer numeroDePaginas;
    private String isbn;
    private LocalDate dataDePublicacao;
    private NovaCategoriaResponse categoria;
    private NovoAutorResponse autor;

    public NovoLivroResponse(
            String titulo,
            String resumo,
            String sumario,
            BigDecimal preco,
            Integer numeroDePaginas,
            String isbn,
            LocalDate dataDePublicacao,
            NovaCategoriaResponse categoria,
            NovoAutorResponse autor
    ) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroDePaginas = numeroDePaginas;
        this.isbn = isbn;
        this.dataDePublicacao = dataDePublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataDePublicacao() {
        return dataDePublicacao;
    }

    public NovaCategoriaResponse getCategoria() {
        return categoria;
    }

    public NovoAutorResponse getAutor() {
        return autor;
    }
}
