package br.com.americanas.polotech.interfacetraining2.manipulaarquivos.view.telas;

import br.com.americanas.polotech.interfacetraining2.manipulaarquivos.model.DAO.HandlerFile;
import br.com.americanas.polotech.interfacetraining2.manipulaarquivos.model.entity.MFile;
import br.com.americanas.polotech.interfacetraining2.manipulaarquivos.model.enums.MFileAnnotationTypeEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuImage {
    public static void MenuImageCrud(HandlerFile handlerFile) {
        Scanner sc = new Scanner(System.in);
        Boolean iskeepGoing = Boolean.TRUE;
        String diretory = handlerFile.getDirRoot() + "images\\";
        List<MFile> saveAllImgsList;
        do {
            System.out.println("=========================");
            System.out.println("[1]. Salvar Imagem");
            System.out.println("[2]. Remover Imagem");
            System.out.println("[3]. Listar todas Imagens");
            System.out.println("[4]. Salvar imagens (+ de 1)");
            System.out.println("[5]. Back");
            System.out.println("=========================");
            System.out.println("Opção escolhida:");
            Integer choice = sc.nextInt();
            sc.skip("((?<!\\R)\\s)*");
            MFile mFile = null;

            switch (choice) {
                case 1:
                    // adiconar
                    mFile = new MFile();
                    System.out.println("Escreva a URL da imagem");
                    String urlImg = sc.nextLine();
                    System.out.println("Escreva no mome da Imagem");
                    String nameImg = sc.nextLine().trim() + ".jpg";
                    mFile.setContent(urlImg);
                    mFile.setNameFile(nameImg);
                    mFile.setPath(diretory);
                    mFile.setType(MFileAnnotationTypeEnum.IMAGE);
                    handlerFile.saveImgWithDirectory(mFile);
                    break;

                case 2:
                    //remover imagem
                    mFile = new MFile();
                    System.out.println("=========================");
                    System.out.println("Digite o nome da imagem que deseja remover");
                    String imgRemoveName = sc.nextLine().trim() + ".jpg";
                    mFile.setNameFile(imgRemoveName);
                    mFile.setPath(diretory);
                    boolean status = handlerFile.removeImg(mFile);
                    if (status) {
                        System.out.println("imagem excluido com sucesso");
                    } else {
                        System.out.println("erro imagem não encontrada");
                    }
                    System.out.println("=========================");
                    break;

                case 3:
                    //listar todos as imagens
                    System.out.println("=========================");
                    System.out.println("Listando Todas as Imagens");
                    handlerFile.listAllImageFiles(diretory);
                    System.out.println("=========================");
                    break;
                case 4:
                    boolean keepIt = true;
                    saveAllImgsList = new ArrayList<>();
                    do {
                        MFile mFileList = new MFile();
                        System.out.println("Escreva a URL da imagem");
                        String urlImgs = sc.nextLine();
                        System.out.println("Escreva no mome da Imagem");
                        String name = sc.nextLine().trim() + ".jpg";
                        mFileList.setContent(urlImgs);
                        mFileList.setNameFile(name);
                        mFileList.setPath(diretory);
                        mFileList.setType(MFileAnnotationTypeEnum.IMAGE);
                        saveAllImgsList.add(mFileList);
                        System.out.println("Adicionar outra Musica? [S/N]");
                        String keep = sc.nextLine();
                        if (!keep.equalsIgnoreCase("s")) {
                            keepIt = false;
                        }
                    } while (keepIt);
                    handlerFile.saveListImg(saveAllImgsList);
                    break;

                case 5:
                    iskeepGoing = Boolean.FALSE;
                    break;

                default:
                    System.out.println("Invalid option");
            }


        } while (iskeepGoing);
    }
}

