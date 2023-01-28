package br.com.americanas.polotech.aula2.atividadeAula2;

import br.com.americanas.polotech.aula2.atividadeAula2.Interface.VeficadaJogada;
import br.com.americanas.polotech.aula2.atividadeAula2.entity.Jogador;

public class VerificaJogadaImp implements VeficadaJogada {

    @Override
    public boolean verificaGanhador(char[][] tabuleiro, String jogador1, String jogador2) {
        if (tabuleiro[0][0] == 'X' && tabuleiro[1][0] == 'X' && tabuleiro[2][0] == 'X') {
            System.out.println(jogador1 + " VENCEU A PARTIDA!");
            return true;
        } else if (tabuleiro[0][1] == 'X' && tabuleiro[1][1] == 'X' && tabuleiro[2][1] == 'X') {
            System.out.println(jogador1 + " VENCEU A PARTIDA!");
            return true;
        } else if (tabuleiro[0][2] == 'X' && tabuleiro[1][2] == 'X' && tabuleiro[2][2] == 'X') {
            System.out.println(jogador1 + " VENCEU A PARTIDA!");
            return true;
        } else if (tabuleiro[0][0] == 'X' && tabuleiro[0][1] == 'X' && tabuleiro[0][2] == 'X') {
            System.out.println(jogador1 + " VENCEU A PARTIDA!");
            return true;
        } else if (tabuleiro[1][0] == 'X' && tabuleiro[1][1] == 'X' && tabuleiro[1][2] == 'X') {
            System.out.println(jogador1 + " VENCEU A PARTIDA!");
            return true;
        } else if (tabuleiro[2][0] == 'X' && tabuleiro[2][1] == 'X' && tabuleiro[2][2] == 'X') {
            System.out.println(jogador1 + " VENCEU A PARTIDA!");
            return true;
        } else if (tabuleiro[0][0] == 'X' && tabuleiro[1][1] == 'X' && tabuleiro[2][2] == 'X') {
            System.out.println(jogador1 + " VENCEU A PARTIDA!");
            return true;
        } else if (tabuleiro[0][2] == 'X' && tabuleiro[1][1] == 'X' && tabuleiro[2][0] == 'X') {
            System.out.println(jogador1 + " VENCEU A PARTIDA!");
            return true;
        }

        if (tabuleiro[0][0] == 'O' && tabuleiro[1][0] == 'O' && tabuleiro[2][0] == 'O') {
            System.out.println(jogador2 + " VENCEU A PARTIDA!");
            return true;
        } else if (tabuleiro[0][1] == 'O' && tabuleiro[1][1] == 'O' && tabuleiro[2][1] == 'O') {
            System.out.println(jogador2 + " VENCEU A PARTIDA!");
            return true;
        } else if (tabuleiro[0][2] == 'O' && tabuleiro[1][2] == 'O' && tabuleiro[2][2] == 'O') {
            System.out.println(jogador2 + " VENCEU A PARTIDA!");
            return true;
        }

        if (tabuleiro[0][0] == 'O' && tabuleiro[0][1] == 'O' && tabuleiro[0][2] == 'O') {
            System.out.println(jogador2 + " VENCEU A PARTIDA!");
            return true;
        } else if (tabuleiro[1][0] == 'O' && tabuleiro[1][1] == 'O' && tabuleiro[1][2] == 'O') {
            System.out.println(jogador2 + " VENCEU A PARTIDA!");
            return true;
        } else if (tabuleiro[2][0] == 'O' && tabuleiro[2][1] == 'O' && tabuleiro[2][2] == 'O') {
            System.out.println(jogador2 + " VENCEU A PARTIDA!");
            return true;
        }

        if (tabuleiro[0][0] == 'O' && tabuleiro[1][1] == 'O' && tabuleiro[2][2] == 'O') {
            System.out.println(jogador2 + " VENCEU A PARTIDA!");
            return true;
        } else if (tabuleiro[0][2] == 'O' && tabuleiro[1][1] == 'O' && tabuleiro[2][0] == 'O') {
            System.out.println(jogador2 + " VENCEU A PARTIDA!");
            return true;
        }
        return false;
    }

    @Override
    public String verificadorDeJogada(int n, Jogador jogador1, Jogador jogador2) {
        String vezDeQuem = null;
        if (n % 2 == 0) {
            vezDeQuem = jogador1.getNome();
        } else {
            vezDeQuem = jogador2.getNome();
        }

        if (n > 8) {
            System.out.println("AHHHH O JOGO DEU VELHA! EMPATE!!!!");
        }
        return vezDeQuem;
    }
}

