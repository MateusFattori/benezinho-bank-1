import br.com.benezinhobank.model.Agencia;
import br.com.benezinhobank.model.Banco;
import br.com.benezinhobank.model.ContaCorrente;
import br.com.benezinhobank.model.ContaPoupanca;
import br.com.benezinhobank.pessoa.model.Pessoa;
import br.com.benezinhobank.pessoa.model.PessoaFisica;
import br.com.benezinhobank.pessoa.model.PessoaJuridica;

import javax.swing.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Banco benezinho = new Banco("Benezinho Bank");

        Agencia osasco = new Agencia();
        osasco.setBanco(benezinho);
        osasco.setNome("Osasco");
        osasco.setNumero("1-9");

        PessoaFisica mae = new PessoaFisica();
        mae.setNome("Maria Raquel");
        mae.setNascimento(LocalDate.of(1946, 10, 9));
        mae.setCPF("213241651-20");

        PessoaFisica bene = new PessoaFisica();
        bene.setCPF("213246546-50");
        bene.setNascimento(LocalDate.of(1977, 3, 8));
        bene.setNome("Benefrancis do Nascimento");
        bene.setMae(mae);

        ContaCorrente cc = new ContaCorrente();
        cc.setAgencia(osasco);
        cc.setTitular(bene);
        cc.setSaldo(1_000_000.99);
        cc.setLimite(5_000_000);
        cc.setNumero("1-9");

        ContaPoupanca cp = new ContaPoupanca();
        cp.setNumero("2-8");
        cp.setAniversario(4);
        cp.setAgencia(osasco);
        cp.setSaldo(500_000);
        cp.setTitular(mae);

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
                    Deseja realizar umnovo saque?
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