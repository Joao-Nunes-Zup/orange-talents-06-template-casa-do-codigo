package com.bootcamp.casadocodigo.model;

import com.bootcamp.casadocodigo.dto.NovoAutorRequest;
import com.bootcamp.casadocodigo.dto.NovoAutorResponse;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;

@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String nome;

    @Column(nullable=false)
    @Email
    private String email;

    @Column(nullable=false, length=400)
    private String descricao;

    @Column(nullable=false, updatable=false)
    private LocalDateTime dataCriacao = LocalDateTime.now();

    public Autor() {}

    public Autor(NovoAutorRequest autorRequest) {
        this.nome = autorRequest.getNome();
        this.email = autorRequest.getEmail();
        this.descricao = autorRequest.getDescricao();
    }

    public NovoAutorResponse toDto() {
        return new NovoAutorResponse(this.nome, this.email, this.descricao, this.dataCriacao);
    }
}