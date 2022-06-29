package br.senai.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.List;

@Entity(name = "controle_renda")
public class ControleRenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="data_pagamento")
    private Date dataPagamento;
    @Column
    @Enumerated(EnumType.STRING)
    private StatusPagamento status;
    @Column
    @Enumerated(EnumType.STRING)
    private FormaPagamento formaPagamento;
    @Column
    private double valor;
    @ManyToMany
    @JoinTable(
            name = "controle_renda_produto",
            joinColumns = @JoinColumn(name = "controle_renda_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(name = "produto_id",
                    referencedColumnName = "id"
            )
    )
    private List<Produto> produtos;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public StatusPagamento getStatus() {
        return status;
    }

    public void setStatus(StatusPagamento status) {
        this.status = status;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}