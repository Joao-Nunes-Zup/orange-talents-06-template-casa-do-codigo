package com.bootcamp.casadocodigo.model;

import com.bootcamp.casadocodigo.dto.NovoPaisResponse;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "paises")
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @NotBlank
    private String nome;

    @Deprecated
    public Pais() {}

    public Pais(String nome) {
        this.nome = nome;
    }

    public NovoPaisResponse toDto() {
        return new NovoPaisResponse(this.nome);
    }
}
