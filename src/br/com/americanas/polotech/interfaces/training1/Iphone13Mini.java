package br.com.americanas.polotech.interfaces.training1;

public class Iphone13Mini implements Iphone{
    @Override
    public void exibirDetalhes() {
        System.out.println("IPhone 13 Mini\n" +
                "SO: iOS 15\n" +
                "Tela: 5,4 polegadas - Retina OLED\n" +
                "Processador: A15 Biônico\n" +
                "RAM: 4GB\n" +
                "Bateria: 2438 mAh\n");
    }
}
