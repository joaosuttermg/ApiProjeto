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
    private String quemPerdeu;

    @Column(nullable = false)
    private String Categoria;

    @Column(nullable = false)
    private String nomeDoItem;

    @Column(nullable = false)
    private String descricaoDoItem;
    
    //Tratando a coluna para não receber dados em branco
    // e a coluna ter o nome alterado
    @Column(nullable = false, name = "data_perdido")
    private LocalDate dataDaPerda;

    //Tratando a coluna para não receber dados em branco
    // e a coluna ter o nome alterado
    @Column(nullable = false, name = "local_perdido")
    private String localDaPerda;

    @Column(name = "perdido_ativo")
    private boolean perdidoAtivo = true;
}
