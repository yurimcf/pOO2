package br.com.americanas.polotech.interfaces.training2.manipula.arquivos.view.telas;

import br.com.americanas.polotech.interfaces.training2.manipula.arquivos.model.dao.HandlerFile;
import br.com.americanas.polotech.interfaces.training2.manipula.arquivos.model.entity.MFile;
import br.com.americanas.polotech.interfaces.training2.manipula.arquivos.model.enums.MFileAnnotationType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuImage {
    public static void MenuImageCrud(HandlerFile handlerFile) {
        Scanner sc = new Scanner(System.in);
        Boolean iskeepGoing = Boolean.TRUE;
        String directory = handlerFile.getDirRoot() + "images\\";
        List<MFile> saveAllImgsList;
        do {
            System.out.println("----------------------------");
            System.out.println("[1]. Salvar Imagem");
            System.out.println("[2]. Remover Imagem");
            System.out.println("[3]. Listar todas Imagens");
            System.out.println("[4]. Salvar imagens (+ de 1)");
            System.out.println("[5]. Back");
            System.out.println("----------------------------");
            System.out.print("Opção:");
            Integer choice = sc.nextInt();
            sc.skip("((?<!\\R)\\s)*");
            System.out.println("----------------------------");
            MFile mFile = null;

            switch (choice) {
                case 1 -> {
                    // adiconar
                    mFile = new MFile();
                    System.out.println("Escreva a URL da imagem");
                    String urlImg = sc.nextLine();
                    System.out.println("Escreva no mome da Imagem");
                    String nameImg = sc.nextLine().trim() + ".jpg";
                    mFile.setContent(urlImg);
                    mFile.setNameFile(nameImg);
                    mFile.setPath(directory);
                    mFile.setType(MFileAnnotationType.IMAGE);
                    handlerFile.saveImgWithDirectory(mFile);
                    System.out.println("----------------------------");
                }
                case 2 -> {
                    //remover imagem
                    mFile = new MFile();
                    System.out.println("Digite o nome da imagem que deseja remover");
                    String imgRemoveName = sc.nextLine().trim() + ".jpg";
                    mFile.setNameFile(imgRemoveName);
                    mFile.setPath(directory);
                    boolean status = handlerFile.removeImg(mFile);
                    if (status) {
                        System.out.println("imagem excluido com sucesso");
                    } else {
                        System.out.println("erro imagem não encontrada");
                    }
                    System.out.println("----------------------------");
                }
                case 3 -> {
                    //listar todos as imagens
                    System.out.println("----------------------------");
                    System.out.println("Listando Todas as Imagens");
                    handlerFile.listAllImageFiles(directory);
                    System.out.println("----------------------------");
                }
                case 4 -> {
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
                        mFileList.setPath(directory);
                        mFileList.setType(MFileAnnotationType.IMAGE);
                        saveAllImgsList.add(mFileList);
                        System.out.println("Adicionar outra Musica? [S/N]");
                        String keep = sc.nextLine();
                        if (!keep.equalsIgnoreCase("s")) {
                            keepIt = false;
                        }
                    } while (keepIt);
                    handlerFile.saveListImg(saveAllImgsList);
                    System.out.println("----------------------------");
                }
                case 5 -> iskeepGoing = Boolean.FALSE;
                default -> System.out.println("Invalid option");
            }
        } while (iskeepGoing);
    }
}