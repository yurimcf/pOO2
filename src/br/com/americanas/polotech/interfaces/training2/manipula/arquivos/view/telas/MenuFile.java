package br.com.americanas.polotech.interfaces.training2.manipula.arquivos.view.telas;

import br.com.americanas.polotech.interfaces.training2.manipula.arquivos.model.dao.HandlerFile;
import br.com.americanas.polotech.interfaces.training2.manipula.arquivos.model.entity.MFile;
import br.com.americanas.polotech.interfaces.training2.manipula.arquivos.model.enums.MFileAnnotationTypeEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuFile {
    public static void MenuFileCrud(HandlerFile handlerFile) {
        Scanner sc = new Scanner(System.in);
        Boolean iskeepGoing = Boolean.TRUE;
        List<MFile> saveAllFiles;

        do {
            System.out.println("[1]. Criar Arquivo");
            System.out.println("[2]. Remover Arquivo");
            System.out.println("[3]. Recuperar (mostrar conteúdo) Arquivo");
            System.out.println("[4]. Listar Todos ARQUIVOS REMINDER");
            System.out.println("[5]. Criar vários arquivos (+ de 1)"); // feito chekar
            System.out.println("[6]. Voltar");
            System.out.println();
            System.out.println("Chosen Option");
            Integer choice = sc.nextInt();
            sc.skip("((?<!\\R)\\s)*");
            MFile mFile = null;
            String nameFile = null;
            String contentText = null;
            MFileAnnotationTypeEnum type = null;
            Integer value = null;

            switch (choice) {
                case 1:
                    // criar arquivo
                    mFile = new MFile();
                    System.out.println("Digite o nome do arquivo");
                    nameFile = sc.nextLine().trim() + ".txt";
                    System.out.println("Digite o Texto do arquivo");
                    contentText = sc.nextLine();

                    System.out.println(
                            "Que tipo é esse arquivos?\n" +
                                    "[1]. Reminder\n" +
                                    "[2]. Important\n" +
                                    "[3]. Simples");
                    value = sc.nextInt();
                    sc.skip("((?<!\\R)\\s)*");
                    type = MFileAnnotationTypeEnum.values()[value];
                    if (value > 0 && value < MFileAnnotationTypeEnum.values().length) {
                        mFile.setType(type);
                        mFile.setNameFile(nameFile);
                        mFile.setContent(contentText);
                        handlerFile.saveFileByDirectory(mFile);
                    } else {
                        System.out.println("Escolha um dos 3 valores");
                    }
                    break;

                case 2:
                    // remover Arquivos
                    mFile = new MFile();
                    System.out.println("Digite o nome do arquivo que seje Excluir");
                    String fileName = sc.nextLine().trim() + ".txt";
                    System.out.println(
                            "Que tipo é esse arquivos?\n" +
                                    "[1]. Reminder\n" +
                                    "[2]. Important\n" +
                                    "[3]. Simples\n" +
                                    "Escolha: ");
                    value = sc.nextInt();
                    sc.skip("((?<!\\R)\\s)*");
                    type = MFileAnnotationTypeEnum.values()[value];
                    if (value > 0 && value < MFileAnnotationTypeEnum.values().length) {
                        mFile.setNameFile(fileName);
                        mFile.setType(type);
                        boolean status = handlerFile.removeFileByDirectory(mFile);
                        if (status) {
                            System.out.println("Arquivo excluido com sucesso");
                        } else {
                            System.out.println("Erro ao excluir arquivo");
                        }
                    } else {
                        System.out.println("Escolha um dos 3 valores");
                    }

                    break;

                case 3:
                    // recuperar arquivos (mostrar arquivo)
                    mFile = new MFile();
                    System.out.println("Nome do Arquivo para ler");
                    mFile.setNameFile(sc.nextLine() + ".txt");
                    boolean find = handlerFile.searchFile(mFile);
                    if (!find) {
                        System.out.println("Arquivo não encontrado");
                    }
                    System.out.println();
                    break;

                case 4:
                    // Listar arquivos
                    mFile = new MFile();
                    System.out.println(
                            "Listar qual pasta arquivos?\n" +
                                    "[1]. Reminder\n" +
                                    "[2]. Important\n" +
                                    "[3]. Simples\n" +
                                    "Escolha: ");
                    value = sc.nextInt();
                    type = MFileAnnotationTypeEnum.values()[value];
                    if (value > 0 && value < MFileAnnotationTypeEnum.values().length) {
                        mFile.setType(type);
                        handlerFile.knowTypePath(mFile);
                        System.out.println("Listando Todas os Arquivos");
                        handlerFile.listAllFiles(mFile.getPath());
                        System.out.println();
                    } else {
                        System.out.println("Escolha um dos 3 valores");
                    }
                    break;

                case 5: // checkar isso

                    //criar varios arquivos
                    boolean keepIt = true;
                    saveAllFiles = new ArrayList<>();
                    MFile mFileList;
                    do {
                        mFileList = new MFile();
                        System.out.println("Digite o nome do arquivo");
                        nameFile = sc.nextLine().trim() + ".txt";
                        System.out.println("Digite o Texto do arquivo");
                        contentText = sc.nextLine();

                        System.out.println(
                                "Que tipo é esse arquivos?\n" +
                                        "[1]. Reminder\n" +
                                        "[2]. Important\n" +
                                        "[3]. Simples");
                        value = sc.nextInt();
                        sc.skip("((?<!\\R)\\s)*");
                        type = MFileAnnotationTypeEnum.values()[value];
                        if (value > 0 && value < MFileAnnotationTypeEnum.values().length) {
                            mFileList.setType(type);
                            mFileList.setNameFile(nameFile);
                            mFileList.setContent(contentText);
                        } else {
                            System.out.println("Escolha um dos 3 valores");
                        }
                        saveAllFiles.add(mFileList);
                        System.out.println("Adicionar outro arquivo? [S/N]");
                        String keep = sc.nextLine();
                        if (!keep.equalsIgnoreCase("s")) {
                            keepIt = false;
                        }
                    } while (keepIt);
                    handlerFile.saveListFiles(saveAllFiles);
                    break;
                case 6:
                    iskeepGoing = Boolean.FALSE;
                    break;
                default:
                    System.out.println("Invalid option");
            }
        } while (iskeepGoing);
    }
}
