package com.bootcamp.casadocodigo.model;

import com.bootcamp.casadocodigo.dto.NovoEstadoResponse;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "estados")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @NotBlank
    private String nome;

    @NotNull
    @ManyToOne
    private Pais pais;

    @Deprecated
    public Estado() {}

    public Estado(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public NovoEstadoResponse toDto() {
        return new NovoEstadoResponse(this.id, this.nome, this.pais);
    }
}
