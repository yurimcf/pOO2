package br.com.americanas.polotech.aula2.atividadeAula2;

import br.com.americanas.polotech.aula2.atividadeAula2.entity.Jogador;
import br.com.americanas.polotech.aula2.atividadeAula2.entity.Tabuleiro;

import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean reiniciar = true;
        TabuleiroImp tabuleiroImp = new TabuleiroImp();
        VerificaJogadaImp verificaJogadaImp = new VerificaJogadaImp();
        Jogador jogador1 = new Jogador();
        Jogador jogador2 = new Jogador();

        do {
            try {
                Tabuleiro tabuleiro = tabuleiroImp.iniciar();
                System.out.println("Informe o nome do JOGADOR1:");
                jogador1.setNome(sc.nextLine());
                jogador1.setCharacter('X');
                System.out.println("Informe o nome do JOGADOR2:");
                jogador2.setNome(sc.nextLine());
                jogador2.setCharacter('O');
                tabuleiroImp.mostrarTabuleiro(tabuleiro.getTabuleiro());

                boolean verificar = verificaJogadaImp.verificaGanhador(tabuleiro.getTabuleiro(), jogador1.getNome(), jogador2.getNome());
                int posicao = 0;
                int numJogadas = 0;
                char character = 0;
                String vezDeQuem = null;

                while ((numJogadas <= 9) && !verificar) {
                    vezDeQuem = verificaJogadaImp.verificadorDeJogada(numJogadas, jogador1, jogador2);
                    numJogadas++;
                    System.out.printf("MOVIMENTO %d: %s ESCOLHA UM NÚMERO correspondente a sua jogada:", numJogadas, vezDeQuem);
                    posicao = sc.nextInt();
                    sc.skip("((?<!\\R)\\s)*");
                    if (vezDeQuem != jogador1.getNome()) {
                        tabuleiroImp.tabuleiroComJogada(posicao, tabuleiro.getTabuleiro(), jogador2.getCharacter());
                    } else {
                        tabuleiroImp.tabuleiroComJogada(posicao, tabuleiro.getTabuleiro(), jogador1.getCharacter());
                    }
                    verificar = verificaJogadaImp.verificaGanhador(tabuleiro.getTabuleiro(), jogador1.getNome(), jogador2.getNome());

                    if (verificar) {
                        System.out.println("Jogo encerrado");
                        break;
                    }
                    while (posicao < 1 || posicao > 9) {
                        System.out.println("Você não escreveu um numero, escreva um número do tabuleiro:");
                        posicao = sc.nextInt();
                        sc.skip("((?<!\\R)\\s)*");
                        tabuleiroImp.tabuleiroComJogada(posicao, tabuleiro.getTabuleiro(), character);
                    }
                }
            } catch (Exception e) {
                System.out.println("Você não digitou um argumento válido\n:( VAMOS ENCERRAR O JOGO :(.");
                System.exit(0);
            }

            System.out.println("Deseja encerrar o jogo? Escreva: SIM para encerrar e NÃO para continuar.");
            String resp = sc.nextLine();

            if (resp.equalsIgnoreCase("SIM")) {
                reiniciar = false;
                System.out.println("OK! Jogo encerrado até a próxima");
            }
        } while (reiniciar);
    }
}
