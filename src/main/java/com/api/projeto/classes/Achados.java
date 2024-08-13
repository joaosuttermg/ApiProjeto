package com.api.projeto.classes;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "achados")
@Entity
public class Achados {

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
    private String DataDeEncontro;

}
