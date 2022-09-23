package br.edu.universidadedevassouras.prova.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Data
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idpessoa;
    @Column(nullable = false, length = 100)
    private String nome;
    @Column(length = 256)
    private String email;
    @Column(nullable = false)
    private Date nascimento;
    @Column()
    private char genero;
    @Column(unique = true)
    private BigInteger cpf;
    @Column(unique = true)
    private BigInteger rg;
    @Column(length = 10)
    private String tipo_sangue;
    @Column(unique = true,nullable = false, length = 300)
    private String pai;
    @Column(unique = true,nullable = false, length = 300)
    private String mae;
    @ManyToOne
    private Telefone telefone;
    @ManyToOne
    private Endereco endereco;



}