package br.com.americanas.polotech.interfacetraining2.manipulaarquivos.model.DAO;

import br.com.americanas.polotech.interfacetraining2.manipulaarquivos.model.entity.MFile;
import br.com.americanas.polotech.interfacetraining2.manipulaarquivos.model.entity.MFileAnnotationTypeEnum;

import java.util.ArrayList;
import java.util.List;

public class HandlerFile extends FileOrchestrator {
    private String directoryRoot = "C:\\Users\\yurif\\Music\\BaseDeDados\\";
    static List<MFile> mFileList = new ArrayList<>();
    static List<MFile> mImageFileList = new ArrayList<>();

    public void setDirectoryRoot(String directoryRoot) {
        this.directoryRoot = directoryRoot;
    }

    public String getDirectoryRoot() {
        return directoryRoot;
    }

    public void saveAllImg() {
        saveAllListOfImageFiles(mImageFileList);
    }


    // metodos para arquivos(geral)
    public void saveFileWithDirectory(MFile mFile) {
        mFile = knowType(mFile);
        createSpecificFolder(mFile);
        saveFile(mFile.getPath(),
                mFile.getContent(),
                mFile.getType(),
                mFile.getNameFile());
        mFileList.add(mFile);
    }

    private MFile knowType (MFile mFile){
        switch (mFile.getType()) {
            case IMAGE -> mFile.setPath(mFile.getPath() + "image\\");
            case IMPORTANT -> mFile.setPath(mFile.getPath() + "important\\");
            case REMINDER -> mFile.setPath(mFile.getPath() + "reminder\\");
            default -> mFile.setPath(mFile.getPath() + "");
        }
        return mFile;
    }

    public void removeFileWithDirectory(MFile mFile) {
        removeFile(mFile.getPath(),
                mFile.getNameFile(),
                mFile.getType());
        mFileList.remove(mFile.getNameFile());
    }

    public void recoveryFileWithDirectory(MFile mFile) {
        recoveryFile(mFile.getPath(),
                mFile.getNameFile());
    }

    public void listAllFilesSaved(String Directory) {
        listAllFiles(Directory);
    }

    //metodos para imagem
    public void saveImgWithDirectory(MFile mFile) {
        if (mFile.getType() == MFileAnnotationTypeEnum.IMAGE) {
            createAFolder(directoryRoot + "\\images");
        }
        saveImageFile(mFile.getPath(),
                mFile.getContent(),
                mFile.getNameFile());
        mImageFileList.add(mFile);
    }

    public void removeImgWithDirectory(MFile mFile) {
        removeImageFile(mFile.getPath(),
                mFile.getNameFile());
    }

    public void recoveryImgWithDirectory(MFile mFile) {
        // não implementar por agora
        recoveryImageFile(mFile.getPath(),
                mFile.getNameFile());
    }

    public void createSpecificFolder(MFile mFile) {
            createAFolder(mFile.getPath());
    }
}
