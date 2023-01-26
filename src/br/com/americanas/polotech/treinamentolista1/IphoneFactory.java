package br.com.americanas.polotech.treinamentolista1;

public class IphoneFactory {
    public Iphone cadastrarIphone(TypeIphoneEnum typeIphone) {
        Iphone iphone = null;
        switch (typeIphone) {
            case IPHONE_X:
                iphone = new IphoneX();
                iphone.exibirDetalhes();
                break;
            case IPHONE_9:
                iphone = new Iphone9();
                iphone.exibirDetalhes();
                break;
            case IPHONE_13_MINI:
                iphone = new Iphone13Mini();
                iphone.exibirDetalhes();
                break;
        }
        return iphone;
    }

    public enum TypeIphoneEnum {
        IPHONE_X,
        IPHONE_9,
        IPHONE_13_MINI;
    }
}
