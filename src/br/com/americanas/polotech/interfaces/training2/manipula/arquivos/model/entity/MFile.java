package br.com.americanas.polotech.interfaces.training2.manipula.arquivos.model.entity;


import br.com.americanas.polotech.interfaces.training2.manipula.arquivos.model.enums.MFileAnnotationTypeEnum;

public class MFile {
    private String nameFile;
    private String path;
    private String content;
    private MFileAnnotationTypeEnum type;

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MFileAnnotationTypeEnum getType() {
        return type;
    }

    public void setType(MFileAnnotationTypeEnum type) {
        this.type = type;
    }
}
