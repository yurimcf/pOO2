package br.com.americanas.polotech.interfacetraining2.manipulaarquivos.view.telas;

import br.com.americanas.polotech.interfacetraining2.manipulaarquivos.model.DAO.interfaces.HandlerFile;
import br.com.americanas.polotech.interfacetraining2.manipulaarquivos.model.entity.MFile;

import java.util.Scanner;

public class MenuImage {
    public static void MenuImage(){
        Scanner sc = new Scanner(System.in);
        Boolean iskeepGoing = Boolean.TRUE;
        HandlerFile handlerFile = new HandlerFile();

        String diretory = handlerFile.getDirectoryRoot() + "images\\";
        int num =1;
        do {
            System.out.println("=========================");
            System.out.println("[1]. Salvar Imagem");
            System.out.println("[2]. Remover Imagem");
            System.out.println("[3]. Recupere Imagem");
            System.out.println("[4]. Listar todas Imagens");
            System.out.println("[5]. Criar um diretório para images");
            System.out.println("[6]. Back");
            System.out.println("=========================");
            System.out.println("Opção escolhida:");
            Integer choice = sc.nextInt();

            switch (choice) {
                case 1:
                    MFile mFile = new MFile();
                    System.out.println("=========================");
                    System.out.println("Escreva a URL da imagem");
                    //String urlImg = sc.nextLine();
                    String urlImg = "https://raw.githubusercontent.com/gabiandrade/" +
                            "programacao-orientada-objetos-java/main/src/com/ada/example/" +
                            "segunda/aula/exercicio/File_.jpeg";
                    mFile.setContent(urlImg);
                    System.out.println("=========================");
                    System.out.println("Escreva no mome da Imagem");
                    mFile.setNameFile("image_"+num+".jpg");
                    num++;
                    //mFile.setNameFile(sc.nextLine());
                    System.out.println("=========================");
                    System.out.println("Escreva o diretório para salval a imagem:");
                    diretory = sc.nextLine();
                    handlerFile.saveImageFile(diretory,urlImg,mFile.getNameFile());
                    System.out.println("=========================");
                    break;
                case 2:
                    System.out.println("=========================");
                    System.out.println("Digite o nome da imagem que deseja remover");
                    //String imgRemoveName = sc.nextLine()+".jpg;
                    String imgRemoveName = "image_1"+".jpg";
                    System.out.println("=========================");
                    System.out.println("Digite o diretório da imagem à excluir");
                    diretory = sc.nextLine();

                    handlerFile.removeImageFile(diretory, imgRemoveName);

                    System.out.println("=========================");
//                    int lastSlashindex = urlImg.lastIndexOf('/');
//                    mFile.setNameFile(urlImg.substring(lastSlashindex + 1));
                    break;
                case 3:
                    System.out.println("=========================");
                    System.out.println("Forneceça o nome da imagem que deseja recuperar:");
                    //String recoveryImg = sc.nextLine() + ".jpg;
                    String recoveryImg = "image_1" +".jpg";
                    System.out.println("=========================");
                    System.out.println("Digite o diretório da imagem à recuperar");
                    diretory = sc.nextLine();
                    handlerFile.recoveryImageFile(diretory);

                    System.out.println("=========================");
                    break;
                case 4:
                    System.out.println("=========================");
                    System.out.println("Listando Todas as Imagens");
                    handlerFile.listAllImageFiles(diretory);
                    System.out.println("=========================");
                    break;
                case 5:
                    System.out.println("=========================");
                    System.out.println("Diretório atual");
                    System.out.println(diretory);
                    System.out.println("=========================");
                    System.out.println("Digite o Diretório:");
                    //diretory = sc.nextLine();
                    diretory = handlerFile.getDirectoryRoot() + "images\\";
                    handlerFile.createAFolder(diretory);
                    System.out.println("=========================");
                    break;
                case 6:
                    iskeepGoing = Boolean.FALSE;
                default:
                    System.out.println("Invalid option");
            }



        }while (iskeepGoing);
    }
}
