package br.com.americanas.polotech.interfacetraining2.manipulaarquivos.control;

import br.com.americanas.polotech.interfacetraining2.manipulaarquivos.model.DAO.HandlerFile;
import br.com.americanas.polotech.interfacetraining2.manipulaarquivos.view.telas.MenuImage;
import br.com.americanas.polotech.interfacetraining2.manipulaarquivos.view.telas.MenuImportant;
import br.com.americanas.polotech.interfacetraining2.manipulaarquivos.view.telas.MenuReminder;
import br.com.americanas.polotech.interfacetraining2.manipulaarquivos.view.telas.MenuSimple;

import java.util.Scanner;

public class TesteAtividade1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Boolean iskeepGoing = Boolean.TRUE;
        HandlerFile handlerFile = new HandlerFile();
        System.out.println("Digite o diretório Raiz:");
//        String dirRoot = sc.nextLine() +"\\";
        String dirRoot = "E:\\zbancoDeDados" +"\\";
        handlerFile.setDirRoot(dirRoot);

        do {
            System.out.println("=========================");
            System.out.println("[1]. Ir para Menu Imagem");
            System.out.println("[2]. Ir para Menu Reminder");
            System.out.println("[3]. Ir para Menu Important");
            System.out.println("[4]. Ir para Menu Simple");
            System.out.println("[5]. Exit");
            System.out.println("=========================");
            System.out.println("Chosen Option");
            Integer choice = sc.nextInt();

            switch (choice) {
                case 1:
                    MenuImage.MenuImageCrud(handlerFile); //Feito funcional
                    break;
                case 2:
                    MenuReminder.MenuReminderCrud(handlerFile);
                    break;
                case 3:
                    MenuImportant.MenuImportantCrud(handlerFile);
                    break;
                case 4:
                    MenuSimple.MenuSimpleCrud(handlerFile);
                    break;
                case 5:
                    iskeepGoing = Boolean.FALSE;
                default:
                    System.out.println("Invalid option");
            }
        } while (iskeepGoing);
        sc.close();
    }
}
