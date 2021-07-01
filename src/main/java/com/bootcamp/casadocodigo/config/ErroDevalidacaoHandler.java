package com.bootcamp.casadocodigo.config;

import com.bootcamp.casadocodigo.dto.ErroDeFormularioResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ErroDevalidacaoHandler {

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroDeFormularioResponse> handle(MethodArgumentNotValidException exception) {
        List<ErroDeFormularioResponse> erros = new ArrayList<>();

        exception.getBindingResult().getFieldErrors().stream()
                .map(erro -> new ErroDeFormularioResponse(erro.getField(), erro.getDefaultMessage()))
                .forEach(erro -> erros.add(erro));

        return erros;
    }
}
