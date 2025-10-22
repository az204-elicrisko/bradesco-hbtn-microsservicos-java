package com.example.jpa_h2_demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ENDERECO")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "CLIENTE_ID", nullable = false)
    private Cliente cliente;

    @Column(name = "LOGRADOURO", length = 100, nullable = false)
    private String logradouro;
    @Column(name = "ENDERECO", length = 100, nullable = false)
    private String endereco;
    @Column(name = "NUMERO", nullable = false)
    private int numero;
    @Column(name = "BAIRRO", length = 50, nullable = false)
    private String bairro;
    @Column(name = "CIDADE", length = 50, nullable = false)     
    private String cidade;
    @Column(name = "ESTADO", length = 50, nullable = false)
    private String estado;
}
