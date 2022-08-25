package com.elotech.registrationprocesses.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


// Lombok auto-generation getters and setters.
@Getter
@Setter
// Lombok auto-generation equals and hashCode.
@EqualsAndHashCode
// Lombok generate toString method.
@ToString
@Entity
@Table(name="tb_pessoa")
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "cpf", nullable = false)
    private String cpf;
    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "data_cadastro", nullable = false)
    private LocalDate dataCadastro;

    @ManyToOne
    @JoinColumn(name = "id_processo")
    private Processo processo;




}
