package com.api.projeto.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class PerdidoDTO {

    private Long id;
    private String nomeDoItem;
    private LocalDate dataDaPerda;
    private String localDaPerda;
    private String descricaoDoItem;


}
