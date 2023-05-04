package br.com.benezinhobank.model;

import br.com.benezinhobank.pessoa.model.Pessoa;

public abstract class Conta {



    private String numero;

    private Agencia agencia;

    private Pessoa titular;

    private double saldo;


    public Conta() {
    }

    public Conta(String numero, Agencia agencia, Pessoa titular, double saldo) {
        this.numero = numero;
        this.agencia = agencia;
        this.titular = titular;
        this.saldo = saldo;
    }


    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public Pessoa getTitular() {
        return titular;
    }

    public void setTitular(Pessoa titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNumero() {
        return numero;
    }

    public Conta setNumero(String numero) {
        this.numero = numero;
        return this;
    }


    @Override
    public String toString() {
        return "Conta{" +
                "numero='" + numero + '\'' +
                ", agencia=" + agencia +
                ", titular=" + titular +
                ", saldo=" + saldo +
                '}';
    }
}
