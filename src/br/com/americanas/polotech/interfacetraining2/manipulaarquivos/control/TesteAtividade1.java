package br.com.americanas.polotech.interfacetraining2.manipulaarquivos.control;

import br.com.americanas.polotech.interfacetraining2.manipulaarquivos.model.DAO.interfaces.HandlerFile;
import br.com.americanas.polotech.interfacetraining2.manipulaarquivos.model.entity.MFile;
import br.com.americanas.polotech.interfacetraining2.manipulaarquivos.view.telas.MenuImage;

import java.util.Scanner;

public class TesteAtividade1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MFile mFile = new MFile();
        Boolean iskeepGoing = Boolean.TRUE;
        HandlerFile handlerFile = new HandlerFile();
        do{
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
                    MenuImage.MenuImage();
                    break;
                case 2:
                    TesteAtividade1.MenuReminder();
                    break;
                case 3:
                    TesteAtividade1.MenuImportant();
                    break;
                case 4:
                    TesteAtividade1.MenuSimples();
                    break;
                case 5:
                    iskeepGoing = Boolean.FALSE;
                default:
                    System.out.println("Invalid option");
            }
        }while (iskeepGoing);
    }

    public static void MenuReminder(){
        Scanner sc = new Scanner(System.in);
        Boolean iskeepGoing = Boolean.TRUE;
        do {
            System.out.println("=========================");
            System.out.println("=========================");
            System.out.println("Chosen Option");
            Integer choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("=========================");
                    System.out.println("=========================");
                    break;
                case 2:
                    System.out.println("=========================");
                    System.out.println("=========================");
                    break;
                case 3:
                    System.out.println("=========================");
                    System.out.println("=========================");
                    break;
                case 4:
                    System.out.println("=========================");
                    System.out.println("=========================");
                    break;
                case 5:
                    iskeepGoing = Boolean.FALSE;
                default:
                    System.out.println("Invalid option");
            }

        }while (iskeepGoing);

    }
    public static void MenuImportant(){
        Scanner sc = new Scanner(System.in);
        Boolean iskeepGoing = Boolean.TRUE;
        do {
            System.out.println("=========================");
            System.out.println("=========================");
            System.out.println("Chosen Option");
            Integer choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("=========================");
                    System.out.println("=========================");
                    break;
                case 2:
                    System.out.println("=========================");
                    System.out.println("=========================");
                    break;
                case 3:
                    System.out.println("=========================");
                    System.out.println("=========================");
                    break;
                case 4:
                    System.out.println("=========================");
                    System.out.println("=========================");
                    break;
                case 5:
                    iskeepGoing = Boolean.FALSE;
                default:
                    System.out.println("Invalid option");
            }


        }while (iskeepGoing);

    }
    public static void MenuSimples(){
        Scanner sc = new Scanner(System.in);
        Boolean iskeepGoing = Boolean.TRUE;
        do {
            System.out.println("=========================");
            System.out.println("=========================");
            System.out.println("Chosen Option");
            Integer choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("=========================");
                    System.out.println("=========================");
                    break;
                case 2:
                    System.out.println("=========================");
                    System.out.println("=========================");
                    break;
                case 3:
                    System.out.println("=========================");
                    System.out.println("=========================");
                    break;
                case 4:
                    System.out.println("=========================");
                    System.out.println("=========================");
                    break;
                case 5:
                    iskeepGoing = Boolean.FALSE;
                default:
                    System.out.println("Invalid option");
            }

        }while (iskeepGoing);

    }
}
