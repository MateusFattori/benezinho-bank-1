package br.com.benezinhobank.pessoa.model;

import java.time.LocalDate;
import java.util.Arrays;

public class PessoaJuridica extends Pessoa {

    private String CNPJ;

    private String razaoSocial;


    private Pessoa[] socios;



    public PessoaJuridica() {
    }

    public PessoaJuridica(String nome, LocalDate nascimento, String CNPJ, String razaoSocial, Pessoa[] socios) {
        super(nome, nascimento);
        this.setCNPJ(CNPJ);
        this.setRazaoSocial(razaoSocial);
        this.setSocios(socios);
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


    public Pessoa[] getSocios() {
        return socios;
    }

    public void setSocios(Pessoa[] socios) {
        this.socios = socios;
    }

    @Override
    public String toString() {
        return "PessoaJuridica{" +
                "CNPJ='" + CNPJ + '\'' +
                ", razaoSocial='" + razaoSocial + '\'' +
                ", socios=" + Arrays.toString(socios) +
                "} " + super.toString();
    }
}
