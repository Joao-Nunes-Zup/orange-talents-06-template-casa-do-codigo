package com.bootcamp.casadocodigo.dto;

import com.bootcamp.casadocodigo.model.Autor;
import com.bootcamp.casadocodigo.model.Categoria;
import com.bootcamp.casadocodigo.model.Livro;
import com.bootcamp.casadocodigo.model.Pais;
import com.bootcamp.casadocodigo.validator.ExistentId;
import com.bootcamp.casadocodigo.validator.Unique;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class NovoLivroRequest {

    @NotBlank
    @Unique(field = "titulo", theClass = Livro.class, message = "Título já em uso")
    private String titulo;

    @NotBlank
    @Size(max = 500, message = "=O número de caracteres máximo: 500")
    private String resumo;

    private String sumario;

    @NotNull
    @Min(value = 20, message = "O valor mínimo é de: R$20,00")
    private BigDecimal preco;

    @NotNull
    @Min(value = 100, message = "O menor número de páginas permitido é de: 100")
    private Integer numeroDePaginas;

    @NotBlank
    @Unique(field = "isbn", theClass = Livro.class, message = "Já existe um livro com o mesmo Isbn")
    private String isbn;

    @NotNull
    @Future(message = "A data precisa ser no futuro")
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataDePublicacao;

    @NotNull
    @ExistentId(field = "id", theClass = Categoria.class, message = "Categoria não registrada")
    private Long categoriaId;

    @NotNull
    @ExistentId(field = "id", theClass = Autor.class, message = "Autor não registrado")
    private Long autorId;

    public NovoLivroRequest(
            String titulo,
            String resumo,
            String sumario,
            BigDecimal preco,
            Integer numeroDePaginas,
            String isbn,
            Long categoriaId,
            Long autorId
    ) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroDePaginas = numeroDePaginas;
        this.isbn = isbn;
        this.categoriaId = categoriaId;
        this.autorId = autorId;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public Long getAutorId() {
        return autorId;
    }


    /*
    *
    * É necessário um setter para este campo para que a anotação @JsonFormat tenha efeito,
    * pois pelo construtor não funciona.
    * No momento, não sei dizer o motivo.
    *
    */
    public void setDataDePublicacao(LocalDate dataDePublicacao) {
        this.dataDePublicacao = dataDePublicacao;
    }

    public Livro toEntity(
            Categoria categoria,
            Autor autor)
    {

        return new Livro(
                this.titulo,
                this.resumo,
                this.sumario,
                this.preco,
                this.numeroDePaginas,
                this.isbn,
                this.dataDePublicacao,
                categoria,
                autor
        );
    }
}
