package com.api.projeto.classes;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Range;

import com.api.projeto.enums.Categoria;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
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

    
    @Column(nullable = false, unique = true)
    @NotNull(message = "O e-mail é obrigatório")
    @Email(message = "O e-mail deve ser válido")
    private String emailDeQuemAchou;

    
    @Column(nullable = false)
    @NotNull(message = "O nome de quem achou é obrigatório")
    @Min(value = 3, message = "O nome deve ter no mínimo 3 letras")
    @Max(value = 100, message = "O nome deve ter no máximo 100 letras")
    private String quemAchou;

    @Column(nullable = false)
    @NotNull(message = "O nome do item é obrigatório")
    private String nomeDoItem;

    @Column(nullable = false)
    @Enumerated
    @NotNull(message = "A categoria é obrigatória")
    private Categoria categoria;

    //Tratando a coluna para não receber dados em branco
    // e a coluna ter o nome alterado
    @PastOrPresent
    @Column(nullable = false, name = "data_encontrado")
    @NotNull(message = "A data encontrada é obrigatória")
    private LocalDate dataDeEncontro;

    //Tratando a coluna para não receber dados em branco
    // e a coluna ter o nome alterado
    @Column(nullable = false, name = "local_encontrado")
    @NotNull(message = "O local encontrado é obrigatório")
    private String localDeEncontro;

    @Column(name = "achado_ativo")
    private boolean achadoAtivo = true;


}
