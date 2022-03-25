package com.marcoscouto.contabancaria.data;

import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

import java.math.BigDecimal;

import static com.marcoscouto.contabancaria.data.TipoContaEnum.*;
import static javax.persistence.EnumType.STRING;


public class Conta {

    private Integer id;

    @Column(name = "tipo_conta")
    @Enumerated(STRING)
    private TipoContaEnum tipoConta;

    @OneToOne(targetEntity = Cliente.class)
    private Cliente cliente;

    public Conta(Cliente cliente) {
        this.cliente = cliente;
        selecionaLimite();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoContaEnum getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoContaEnum tipoConta) {
        this.tipoConta = tipoConta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getLimite(){
        return this.getTipoConta().getLimite();
    }

    private void selecionaLimite() {
        if (this.cliente.getFaixaSalarial() <= 3000)
            this.tipoConta = PRATA;
        if (this.cliente.getFaixaSalarial() > 3000 && this.cliente.getFaixaSalarial() <= 5000)
            this.tipoConta = OURO;
        if (this.cliente.getFaixaSalarial() > 5000 && this.cliente.getFaixaSalarial() <= 10000)
            this.tipoConta = PLATINA;
        if (this.cliente.getFaixaSalarial() > 10000)
            this.tipoConta = DIAMANTE;
    }
}
