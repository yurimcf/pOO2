package br.com.americanas.polotech.aula2.atividadeAula2;

import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String reiniciar = "";
        TabuleiroImp tabuleiroImp = new TabuleiroImp();
        VerificaJogadaImp verificaJogadaImp = new VerificaJogadaImp();
        do {
            try {
                tabuleiroImp.inicialize();
                System.out.println("Informe o nome do JOGADOR1:");
                Jogador jogador1 = new Jogador();
                jogador1.setNome(sc.nextLine());
                System.out.println("Informe o nome do JOGADOR2:");
                Jogador jogador2 = new Jogador();
                jogador2.setNome(sc.nextLine());

                char[][] tabuleiro = {{'1', '2', '3'},
                        {'4', '5', '6'},
                        {'7', '8', '9'}};

                tabuleiroImp.showTabuleiro(tabuleiro);

                boolean verificar = verificaJogadaImp.verificaGanhador(tabuleiro, jogador1.getNome(), jogador2.getNome());
                int posicao = 0;
                int n = 0;
                char character;
                String vezDeQuem;

                while ((n <= 9) && !verificar) { //verificar == false
                    if (n % 2 == 0) {
                        vezDeQuem = jogador1.getNome();
                        character = 'X';
                    } else {
                        vezDeQuem = jogador2.getNome();
                        character = 'O';
                    }

                    if (n > 8) {
                        System.out.println("AHHHH O JOGO DEU VELHA! EMPATE!!!!");
                        break;
                    }
                    n++;
                    System.out.printf("MOVIMENTO %d: %s ESCOLHA UM NÚMERO correspondente a sua jogada:", n, vezDeQuem);
                    posicao = sc.nextInt();
                    tabuleiroImp.tabComJogada(posicao, tabuleiro, character);
                    verificar = verificaJogadaImp.verificaGanhador(tabuleiro, jogador1.getNome(), jogador2.getNome());

                    if (verificar) {
                        verificaJogadaImp.verificaGanhador(tabuleiro, jogador1.getNome(), jogador2.getNome());
                        System.out.println("Jogo encerrado");
                        break;
                    }

                    while (posicao < 1 || posicao > 9) {
                        System.out.println("Você não escreveu um numero, escreva um número no tabuleiro:");
                        posicao = sc.nextInt();
                        tabuleiroImp.tabComJogada(posicao, tabuleiro, character);
                    }
                }

            } catch (Exception e) {
                System.out.println("Você não digitou um argumento válido\n:( VAMOS ENCERRAR O JOGO :(.");
                System.exit(0);
            }

            System.out.println("Deseja encerrar o jogo? Escreva: SIM para encerrar e NÃO para continuar.");
            reiniciar = sc.next().toUpperCase();
            if (reiniciar.equalsIgnoreCase("SIM")) {
                System.out.println("OK! Jogo encerrado até a próxima");
                System.exit(0);
            }
        } while (reiniciar != "SIM");
    }
}
