package br.com.americanas.polotech.interfaces.training2.manipula.arquivos.model.dao.interfaces;

public interface ImageFileDatabase {
    void saveImageFile(String directory, String content, String nameFile);

    void recoveryImageFile(String directory, String nameFile);

    boolean removeImageFile(String directory, String nameFile);

    void listAllImageFiles(String directory);
}
