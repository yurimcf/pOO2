package br.com.americanas.polotech.interfacetraining2.manipulaarquivos.model.DAO;

import br.com.americanas.polotech.interfacetraining2.manipulaarquivos.model.DAO.interfaces.FolderManagement;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FolderOrchestrator implements FolderManagement {
    public void createFolders(List<String> mListPaths) {

    }

    public void removeFolders(List<String> mListPaths) {

    }

    //metodos do implements
    @Override
    public void createAFolder(String path) {
        try {
            File directory = new File(path);
            boolean status = directory.exists();
            if (!status) {
                directory.mkdir();
                System.out.println("diretório criado com sucesso");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeAFolder(String path) {
        File directory = new File(path);
        boolean status = directory.isDirectory();
        if (status) {
            File[] file = directory.listFiles();
            for (int i = 0; i < file.length; i++) {
                removeAFolder(file[i].getPath());
            }
        }
        directory.delete();
    }

    @Override
    public void listAllFoldersCreated() {
    }
}
