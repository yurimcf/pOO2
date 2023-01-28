package br.com.americanas.polotech.aula2.atividadeAula2.Interface;

import br.com.americanas.polotech.aula2.atividadeAula2.entity.Tabuleiro;

public interface TabuleiroDAO {
    Tabuleiro iniciar();

    void mostrarTabuleiro(char[][] tabuleiro);

    void tabuleiroComJogada(int posicao, char[][] tabuleiro, char character);

}
