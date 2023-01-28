package br.com.americanas.polotech.aula2.atividadeAula2;

import br.com.americanas.polotech.aula2.atividadeAula2.entity.Jogador;

import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean reiniciar = true;
        TabuleiroImp tabuleiroImp = new TabuleiroImp();
        VerificaJogadaImp verificaJogadaImp = new VerificaJogadaImp();
        do {
            try {
                tabuleiroImp.iniciar();
                System.out.println("Informe o nome do JOGADOR1:");
                Jogador jogador1 = new Jogador();
                jogador1.setNome(sc.nextLine());
                jogador1.setCharacter('X');
                System.out.println("Informe o nome do JOGADOR2:");
                Jogador jogador2 = new Jogador();
                jogador2.setNome(sc.nextLine());
                jogador2.setCharacter('O');

                char[][] tabuleiro = {{'1', '2', '3'},
                        {'4', '5', '6'},
                        {'7', '8', '9'}};

                tabuleiroImp.mostrarTabuleiro(tabuleiro);

                boolean verificar = verificaJogadaImp.verificaGanhador(tabuleiro, jogador1.getNome(), jogador2.getNome());
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
                    if (vezDeQuem == jogador1.getNome()) {
                        tabuleiroImp.tabuleiroComJogada(posicao, tabuleiro, jogador1.getCharacter());
                    } else {
                        tabuleiroImp.tabuleiroComJogada(posicao, tabuleiro, jogador2.getCharacter());
                    }
                    verificar = verificaJogadaImp.verificaGanhador(tabuleiro, jogador1.getNome(), jogador2.getNome());

                    if (verificar) {
                        System.out.println("Jogo encerrado");
                        break;
                    }
                    while (posicao < 1 || posicao > 9) {
                        System.out.println("Você não escreveu um numero, escreva um número no tabuleiro:");
                        posicao = sc.nextInt();
                        sc.skip("((?<!\\R)\\s)*");
                        tabuleiroImp.tabuleiroComJogada(posicao, tabuleiro, character);
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
                System.exit(0);
            }
        } while (reiniciar);
    }
}
