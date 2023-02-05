package br.com.americanas.polotech.interfaces.training2.manipula.arquivos.model.dao.interfaces;

import br.com.americanas.polotech.interfaces.training2.manipula.arquivos.model.enums.MFileAnnotationType;

public interface FileDatabase {
    void saveFile(String directory, String content, MFileAnnotationType type, String nameFile);

    void recoveryFile(String directory, String nameFile);

    boolean removeFile(String directory, String nameFile, MFileAnnotationType type);

    void listAllFiles(String directory);
}
