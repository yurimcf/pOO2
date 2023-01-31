package br.com.americanas.polotech.interfacetraining2.manipulaarquivos.model.DAO.interfaces;

import br.com.americanas.polotech.interfacetraining2.manipulaarquivos.model.DAO.interfaces.FolderManagement;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FolderOrchestrator implements FolderManagement {
    List<String > mListPaths = new ArrayList<>();
    public void createFolders(List<String> mListPaths) {

    }
    public void removeFolders(List<String> mListPaths) {

    }

    //metodos do implements
    @Override
    public void createAFolder(String path) {
        try {
            File directory = new File(path);
            //File directory = new File("C:\\Users\\yurif\\Music\\BaseDeDados\\images\\");
            if(!directory.exists()){
                directory.mkdir();
                System.out.println("diretório criado com sucesso");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void removeAFolder(String path) {
        File directory = new File(path);
        if (!directory.isFile()){
            directory.deleteOnExit();
        }
    }

    @Override
    public void listAllFoldersCreated() {

    }
}
