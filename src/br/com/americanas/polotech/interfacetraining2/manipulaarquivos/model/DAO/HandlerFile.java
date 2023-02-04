package br.com.americanas.polotech.interfacetraining2.manipulaarquivos.model.DAO;

import br.com.americanas.polotech.interfacetraining2.manipulaarquivos.model.entity.MFile;
import br.com.americanas.polotech.interfacetraining2.manipulaarquivos.model.enums.MFileAnnotationTypeEnum;

import java.util.List;

public class HandlerFile extends FileOrchestrator {
    private String dirRoot = null;

    public void setDirRoot(String dirRoot) {
        this.dirRoot = dirRoot;
    }

    public String getDirRoot() {
        return dirRoot;
    }

    public void saveListImg(List<MFile> mImageFileList) {
        saveAllListOfImageFiles(mImageFileList);
    }
    public void saveListFiles(List<MFile> mFileList) {
        saveAllListOfFiles(mFileList);
    }


    // metodos para arquivos(geral)
    public void saveFileByDirectory(MFile mFile) {
        mFile = knowType(mFile);
        createSpecificFolder(mFile);
        saveFile(mFile.getPath(),
                mFile.getContent(),
                mFile.getType(),
                mFile.getNameFile());
    }

    private MFile knowType(MFile mFile) {
        switch (mFile.getType()) {
            case IMPORTANT -> mFile.setPath(dirRoot + "important\\");
            case REMINDER -> mFile.setPath(dirRoot + "reminder\\");
            default -> mFile.setPath(dirRoot + "");
        }
        return mFile;
    }

    public boolean removeFileWithDirectory(MFile mFile) {
        if (removeFile(mFile.getPath(),
                mFile.getNameFile(),
                mFile.getType())) {
            return true;
        }
        return false;
    }

    public void recoveryFileWithDirectory(MFile mFile) {
        recoveryFile(mFile.getPath(),
                mFile.getNameFile());
    }







    //metodos para imagem
    public void saveImgWithDirectory(MFile mFile) {
        if (mFile.getType() == MFileAnnotationTypeEnum.IMAGE) {
            createAFolder(dirRoot + "\\images");
        }
        saveImageFile(mFile.getPath(),
                mFile.getContent(),
                mFile.getNameFile());
    } // FEITO

    public boolean removeImg(MFile mFile) {
        if (removeImageFile(mFile.getPath(),
                mFile.getNameFile())) {
            return true;
        }
        return false;
    } //FEITO

    private void createSpecificFolder(MFile mFile) {
        createAFolder(mFile.getPath());
    }
}
