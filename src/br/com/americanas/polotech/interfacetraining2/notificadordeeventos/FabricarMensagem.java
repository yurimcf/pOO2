package br.com.americanas.polotech.interfacetraining2.notificadordeeventos;

import java.util.Scanner;

public class FabricarMensagem implements NotificarEventos {
    private Integer numPessoas;
    private Pessoa[] pessoasEMensagem;
    private String mensagem;

    public Integer getNumPessoas() {
        return numPessoas;
    }

    public String getMensagem() {
        return mensagem;
    }

    @Override
    public void recebeNumPessoas() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o numero de pessoas que irá receber a notificação:");
        numPessoas = sc.nextInt();
        sc.skip("((?<!\\R)\\s)*");
    }

    @Override
    public void recebeNomePessoas() {
        Scanner sc = new Scanner(System.in);
        pessoasEMensagem = new Pessoa[numPessoas];
        for (int i = 0; i < pessoasEMensagem.length; i++) {
            Pessoa pessoa = new Pessoa();
            System.out.println("Digite os nomes:");
            pessoa.setNome(sc.nextLine().trim());
            pessoa.setMensagem(mensagem.trim());
            pessoasEMensagem[i] = pessoa;
            System.out.println(pessoasEMensagem[i].getNome() + " received a message: -> " +
                    pessoasEMensagem[i].getMensagem());
        }
    }

    @Override
    public void recebeMensagem() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mensagem que deseja enviar: ");
        mensagem = sc.nextLine();
    }

    @Override
    public void exibirMensagem() {
        System.out.println("Mensagens Enviadas para: ");
        for (Pessoa pessoa : pessoasEMensagem) {
            System.out.println(pessoa);
        }
    }

    @Override
    public void limparRegistros() {
        pessoasEMensagem = null;
        numPessoas = null;
        mensagem = null;
    }
}
