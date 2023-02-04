package br.com.americanas.polotech.interfacetraining2.manipulaarquivos.model.DAO.interfaces;

import br.com.americanas.polotech.interfacetraining2.manipulaarquivos.model.enums.MFileAnnotationTypeEnum;

public interface FileDatabase {
    void saveFile(String directory, String content, MFileAnnotationTypeEnum type, String nameFile);

    void recoveryFile(String directory, String nameFile);

    boolean removeFile(String directory, String nameFile, MFileAnnotationTypeEnum type);

    void listAllFiles(String directory);
}
