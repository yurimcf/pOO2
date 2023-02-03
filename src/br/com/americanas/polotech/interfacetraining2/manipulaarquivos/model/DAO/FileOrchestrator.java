package br.com.americanas.polotech.interfacetraining2.manipulaarquivos.model.DAO;

import br.com.americanas.polotech.interfacetraining2.manipulaarquivos.model.DAO.interfaces.FileDatabase;
import br.com.americanas.polotech.interfacetraining2.manipulaarquivos.model.DAO.interfaces.ImageFileDatabase;
import br.com.americanas.polotech.interfacetraining2.manipulaarquivos.model.entity.MFile;
import br.com.americanas.polotech.interfacetraining2.manipulaarquivos.model.entity.MFileAnnotationTypeEnum;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileOrchestrator extends FolderOrchestrator implements ImageFileDatabase, FileDatabase {
    public void saveAllListOfFiles(List<MFile> mFileList) {
        for (int i = 0; i < mFileList.size(); i++) {
            MFile mFile = mFileList.get(i);
            saveFile(mFile.getPath(), mFile.getContent(), mFile.getType(), mFile.getNameFile());
        }
    }

    public void saveAllListOfImageFiles(List<MFile> mImageFileList) {
        for (int i = 0; i < mImageFileList.size(); i++) {
            MFile file = mImageFileList.get(i);
            saveImageFile(file.getPath(), file.getContent(), file.getNameFile());
        }
    }

    //metodos do ImageFileDatabase
    @Override
    public void saveImageFile(String directory, String content, String nameFile) {
        BufferedImage image;
        try {
            URL url = new URL(content);
            image = ImageIO.read(url);
            ImageIO.write(image, "jpg", new File(directory + nameFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    } //FEITO

    @Override
    public void recoveryImageFile(String directory, String nameFile) {
        //não Implementar por agora
    }

    @Override
    public boolean removeImageFile(String directory, String nameFile) {
        File dir = new File(directory + "\\" + nameFile);
        boolean status = dir.isFile();
        if (status) {
            dir.delete();
            return true;
        }
        return false;
    } // FEITO

    @Override
    public void listAllImageFiles(String diretory) {
        File dirFiles = new File(diretory);
        File[] files = dirFiles.listFiles();
        List<File> mImageFileList = new ArrayList<>(Arrays.stream(files).toList());
        mImageFileList.forEach(file -> {
            int lastSlashIndex = file.toString().lastIndexOf('\\');
            String nameFile = file.toString().substring(lastSlashIndex + 1);
            System.out.println(nameFile);
        });
    } // FEITO IMPRIMIR SÓ O NOME

    //metodos do FileDatabase
    @Override
    public void saveFile(String directory, String content, MFileAnnotationTypeEnum type, String nameFile) {
        File file = new File(directory + nameFile);
        boolean status = file.exists();
        if (!status) {
            try {
                file.createNewFile();
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(content);
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
        String path = directory + nameFile;
        File file = new File(directory + nameFile);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado");;
        }
    }

    @Override
    public void removeFile(String directory, String nameFile, MFileAnnotationTypeEnum type) {
        File dir = new File(directory + "\\" + nameFile);
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
