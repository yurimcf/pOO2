package br.com.americanas.polotech.interfaces.training2.manipula.arquivos.model.dao;

import br.com.americanas.polotech.interfaces.training2.manipula.arquivos.model.dao.interfaces.FolderManagement;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FolderOrchestrator implements FolderManagement {
    List <String> mListPaths = new ArrayList<>();
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
                mListPaths.add(path);
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
        } else {
            directory.delete();
        }
    }

    @Override
    public void listAllFoldersCreated() {

    }
}
