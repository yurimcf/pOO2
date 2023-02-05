package br.com.americanas.polotech.interfaces.training2.notifica.eventos;

public class Pessoa {
    private String nome;
    private String mensagem;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String toString() {
        return "{" + "nome='" + nome + '\'' + " received a message: ->" + mensagem + '\'' + '}';
    }
}
