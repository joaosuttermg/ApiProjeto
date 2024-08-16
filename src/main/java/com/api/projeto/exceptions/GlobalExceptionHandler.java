package com.api.projeto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        // Aqui você pode personalizar a mensagem de erro ou fazer outras ações
        String mensagemDeErro = "Erro de tipo de argumento: " + ex.getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensagemDeErro);
    }
   
    
    // Tratamento da exceção NullPointerException
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleNullPointerException(NullPointerException ex) {
        // Aqui você pode personalizar a mensagem de erro ou fazer outras ações
        String mensagemDeErro = "Erro de referência nula: " + ex.getMessage();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mensagemDeErro);
    }
}
