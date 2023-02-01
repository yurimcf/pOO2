package br.com.americanas.polotech.interfacetraining2.manipulaarquivos.model.DAO;

import br.com.americanas.polotech.interfacetraining2.manipulaarquivos.model.DAO.interfaces.FileDatabase;
import br.com.americanas.polotech.interfacetraining2.manipulaarquivos.model.DAO.interfaces.ImageFileDatabase;
import br.com.americanas.polotech.interfacetraining2.manipulaarquivos.model.entity.MFile;
import br.com.americanas.polotech.interfacetraining2.manipulaarquivos.model.entity.MFileAnnotationTypeEnum;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileOrchestrator extends FolderOrchestrator implements ImageFileDatabase, FileDatabase {
    private static List<MFile> mImageFileList = new ArrayList<>();
    private static List<MFile> mFileList = new ArrayList<>();

    public void saveAllListOfFiles(List<MFile> mFileList) {
        for (int i = 0; i < mFileList.size(); i++) {
            MFile mFile = mFileList.get(i);
            saveFile(null,
                    mFile.getContent(),
                    mFile.getType(),
                    mFile.getNameFile());
        }
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
        mImageFileList.add(mFile);
        BufferedImage image;
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
        File dir = new File(directory + nameFile);
        dir.delete();

    }

    @Override
    public void listAllImageFiles(String diretory) {
        File dirFiles = new File(diretory);
        File[] files = dirFiles.listFiles();
        List<File> mImageFileList = new ArrayList<>(Arrays.stream(files).toList());
        mImageFileList.forEach(System.out::println);

    }

    //metodos do FileDatabase
    @Override
    public void saveFile(String directory, String content, MFileAnnotationTypeEnum type, String nameFile) {
        MFile mFile = new MFile();
        mFile.setNameFile(nameFile);
        mFile.setContent(content);
        mFile.setType(type);
        mFileList.add(mFile);

        File file = new File(directory + nameFile);
        boolean status = file.exists();
        if (!status) {
            try {
                file.createNewFile();
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(mFile.getContent());
                fileWriter.flush();
                fileWriter.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Nome do Arquivo já existe");
        }
    }

    @Override
    public void recoveryFile(String directory, String nameFile) {

    }

    @Override
    public void removeFile(String directory, String nameFile, MFileAnnotationTypeEnum type) {
        File dir = new File(directory + nameFile);
        dir.delete();
    }

    @Override
    public void listAllFiles(String directory) {
        File dirFiles = new File(directory);
        File[] files = dirFiles.listFiles();
        List<File> mImageFileList = new ArrayList<>(Arrays.stream(files).toList());
        mImageFileList.forEach(System.out::println);
    }
}
