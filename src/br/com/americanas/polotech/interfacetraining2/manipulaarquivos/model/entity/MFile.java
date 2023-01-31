package br.com.americanas.polotech.interfacetraining2.manipulaarquivos.model.entity;


public class MFile {
    private String content;
    private String nameFile;
    private MFileAnnotationTypeEnum type;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public MFileAnnotationTypeEnum getType() {
        return type;
    }

    public void setType(MFileAnnotationTypeEnum type) {
        this.type = type;
    }
}
