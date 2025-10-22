package com.example.jpa_h2_demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TELEFONE")
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CLIENTE_ID", nullable = false)
    private Cliente cliente;
    @Column(name = "NUMERO", length = 15, nullable = false)
    private Long numero;

    @Column(name = "DDD", nullable = false)
    private int ddd;

}
