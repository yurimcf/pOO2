package br.com.americanas.polotech.interfaces.training2.manipula.arquivos.model.dao.interfaces;

public interface FolderManagement {
    void createAFolder(String path);

    void removeAFolder(String path);

    void listAllFoldersCreated(String path);
}
