package com.choongang.erpproject.info.dto;

import lombok.Data;

@Data
public class NoticeDto {
    long ntcNum;
    private String title;    // unique 한 파일 이름을 만들기 위한 속성
    private String writer;    // 실제 파일 이름
    private String content;
    private String date;
    private String fileName;
    private String uuid;
    private int cbnNum;
    private String start;
    private String end;




}
