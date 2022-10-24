package com.choongang.erpproject.board.dto;

import lombok.Data;

@Data
public class BoardDto {

    long boardNum;
    private String title;
    private String writer;
    private String password;
    private String content;
    private String date;
    private int cbnNum;
    private String start;
    private String end;



}
