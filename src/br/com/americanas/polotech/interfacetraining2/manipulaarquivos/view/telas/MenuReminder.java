package br.com.americanas.polotech.interfacetraining2.manipulaarquivos.view.telas;

import br.com.americanas.polotech.interfacetraining2.manipulaarquivos.model.DAO.HandlerFile;
import br.com.americanas.polotech.interfacetraining2.manipulaarquivos.model.entity.MFile;
import br.com.americanas.polotech.interfacetraining2.manipulaarquivos.model.entity.MFileAnnotationTypeEnum;

import java.util.Scanner;

public class MenuReminder {
    public static void MenuReminderCrud() {
        Scanner sc = new Scanner(System.in);
        Boolean iskeepGoing = Boolean.TRUE;
        HandlerFile handlerFile = new HandlerFile();
        String diretory = handlerFile.getDirectoryRoot();
        String dirReminder = handlerFile.getDirectoryRoot() + "reminder\\";

        do {
            System.out.println("=========================");
            System.out.println("[1]. Criar Arquivo REMINDER");
            System.out.println("[2]. Remover Arquivo REMINDER");
            System.out.println("[3]. Recuperar(mostrar conteúdo) Arquivo REMINDER");
            System.out.println("[4]. Criar diretório Adicional");
            System.out.println("[5]. Listar Todos ARQUIVOS REMINDER");
            System.out.println("=========================");
            System.out.println("Chosen Option");
            Integer choice = sc.nextInt();
            sc.skip("((?<!\\R)\\s)*");
            MFile mFile = null;

            switch (choice) {
                case 1:
                    mFile = new MFile();
                    // criar arquivo
                    System.out.println("Digite o nome do arquivo");
                    String nameFile = sc.nextLine().trim() + ".txt";
                    mFile.setNameFile(nameFile);
                    System.out.println("Digite o Texto do arquivo");
                    String contentText = sc.nextLine();
                    mFile.setContent(contentText);
                    mFile.setType(MFileAnnotationTypeEnum.REMINDER);
                    mFile.setPath(diretory);
                    //handlerFile.createAFolder(diretory);
                    handlerFile.saveFileWithDirectory(mFile);
                    break;
                case 2:
                    // remover Arquivos
                    mFile = new MFile();
                    System.out.println("Digite o nome do arquivo que seje Excluir");
                    String fileName = sc.nextLine().trim() + ".txt";
                    mFile.setNameFile(fileName);
                    System.out.println("Digite o Diretório do arquivo que deseja excluir");
                    String dir = sc.nextLine().trim();
                    mFile.setPath(dir);
                    handlerFile.removeFileWithDirectory(mFile);

                    break;
                case 3:
                    // recuperar arquivos
                    mFile = new MFile();
                    System.out.println("Nome do Arquivo para ler");
                    mFile.setNameFile(sc.nextLine() + ".txt");
                    mFile.setPath(dirReminder);
                    handlerFile.recoveryFileWithDirectory(mFile);
                    break;
                case 4:
                    // criar diretório adicional
                    System.out.println("Digite o nome da pasta");
                    String nameFolder = sc.nextLine();
                    handlerFile.createAFolder(diretory + nameFolder);
                    break;
                case 5:
                    // salvar todas os arquivos
                    //handlerFile.saveAllListOfFiles();
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
