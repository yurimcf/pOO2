package br.com.americanas.polotech.aula2.atividadeAula2.Interface;

import br.com.americanas.polotech.aula2.atividadeAula2.entity.Jogador;

public interface VeficadaJogada {

    boolean verificaGanhador(char[][] tabuleiro, String jogador1, String jogador2);

    String verificadorDeJogada(int n, Jogador jogador1, Jogador jogador2);
}
