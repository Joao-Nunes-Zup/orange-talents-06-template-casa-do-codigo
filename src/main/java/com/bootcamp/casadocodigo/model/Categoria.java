package com.bootcamp.casadocodigo.model;

import com.bootcamp.casadocodigo.dto.NovaCategoriaResponse;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank
    private String nome;

    @Deprecated
    public Categoria() {}

    public Categoria(String nome) {
        this.nome = nome;
    }

    public NovaCategoriaResponse toDto() {
        return new NovaCategoriaResponse(this.nome);
    }
}
