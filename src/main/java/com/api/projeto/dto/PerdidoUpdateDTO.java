package com.api.projeto.dto;
import java.time.LocalDate;
import lombok.Data;

@Data

public class PerdidoUpdateDTO {

    private Long id;
    private String quemPerdeu;
    private String nomeDoItem;
    private String categoria;
    private LocalDate dataDaPerda;
    private String localDaPerda;



}
