import br.com.benezinhobank.model.Agencia;
import br.com.benezinhobank.model.Banco;
import br.com.benezinhobank.model.ContaCorrente;
import br.com.benezinhobank.model.ContaPoupanca;
import br.com.benezinhobank.pessoa.model.Pessoa;
import br.com.benezinhobank.pessoa.model.PessoaFisica;
import br.com.benezinhobank.pessoa.model.PessoaJuridica;

import javax.swing.*;
import java.time.LocalDate;
import java.time.MonthDay;

public class Main {

    public static Agencia novaAgencia(String nome, Banco banco) {
        Agencia agencia = new Agencia();
        agencia.setNome(nome);
        banco.addAgencia(agencia);
        return agencia;
    }

    public static PessoaFisica novaPessoa(String nome, LocalDate nascimento, String CPF, PessoaFisica mae) {
        PessoaFisica pf = new PessoaFisica();
        pf.setCPF(CPF);
        pf.setNascimento(nascimento);
        pf.setNome(nome);
        pf.setMae(mae);
        return pf;
    }

    public static ContaCorrente novaContaCorrente(Agencia agencia, Pessoa titular, double limite) {
        ContaCorrente cc = new ContaCorrente();
        cc.setAgencia(agencia);
        cc.setTitular(titular);
        cc.setLimite(limite);
        agencia.addConta(cc);
        return cc;
    }

    public static ContaPoupanca novaContaPoupanca(Agencia agencia, Pessoa titular, MonthDay dia) {
        ContaPoupanca cp = new ContaPoupanca();
        cp.setAniversario(dia.getDayOfMonth());
        cp.setAgencia(agencia);
        cp.setTitular(titular);
        agencia.addConta(cp);
        return cp;
    }

    public static void main(String[] args) {

        Banco benezinho = new Banco("Benezinho Bank");
        Agencia osasco = novaAgencia("Osasco", benezinho);
        PessoaFisica mae = novaPessoa("Maria Raquel", LocalDate.of(1946, 10, 9), "213241651-20", null);
        PessoaFisica bene = novaPessoa("Benefrancis do Nascimento", LocalDate.of(1977, 3, 8), "213246546-50", mae);
        ContaCorrente cc = novaContaCorrente(osasco, bene, 2000);
        ContaPoupanca cp = novaContaPoupanca(osasco, mae, MonthDay.now());


        PessoaJuridica holding = new PessoaJuridica();
        holding.setCNPJ("1231312/0001-09");
        holding.setNascimento(LocalDate.of(1988, 10, 5));
        holding.setNome("Benezinho Holding");
        holding.setRazaoSocial("Benezinho Holding SA");

        PessoaFisica lucca = new PessoaFisica();
        lucca.setCPF("132132132132");
        lucca.setNascimento(LocalDate.of(2004, 8, 19));
        lucca.setNome("Lucca Freitas");
        lucca.setMae(mae);

        Pessoa[] socios = new Pessoa[3];
        socios[0] = bene;
        socios[1] = mae;
        socios[2] = lucca;

        holding.setSocios(socios);


        ContaCorrente ccH = new ContaCorrente();
        ccH.setNumero("3-7");
        ccH.setLimite(500);
        ccH.setSaldo(1000);
        ccH.setTitular(holding);
        ccH.setAgencia(osasco);

//        System.out.println(ccH);
//
//        System.out.println(bene);


        for (int i = 0; i < socios.length; i++) {
            System.out.println(socios[i]);
        }

        int continua = 0;
        System.out.println("SALDO ANTERIOR: " + ccH.getSaldo());
        System.out.println("Limite: " + ccH.getLimite());
        System.out.println("Disponível: " + (ccH.getSaldo() + ccH.getLimite()));

        do {

            double valor = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor que deseja sacar"));

            boolean saquei = ccH.sacar(valor);

            if (saquei) {
                System.out.println("Saque efetuado com sucesso!");
            } else {
                System.out.println("Erro no saque");
            }

            String texto = """
                    Deseja realizar um novo saque?
                    [1] SIM
                    [2] NÃO
                    """;
            continua = Integer.parseInt(JOptionPane.showInputDialog(texto));

        } while (continua == 1);

        System.out.println("SALDO ANTERIOR: " + ccH.getSaldo());
        System.out.println("Limite: " + ccH.getLimite());
        System.out.println("Disponível: " + (ccH.getSaldo() + ccH.getLimite()));

    }
}