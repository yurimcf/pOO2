package br.com.americanas.polotech.aula2.atividadeAula2;

import br.com.americanas.polotech.aula2.atividadeAula2.Interface.Tabuleiro;

import java.text.DateFormat;
import java.util.Date;

public class TabuleiroImp implements Tabuleiro {
    @Override
    public void inicialize() {
        System.out.println("__________________________________________________\n" +
                "|                OKUBARO´S GAMES                 |\n" +
                "|                 JOGO DA VELHA                  |\n" +
                "|________________________________________________|");
        System.out.println("O jogo do dia:" + DateFormat.getDateInstance().format(new Date()) + "\n*PRECISAMOS DE 2 JOGADORES PARA INICIAR O JOGO*");
    }

    @Override
    public void showTabuleiro(char[][] tabuleiro) {
        for (char[] row : tabuleiro) {
            for (char collumn : row) {
                System.out.print(collumn + "   ");
            }
            System.out.println();
        }
    }

    @Override
    public void tabComJogada(int posicao, char[][] tabuleiro, char character) {
        switch (posicao) {
            case 1:
                tabuleiro[0][0] = character;
                showTabuleiro(tabuleiro);
                break;
            case 2:
                tabuleiro[0][1] = character;
                showTabuleiro(tabuleiro);
                break;
            case 3:
                tabuleiro[0][2] = character;
                showTabuleiro(tabuleiro);
                break;
            case 4:
                tabuleiro[1][0] = character;
                showTabuleiro(tabuleiro);
                break;
            case 5:
                tabuleiro[1][1] = character;
                showTabuleiro(tabuleiro);
                break;
            case 6:
                tabuleiro[1][2] = character;
                showTabuleiro(tabuleiro);
                break;
            case 7:
                tabuleiro[2][0] = character;
                showTabuleiro(tabuleiro);
                break;
            case 8:
                tabuleiro[2][1] = character;
                showTabuleiro(tabuleiro);
                break;
            case 9:
                tabuleiro[2][2] = character;
                showTabuleiro(tabuleiro);
                break;

            default:
                break;
        }
    }
}

