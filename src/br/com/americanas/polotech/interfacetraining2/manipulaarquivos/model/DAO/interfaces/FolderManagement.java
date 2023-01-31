package br.com.americanas.polotech.interfacetraining2.manipulaarquivos.model.DAO.interfaces;

public interface FolderManagement {
    void createAFolder(String path);
    void removeAFolder(String path);
    void listAllFoldersCreated();
}
