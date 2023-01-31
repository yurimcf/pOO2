package br.com.americanas.polotech.interfacetraining2.notificadordeeventos;

public class MainNotificacao {
    public static void main(String[] args) {
        Boolean validador = Boolean.TRUE;
        FabricarMensagem fabricarMensagem = new FabricarMensagem();
        while (validador) {
            fabricarMensagem.recebeNumPessoas();
            if (fabricarMensagem.getNumPessoas() <= 0){
                validador = Boolean.FALSE;
            }
            fabricarMensagem.recebeMensagem();
            fabricarMensagem.recebeNomePessoas();
            fabricarMensagem.exibirMensagem();
            fabricarMensagem.limparRegistros();
        }
    }
}
