package br.com.americanas.polotech.interfaces.training1;

public class IphoneX implements Iphone{

    @Override
    public void exibirDetalhes() {
        System.out.println("IPhone X\n" +
                "SO: iOS 11.1.1 pode ser atualizado para iOS 13.5\n" +
                "Tela: 5,8 polegadas - Super Retina OLED\n" +
                "Processador: Apple A11 Bionic\n" +
                "RAM: 3 GB\n" +
                "Bateria: 2716 mAh\n");

    }
}
