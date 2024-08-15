package com.api.projeto.dto;
import java.time.LocalDate;

import com.api.projeto.enums.Categoria;

import lombok.Data;

@Data

public class PerdidoUpdateDTO {

    private Long id;
    private String quemPerdeu;
    private String nomeDoItem;
    private Categoria categoria;
    private LocalDate dataDaPerda;
    private String localDaPerda;



}
