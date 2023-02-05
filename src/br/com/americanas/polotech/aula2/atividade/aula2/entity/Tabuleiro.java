package br.com.americanas.polotech.aula2.atividade.aula2.entity;

public class Tabuleiro {
    private char[][] tabuleiro = {{'1', '2', '3'},
            {'4', '5', '6'},
            {'7', '8', '9'}};

    public char[][] getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(char[][] tabuleiro) {
        this.tabuleiro = tabuleiro;
    }
}
