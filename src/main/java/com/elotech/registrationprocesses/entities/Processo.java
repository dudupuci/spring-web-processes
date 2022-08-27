package com.elotech.registrationprocesses.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.annotation.processing.Generated;
import javax.persistence.*;
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
@Table(name = "tb_processo") //> Quando eu anoto @Table na entidade, o data.sql não consegue inserir os dados na tabela,
// porém, quando removido @Table, os scripts bateram e funcionou, tanto o schema.sql, quanto data.sql
public class Processo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;
    @Column(name = "numero_processo", nullable = false, unique = true)
    private Long numero;
    @Column(name = "ano_processo", nullable = false)
    private Integer ano;
    @Column(name = "data_processo", nullable = false)
    private LocalDate dataCadastro;
    @Column(nullable = false)
    @OneToMany(mappedBy = "processo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Pessoa> pessoas = new ArrayList<>();

    public Processo() {

    }

    public Processo(Long id, Long numero, Integer ano, LocalDate dataCadastro, List<Pessoa> pessoas) {
        this.id = id;
        this.numero = numero;
        this.ano = ano;
        this.dataCadastro = dataCadastro;
        this.pessoas = pessoas;
    }


}
