package br.com.americanas.polotech.interfacetraining2.manipulaarquivos.view.telas;

import br.com.americanas.polotech.interfacetraining2.manipulaarquivos.model.DAO.HandlerFile;
import br.com.americanas.polotech.interfacetraining2.manipulaarquivos.model.entity.MFile;
import br.com.americanas.polotech.interfacetraining2.manipulaarquivos.model.entity.MFileAnnotationTypeEnum;

import java.util.Scanner;

public class MenuImage {
    public static void MenuImageCrud(){
        Scanner sc = new Scanner(System.in);
        Boolean iskeepGoing = Boolean.TRUE;
        HandlerFile handlerFile = new HandlerFile();

        String diretory = handlerFile.getDirectoryRoot() + "images\\";
        int num =1;
        do {
            System.out.println("=========================");
            System.out.println("[1]. Salvar Imagem");
            System.out.println("[2]. Remover Imagem");
            System.out.println("[3]. Recupere Imagem (indisponivel)");
            System.out.println("[4]. Listar todas Imagens");
            System.out.println("[5]. Criar/Adicionar diretorio");
            System.out.println("[6]. Back");
            System.out.println("=========================");
            System.out.println("Opção escolhida:");
            Integer choice = sc.nextInt();
            sc.skip("((?<!\\R)\\s)*");

            switch (choice) {
                case 1:
                    // adiconar imagem
                    MFile mFile = new MFile();
                    System.out.println("Escreva a URL da imagem");
                    //String urlImg = sc.nextLine();
                    String urlImg = "https://raw.githubusercontent.com/gabiandrade/" +
                            "programacao-orientada-objetos-java/main/src/com/ada/example/" +
                            "segunda/aula/exercicio/File_.jpeg";
                    mFile.setContent(urlImg);
                    System.out.println("Escreva no mome da Imagem");
//                    String nameImg = sc.nextLine().trim()+".jpg";
                    mFile.setNameFile("image_"+num+".jpg");
                    num++;
                    //mFile.setNameFile(nameImg);
//                    System.out.println("O nome da Pasta que deseja salvar a imagem:");
//                    String dir = "\\"+ sc.nextLine().trim();
                    String dir ="";

                    mFile.setPath(diretory + dir);
                    mFile.setType(MFileAnnotationTypeEnum.IMAGE);
                    handlerFile.saveImgWithDirectory(mFile);
                    break;
                case 2:
                    //remover imagem
                    MFile file = new MFile();
                    System.out.println("=========================");
                    System.out.println("Digite o nome da imagem que deseja remover");
                    //String imgRemoveName = sc.nextLine().trim()+".jpg;
                    String imgRemoveName = "image_1"+".jpg";
                    file.setNameFile(imgRemoveName);
                    System.out.println("=========================");
                    System.out.println("Digite o diretório da imagem à excluir");
                    String dirRemove = sc.nextLine();
                    file.setPath(dirRemove);

                    handlerFile.removeImgWithDirectory(file);

                    System.out.println("=========================");
//                    int lastSlashindex = urlImg.lastIndexOf('/');
//                    mFile.setNameFile(urlImg.substring(lastSlashindex + 1));
                    break;
                case 3:
                    break;
                case 4:
                    //listar todos as imagens
                    System.out.println("=========================");
                    System.out.println("Listando Todas as Imagens");
                    handlerFile.listAllImageFiles(diretory);
                    System.out.println("=========================");
                    break;
                case 5:
                    //atualizar diretório
                    System.out.println("=========================");
                    System.out.println("Diretório atual");
                    System.out.println(diretory);
                    System.out.println("=========================");
                    System.out.println("Digite o Diretório:");
                    String dirAdd = sc.nextLine().trim();
                    handlerFile.createAFolder(diretory + dirAdd);
                    diretory = diretory + dirAdd;
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
