package br.com.americanas.polotech.interfacetraining2.manipulaarquivos.model.DAO.interfaces;

import br.com.americanas.polotech.interfacetraining2.manipulaarquivos.model.entity.MFile;
import br.com.americanas.polotech.interfacetraining2.manipulaarquivos.model.entity.MFileAnnotationTypeEnum;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileOrchestrator extends FolderOrchestrator implements ImageFileDatabase, FileDatabase {
    private static List<MFile> mImageFileList = new ArrayList<>();
    private static List<MFile> mFileList = new ArrayList<>();

    public void saveAllListOfFiles(List<MFile> mFileList) {

    }

    public void saveAllListOfImageFiles(List<MFile> mImageFileList) {

    }

    //metodos do ImageFileDatabase
    @Override
    public void saveImageFile(String directory, String content, String nameFile) {
        MFile mFile = new MFile();
        mFile.setNameFile(nameFile);
        mFile.setContent(content);
        mFile.setType(MFileAnnotationTypeEnum.IMAGE);
        BufferedImage image;
        mImageFileList.add(mFile);
        try {
            URL url = new URL(content);
            image = ImageIO.read(url);
            ImageIO.write(image,
                    "jpg",
                    new File(directory + nameFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void recoveryImageFile(String directory) {
        for (MFile mFile : mImageFileList) {
        }
        // NÃO SEI O QUE FAZER AQUI


    }

    @Override
    public void removeImageFile(String directory, String nameFile) {
        File url = new File(directory + nameFile);
        url.delete();

    }

    @Override
    public void listAllImageFiles(String diretory) {
        File urlList = new File(diretory);
        File[] files = urlList.listFiles();
        List<File> mImageFileList = new ArrayList<>(Arrays.stream(files).toList());
        mImageFileList.forEach(System.out::println);

    }

    //metodos do FileDatabase
    @Override
    public void saveFile(String directory, String content, MFileAnnotationTypeEnum type, String nameFile) {

    }

    @Override
    public void recoveryFile(String directory, String nameFile) {

    }

    @Override
    public void removeFile(String directory, String nameFile, MFileAnnotationTypeEnum type) {

    }

    @Override
    public void listAllFiles(String directory) {

    }
}
