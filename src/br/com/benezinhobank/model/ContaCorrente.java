package br.com.benezinhobank.model;

import br.com.benezinhobank.pessoa.model.Pessoa;

public class ContaCorrente extends Conta {

    private double limite;

    public ContaCorrente() {
    }

    public ContaCorrente(String numero, Agencia agencia, Pessoa titular, double saldo, double limite) {
        super(numero, agencia, titular, saldo);
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    @Override
    public boolean sacar(double valor) {
        double valorDisponivel = getSaldo() + getLimite();
        if (valor <= 0) return false;
        if (valorDisponivel < valor) return false;
        setSaldo(getSaldo() - valor);
        return true;
    }


    @Override
    public String toString() {
        return "ContaCorrente{" +
                "limite=" + limite +
                "} " + super.toString();
    }
}
