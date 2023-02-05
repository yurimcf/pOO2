package br.com.americanas.polotech.interfaces.training2.manipula.arquivos.control;

import br.com.americanas.polotech.interfaces.training2.manipula.arquivos.model.dao.HandlerFile;
import br.com.americanas.polotech.interfaces.training2.manipula.arquivos.view.telas.MenuFile;
import br.com.americanas.polotech.interfaces.training2.manipula.arquivos.view.telas.MenuImage;

import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Boolean iskeepGoing = Boolean.TRUE;
        HandlerFile handlerFile = new HandlerFile();
        System.out.println("Digite o diretório Raiz:");
        String dirRoot = sc.nextLine() + "\\";
        handlerFile.setDirRoot(dirRoot);
        handlerFile.createDefautFolder(); // programa funciona sem esse metodo

        do {
            System.out.println("----------------------------");
            System.out.println("[1]. Ir para Menu Imagem");
            System.out.println("[2]. Ir para Menu Files");
            System.out.println("[3]. Excluir uma Pasta");
            System.out.println("[4]. Lista todas as Pastas Criadas");
            System.out.println("[5]. Sair");
            System.out.println("----------------------------");
            System.out.print("Opção: ");
            Integer choice = sc.nextInt();
            System.out.println("----------------------------");
            sc.skip("((?<!\\R)\\s)*");

            switch (choice) {
                case 1 -> MenuImage.MenuImageCrud(handlerFile);
                case 2 -> MenuFile.MenuFileCrud(handlerFile);
                case 3 -> {
                    handlerFile.listAllFoldersCreated(dirRoot);
                    System.out.println("Qual pasta você que deletar?");
                    String folder = sc.nextLine();
                    handlerFile.deleteFolderWithFiles(folder);
                }
                case 4 -> handlerFile.listAllFoldersCreated(dirRoot);
                case 5 -> iskeepGoing = Boolean.FALSE;
                default -> System.out.println("Invalid option");
            }
        } while (iskeepGoing);
        sc.close();
    }
}
