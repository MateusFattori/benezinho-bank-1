package br.com.benezinhobank.pessoa.model;

import java.time.LocalDate;

public class PessoaFisica extends Pessoa {

    private String CPF;

    private PessoaFisica mae;


    public PessoaFisica() {
    }

    public PessoaFisica(String nome, LocalDate nascimento, String CPF, PessoaFisica mae) {
        super(nome, nascimento);
        this.CPF = CPF;
        this.mae = mae;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public PessoaFisica getMae() {
        return mae;
    }

    public void setMae(PessoaFisica mae) {
        this.mae = mae;
    }


    @Override
    public String toString() {
        return "PessoaFisica{" +
                "CPF='" + CPF + '\'' +
                ", mae=" + mae +
                "} " + super.toString();
    }
}
