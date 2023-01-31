package br.com.americanas.polotech.interfacetraining2.manipulaarquivos.model.DAO.interfaces;

import br.com.americanas.polotech.interfacetraining2.manipulaarquivos.model.entity.MFileAnnotationTypeEnum;

public interface FileDatabase {
    void saveFile(String directory, String content, MFileAnnotationTypeEnum type, String nameFile);

    void recoveryFile(String directory, String nameFile);

    void removeFile(String directory, String nameFile, MFileAnnotationTypeEnum type);

    void listAllFiles(String directory);
}
