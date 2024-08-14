package com.api.projeto.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class AchadoUpdateDTO {

    private Long id;
    private String quemAchou;
    private String nomeDoItem;
    private String categoria;
    private LocalDate dataDeEncontro;
    private String localDeEncontro;

}
