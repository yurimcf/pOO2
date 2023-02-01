package br.com.americanas.polotech.interfacetraining2.manipulaarquivos.model.DAO.interfaces;

public interface ImageFileDatabase {
    void saveImageFile(String directory, String content, String nameFile);
    void recoveryImageFile(String directory, String nameFile);
    void removeImageFile(String directory, String nameFile);
    void listAllImageFiles(String diretory);
}
