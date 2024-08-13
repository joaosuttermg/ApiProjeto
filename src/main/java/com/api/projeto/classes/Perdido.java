package com.api.projeto.classes;

import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Table(name = "perdidos")
@Entity
@EqualsAndHashCode(of = "id")
public class Perdido {

    private String nomeDoItem;

    private LocalDate dataDaPerda;

    private String localDaPerda;

    private String descricaoDoItem;
    
    
}
