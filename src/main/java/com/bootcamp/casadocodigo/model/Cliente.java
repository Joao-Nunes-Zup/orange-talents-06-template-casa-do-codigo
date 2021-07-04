package com.bootcamp.casadocodigo.model;

import com.bootcamp.casadocodigo.dto.NovoClienteResponse;
import com.bootcamp.casadocodigo.validator.CpfOrCnpj;
import com.bootcamp.casadocodigo.validator.Unique;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank
    @Email
    private String email;

    @Column(nullable = false)
    @NotBlank
    private String nome;

    @Column(nullable = false)
    @NotBlank
    private String sobrenome;

    @Column(nullable = false)
    @NotBlank
    @CpfOrCnpj
    private String cpfOuCnpj;

    @Column(nullable = false)
    @NotBlank
    private String endereco;

    @Column(nullable = false)
    @NotBlank
    private String complemento;

    @Column(nullable = false)
    @NotBlank
    private String cidade;

    @ManyToOne
    private Pais pais;

    @ManyToOne
    private Estado estado;

    @Column(nullable = false)
    @NotBlank
    private String telefone;

    @Column(nullable = false)
    @NotBlank
    private String cep;

    public Cliente(
            String email,
            String nome,
            String sobrenome,
            String cpfOuCnpj,
            String endereco,
            String complemento,
            String cidade,
            Pais pais,
            String telefone,
            String cep
    ) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpfOuCnpj = cpfOuCnpj;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.telefone = telefone;
        this.cep = cep;
    }

    public NovoClienteResponse toDto() {

        return new NovoClienteResponse(this.id);
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
