package com.elotech.registrationprocesses.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
// Lombok auto-generation getters and setters.
@Getter
@Setter
// Lombok auto-generation equals and hashCode.
@EqualsAndHashCode
// Lombok generate toString method.
@ToString
public class Processo implements Serializable {
    private static final long serialVersionUID = 1L;

    public Processo() {

    }

    public Processo(Long id, Long numero, Integer ano, LocalDate dataCadastro, Pessoa pessoa) {
        this.id = id;
        this.numero = numero;
        this.ano = ano;
        this.dataCadastro = dataCadastro;
        this.pessoa = pessoa;
    }

    @Id
    @EqualsAndHashCode.Include
    private Long id;
    private Long numero;
    private Integer ano;
    private LocalDate dataCadastro;
    @ManyToOne
    private Pessoa pessoa;


}
