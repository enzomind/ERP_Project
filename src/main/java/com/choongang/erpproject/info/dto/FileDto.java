package com.choongang.erpproject.info.dto;

import lombok.Data;

@Data

public class FileDto {
    private String uuid;    // unique 한 파일 이름을 만들기 위한 속성
    private String fileName;    // 실제 파일 이름
    private String contentType;

    public String getSavedfile() {
        this.savedfile = this.getUuid() + this.getFileName();
        return savedfile;
    }

    public void setSavedfile(String savedfile) {
        this.savedfile = savedfile;
    }

    private String savedfile;

    public FileDto() {
    }

    public FileDto(String uuid, String fileName, String contentType) {
        this.uuid = uuid;
        this.fileName = fileName;
        this.contentType = contentType;
        System.out.println(contentType);
    }


}