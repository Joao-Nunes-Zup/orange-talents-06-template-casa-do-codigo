package com.bootcamp.casadocodigo.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DetalhesDoLivroResponse {

    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer numeroDePaginas;
    private String isbn;
    private String dataDePublicacao;
    private NovaCategoriaResponse categoria;
    private NovoAutorResponse autor;

    public DetalhesDoLivroResponse(
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
        this.dataDePublicacao = dataDePublicacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
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

    public String getDataDePublicacao() {
        return dataDePublicacao;
    }

    public NovaCategoriaResponse getCategoria() {
        return categoria;
    }

    public NovoAutorResponse getAutor() {
        return autor;
    }
}
