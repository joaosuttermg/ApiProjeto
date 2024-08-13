package com.api.projeto.classes;

import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Table(name = "achados")
@Entity
@EqualsAndHashCode(of = "id")
public class Achado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String quemAchou;

    @Column(nullable = false)
    private String nomeDoItem;

    @Column(nullable = false)
    private String Categoria;

    @Column(nullable = false)
    private LocalDate dataDeEncontro;

    @Column(nullable = false)
    private String localDeEncontro;

 


}
