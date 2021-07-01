package com.bootcamp.casadocodigo.dto;

import com.bootcamp.casadocodigo.model.Autor;
import com.bootcamp.casadocodigo.validator.Unique;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NovoAutorRequest {

    @NotBlank(message = "Campo obrigatório")
    private String nome;

    @NotBlank(message = "Campo obrigatório")
    @Email(message = "Formato inválido")
    @Unique(field = "email", theClass = Autor.class, message = "E-mail já em uso")
    private String email;

    @NotBlank(message = "Campo obrigatório")
    @Size(max = 400, message= "Número máximo de caracteres permitidos: 400")
    private String descricao;

    public NovoAutorRequest(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor toEntity() {
        return new Autor(this.nome, this.email, this.descricao);
    }
}
