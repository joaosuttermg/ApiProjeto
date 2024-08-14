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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomeDoItem;

    @Column(nullable = false)
    private LocalDate dataDaPerda;

    @Column(nullable = false)
    private String localDaPerda;

    private String descricaoDoItem;
}
