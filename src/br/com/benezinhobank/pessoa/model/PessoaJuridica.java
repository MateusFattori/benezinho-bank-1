package br.com.benezinhobank.pessoa.model;

import java.time.LocalDate;

public class PessoaJuridica extends  Pessoa{

    private String CNPJ;

    private String razaoSocial;


    public PessoaJuridica() {
    }

    public PessoaJuridica(String nome, LocalDate nascimento, String CNPJ, String razaoSocial) {
        super(nome, nascimento);
        this.CNPJ = CNPJ;
        this.razaoSocial = razaoSocial;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }


    @Override
    public String toString() {
        return "PessoaJuridica{" +
                "CNPJ='" + CNPJ + '\'' +
                ", razaoSocial='" + razaoSocial + '\'' +
                "} " + super.toString();
    }
}
