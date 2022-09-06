package com.elotech.registrationprocesses.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
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

    public Pessoa(Long id, String nome, String cpf, LocalDate dataNascimento, LocalDate dataCadastro, Processo processo) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.dataCadastro = dataCadastro;
        this.processo = processo;
    }

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    @Length(min = 4, max = 50, message = "Insira corretamente seu nome!")
    @NotEmpty(message = "O nome não pode ser vazio ou nulo!")
    private String nome;
    @Size(min = 11, max = 11, message = "CPF inválido!")
    @NotBlank(message = "CPF não pode ser em branco!")
    @Column(name = "cpf", unique = true)
    private String cpf;


    @Column(name = "data_nascimento")
    @Past(message = "Insira uma data de nascimento correta!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataNascimento;

    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "data_cadastro")
    private LocalDate dataCadastro;

    @ManyToOne
    @JoinColumn(name = "id_processo")
    @JsonIgnore // Anotei para não dar o erro de JSON na requisição, se não entraria em loop infinito.
    private Processo processo;




}
