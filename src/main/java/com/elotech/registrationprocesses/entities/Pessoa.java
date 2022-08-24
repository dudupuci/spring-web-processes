package com.elotech.registrationprocesses.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.bytebuddy.asm.Advice;

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
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    public Pessoa() {
    }

    public Pessoa(Long id, String nome, String cpf, LocalDate dataNascimento, LocalDate dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.dataCadastro = dataCadastro;
    }

    @Id
    @EqualsAndHashCode.Include
    private Long id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private LocalDate dataCadastro;

    @ManyToOne
    private Processo processo;


}
