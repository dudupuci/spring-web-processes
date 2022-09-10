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
import org.springframework.data.jpa.domain.Specification;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


// Lombok auto-generation getters and setters.
@Getter
@Setter
// Lombok auto-generation equals and hashCode.
@EqualsAndHashCode
// Lombok generate toString method.
@ToString
@Entity
@Table(name = "tb_pessoa")
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

    /*public Specification<Pessoa> toSpec() {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicados = new ArrayList<>();
            if (StringUtils.hasText(nome)) {
                // tipagem dinâmica
                Path<String> campoNome = root.<String>get("nome");
                Predicate predicadoNome = criteriaBuilder.equal(campoNome, nome);
                predicados.add(predicadoNome);
            }
            return criteriaBuilder.and(predicados.toArray(new Predicate[0]));
        };*/

}
