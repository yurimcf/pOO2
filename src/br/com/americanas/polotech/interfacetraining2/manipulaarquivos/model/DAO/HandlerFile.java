package br.com.americanas.polotech.interfacetraining2.manipulaarquivos.model.DAO;

import br.com.americanas.polotech.interfacetraining2.manipulaarquivos.model.entity.MFile;

import java.util.ArrayList;
import java.util.List;

public class HandlerFile extends FileOrchestrator {
    private String directoryRoot = "C:\\Users\\yurif\\Music\\BaseDeDados\\";
    List<MFile> mFileList = new ArrayList<>();

    public void setDirectoryRoot(String directoryRoot) {
        this.directoryRoot = directoryRoot;
    }

    public String getDirectoryRoot() {
        return directoryRoot;
    }


    // metodos para arquivos(geral)
    public void saveFileWithDirectory(String directory, MFile mFile) {
        saveFile(directory,
                mFile.getContent(),
                mFile.getType(),
                mFile.getNameFile());
    }

    public void removeFileWithDirectory(String directory, MFile mFile) {
        removeFile(directory,
                mFile.getNameFile(),
                mFile.getType());
    }

    public void recoveryFileWithDirectory(String directory, MFile mFile) {
        recoveryFile(directory,
                mFile.getNameFile());
    }

    public void listAllFilesSaved(String Directory) {
        listAllFiles(Directory);
    }

    //metodos para imagem
    public void saveImgWithDirectory(String directory, MFile mFile) {
        saveImageFile(directory,
                mFile.getContent(),
                mFile.getNameFile());
    }

    public void removeImgWithDirectory(String directory, String nameFile) {
        removeImageFile(directory, nameFile);
    }

    public void recoveryImgWithDirectory(String directory) {
        recoveryImageFile(directory);
    }
}
