package br.edu.universidadedevassouras.prova.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idendereco;
    @Column()
    private String CEP;
    @Column
    private String tipo_logradouro;
    @Column
    private String logradouro;
    @Column
    private int numero;
    @Column
    private String bairro;
    @Column
    private String cidade;
    @Column
    private String estado;
    @Column()
    private String pais;
}
