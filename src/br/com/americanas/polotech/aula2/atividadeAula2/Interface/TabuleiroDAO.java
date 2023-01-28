package br.com.americanas.polotech.aula2.atividadeAula2.Interface;

public interface TabuleiroDAO {
    void iniciar();

    void mostrarTabuleiro(char[][] tabuleiro);

    void tabuleiroComJogada(int posicao, char[][] tabuleiro, char character);

}
