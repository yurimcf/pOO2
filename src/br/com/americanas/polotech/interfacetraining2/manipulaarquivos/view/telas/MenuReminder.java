package br.com.americanas.polotech.interfacetraining2.manipulaarquivos.view.telas;

import br.com.americanas.polotech.interfacetraining2.manipulaarquivos.model.DAO.HandlerFile;
import br.com.americanas.polotech.interfacetraining2.manipulaarquivos.model.entity.MFile;
import br.com.americanas.polotech.interfacetraining2.manipulaarquivos.model.enums.MFileAnnotationTypeEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuReminder {
    public static void MenuReminderCrud(HandlerFile handlerFile) {
        Scanner sc = new Scanner(System.in);
        Boolean iskeepGoing = Boolean.TRUE;
        String diretory = handlerFile.getDirRoot();
        String dirReminder = diretory + "reminder\\";
        List<MFile> saveAllFiles;

        do {
            System.out.println("=========================");
            System.out.println("[1]. Criar Arquivo REMINDER");
            System.out.println("[2]. Remover Arquivo REMINDER");
            System.out.println("[3]. Recuperar(mostrar conteúdo) Arquivo REMINDER");
            System.out.println("[4]. Listar Todos ARQUIVOS REMINDER");
            System.out.println("[5]. Criar vários arquivos (+ de 1)");
            System.out.println("[6]. Voltar");
            System.out.println("=========================");
            System.out.println("Chosen Option");
            Integer choice = sc.nextInt();
            sc.skip("((?<!\\R)\\s)*");
            MFile mFile = null;
            String nameFile = null;
            String contentText = null;
            MFileAnnotationTypeEnum type = null;

            switch (choice) {
                case 1:
                    // criar arquivo
                    mFile = new MFile();
                    System.out.println("Digite o nome do arquivo");
                    nameFile = sc.nextLine().trim() + ".txt";
                    System.out.println("Digite o Texto do arquivo");
                    contentText = sc.nextLine();

                    System.out.println(
                            "Que tipo é esse arquivos?\n"+
                            "[1]. Reminder\n" +
                            "[2]. Important\n" +
                            "[3]. Simples\n");
                    int value = sc.nextInt();
                    sc.skip("((?<!\\R)\\s)*");
                    type = MFileAnnotationTypeEnum.values()[value];
                    if (value > 0 && value < MFileAnnotationTypeEnum.values().length) {
                        mFile.setType(type);
                        mFile.setNameFile(nameFile);
                        mFile.setContent(contentText);
                        mFile.setPath(diretory);
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
//                    System.out.println("Digite o Diretório do arquivo que deseja excluir");
//                    String dir = sc.nextLine().trim();
                    mFile.setNameFile(fileName);
                    mFile.setPath(dirReminder);
                    boolean status = handlerFile.removeFileWithDirectory(mFile);
                    if (status) {
                        System.out.println("Arquivo excluido com sucesso");
                    } else {
                        System.out.println("Erro ao excluir arquivo");
                    }
                    break;

                case 3:
                    // recuperar arquivos (mostrar arquivo)
                    mFile = new MFile();
                    System.out.println("Nome do Arquivo para ler");
                    mFile.setNameFile(sc.nextLine() + ".txt");
                    mFile.setPath(dirReminder);
                    handlerFile.recoveryFileWithDirectory(mFile);
                    break;
                case 4:
                    // Listar arquivos
                    System.out.println("=========================");
                    System.out.println("Listando Todas as Imagens");
                    handlerFile.listAllFiles(dirReminder);
                    System.out.println("=========================");
                    break;
                case 5:
                    //criar varios arquivos
                    boolean keepIt = true;
                    saveAllFiles = new ArrayList<>();
                    do {
                        MFile mFileList = new MFile();
                        System.out.println("Escreva o nome do aquivo");
                        nameFile = sc.nextLine();
                        System.out.println("Escreva o texto do arquivo");
                        contentText = sc.nextLine();
                        System.out.println("Que que arquivo é esse?");
                        // tem que ter alguma coisa aqui
                        mFileList.setNameFile(nameFile);
                        mFileList.setPath(dirReminder);
                        mFileList.setContent(contentText);
                        mFileList.setType(MFileAnnotationTypeEnum.REMINDER);
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
