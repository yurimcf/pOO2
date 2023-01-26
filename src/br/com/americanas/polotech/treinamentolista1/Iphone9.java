package br.com.americanas.polotech.treinamentolista1;

public class Iphone9 implements Iphone{
    @Override
    public void exibirDetalhes() {
        System.out.println("IPhone 9\n" +
                "SO: iOS 13\n" +
                "Tela: 4,7 polegadas - IPS LCD\n" +
                "Processador: Apple A13 Bionic\n" +
                "RAM: 3 GB\n" +
                "Bateria: 2050 mAh\n");
    }
}
