package br.edu.universidadedevassouras.prova.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Telefone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idtelefone;
    @Column
    private String celular;
    @Column
    private String fixo;
}
