package com.bootcamp.casadocodigo.dto;

public class ErroDeFormularioResponse {

    private String campo;
    private String mensagem;

    public ErroDeFormularioResponse(String campo, String mensagem) {
        this.campo = campo;
        this.mensagem = mensagem;
    }

    public String getCampo() {
        return campo;
    }

    public String getErro() {
        return mensagem;
    }
}
