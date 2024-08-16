package com.api.projeto.classes;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Range;

import com.api.projeto.enums.Categoria;

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

    @Column(nullable = false, unique = true)
    @NotNull(message = "O e-mail é obrigatório")
    @Email(message = "O e-mail deve ser válido")
    private String emailDeQuemPerdeu;
    
    
    @Column(nullable = false)
    @NotNull(message = "O nome de quem aperdeu é obrigatório")
    @Size(min = 3, max = 100, message = "O nome deev ter o mínimo de 3 letras")
    private String quemPerdeu;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @NotNull(message = "A categoria é obrigatória")
    private Categoria categoria;

    @Column(nullable = false)
    @NotNull(message = "O nome do item perdido é obrigatório")
    private String nomeDoItem;

    @Column(nullable = false)
    @NotNull(message = "A descrição do item perdido é obrigatória")
    private String descricaoDoItem;
    
    //Tratando a coluna para não receber dados em branco
    // e a coluna ter o nome alterado
    @PastOrPresent
    @Column(nullable = false, name = "data_perdido")
    @NotNull(message = "A data da perda é obrigatória")
    private LocalDate dataDaPerda;

    //Tratando a coluna para não receber dados em branco
    // e a coluna ter o nome alterado
    @Column(nullable = false, name = "local_perdido")
    @NotNull(message = "O local da perda é obrigatório")
    private String localDaPerda;

    @Column(name = "perdido_ativo")
    private boolean perdidoAtivo = true;
}
