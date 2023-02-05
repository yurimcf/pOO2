package br.com.americanas.polotech.interfaces.training1;

public class ComprarIphone {
    public static void main(String[] args) {
        IphoneFactory factory = new IphoneFactory();
        factory.cadastrarIphone(IphoneFactory.TypeIphoneEnum.IPHONE_9);
        factory.cadastrarIphone(IphoneFactory.TypeIphoneEnum.IPHONE_X);
        factory.cadastrarIphone(IphoneFactory.TypeIphoneEnum.IPHONE_13_MINI);

//        Iphone iphone = new IphoneFactory().cadastrarIphone(IphoneFactory.TypeIphoneEnum.IPHONE_9);
//        iphone.exibirDetalhes();

    }
}
