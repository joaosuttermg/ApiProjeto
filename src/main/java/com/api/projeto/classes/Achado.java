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

    //Tratando a coluna para não receber dados em branco
    // e a coluna ter o nome alterado
    @Column(nullable = false, name = "data_encontrado")
    private LocalDate dataDeEncontro;

    //Tratando a coluna para não receber dados em branco
    // e a coluna ter o nome alterado
    @Column(nullable = false, name = "local_encontrado")
    private String localDeEncontro;

    @Column(name = "achado_ativo")
    private boolean achadoAtivo = true;


}
