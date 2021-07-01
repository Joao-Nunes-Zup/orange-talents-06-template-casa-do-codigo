package com.bootcamp.casadocodigo.model;

import com.bootcamp.casadocodigo.dto.DetalhesDoLivroResponse;
import com.bootcamp.casadocodigo.dto.LivroParaListagemResponse;
import com.bootcamp.casadocodigo.dto.NovoLivroResponse;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.ResponseEntity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @NotBlank
    private String titulo;

    @Column(nullable = false, length = 500)
    @NotBlank
    @Length(max = 500)
    private String resumo;

    private String sumario;

    @Column(nullable = false)
    @NotNull
    @Min(20)
    private BigDecimal preco;

    @Column(nullable = false)
    @NotNull
    @Min(100)
    private Integer numeroDePaginas;

    @Column(nullable = false, unique = true)
    @NotBlank
    private String isbn;

    @Column(nullable = false)
    @NotNull
    @Future
    private LocalDate dataDePublicacao;

    @NotNull
    @ManyToOne
    private Categoria categoria;

    @NotNull
    @ManyToOne
    private Autor autor;

    @Deprecated
    public Livro() {}

    public Livro(
            String titulo,
            String resumo,
            String sumario,
            BigDecimal preco,
            Integer numeroDePaginas,
            String isbn,
            LocalDate dataDePublicacao,
            Categoria categoria,
            Autor autor)
    {
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

    public NovoLivroResponse toDto() {
        return new NovoLivroResponse(
                this.titulo,
                this.resumo,
                this.sumario,
                this.preco,
                this.numeroDePaginas,
                this.isbn,
                this.dataDePublicacao,
                this.categoria.toDto(),
                this.autor.toDto()
        );
    }

    public LivroParaListagemResponse toDtoListagem() {
        return new LivroParaListagemResponse(this.id, this.titulo);
    }

    public DetalhesDoLivroResponse toDtoDetalhes() {
        return new DetalhesDoLivroResponse(this.titulo,
                this.resumo,
                this.sumario,
                this.preco,
                this.numeroDePaginas,
                this.isbn,
                this.dataDePublicacao,
                this.categoria.toDto(),
                this.autor.toDto()
        );
    }
}
