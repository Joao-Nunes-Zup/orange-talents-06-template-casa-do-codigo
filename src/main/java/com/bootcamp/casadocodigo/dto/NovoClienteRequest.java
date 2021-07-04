package com.bootcamp.casadocodigo.dto;

import com.bootcamp.casadocodigo.model.Cliente;
import com.bootcamp.casadocodigo.model.Estado;
import com.bootcamp.casadocodigo.model.Pais;
import com.bootcamp.casadocodigo.repository.EstadoRepository;
import com.bootcamp.casadocodigo.repository.PaisRepository;
import com.bootcamp.casadocodigo.validator.CpfOrCnpj;
import com.bootcamp.casadocodigo.validator.ExistentId;
import com.bootcamp.casadocodigo.validator.Unique;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class NovoClienteRequest {

    @NotBlank
    @Email
    @Unique(field = "email", theClass = Cliente.class, message = "E-mail já em uso")
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank
    @CpfOrCnpj(message = "É necessário um CPF ou CNPJ válido.")
    @Unique(field = "cpfOuCnpj", theClass = Cliente.class, message = "Documento já registrado")
    private String cpfOuCnpj;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @NotNull
    @ExistentId(field = "id", theClass = Pais.class, message = "O país deve estar registrado")
    private Long paisId;

    private Long estadoId;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    public NovoClienteRequest(
            String email,
            String nome,
            String sobrenome,
            String cpfOuCnpj,
            String endereco,
            String complemento,
            String cidade,
            Long paisId,
            Long estadoId,
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
        this.paisId = paisId;
        this.estadoId = estadoId;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Long getPaisId() {
        return paisId;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public Cliente toEntity(PaisRepository paisRepository, EstadoRepository estadoRepository) {
        Optional<Pais> pais = paisRepository.findById(this.paisId);

        Cliente cliente = new Cliente(
                this.email,
                this.nome,
                this.sobrenome,
                this.cpfOuCnpj,
                this.endereco,
                this.complemento,
                this.cidade,
                pais.get(),
                this.telefone,
                this.cep
        );

        if (estadoId != null) {
            Optional<Estado> estado = estadoRepository.findById(this.estadoId);
            cliente.setEstado(estado.get());
        }

        return cliente;
    }
}
