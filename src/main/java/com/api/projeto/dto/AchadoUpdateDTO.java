package com.api.projeto.dto;

import java.time.LocalDate;

import com.api.projeto.enums.Categoria;

import lombok.Data;

@Data
public class AchadoUpdateDTO {

    private Long id;
    private String quemAchou;
    private String nomeDoItem;
    private Categoria categoria;
    private LocalDate dataDeEncontro;
    private String localDeEncontro;

}
