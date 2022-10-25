package com.choongang.erpproject.board.dao;

import com.choongang.erpproject.board.dto.BoardDto;
import com.choongang.erpproject.info.dto.NoticeDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    void updateBoard(long boardNum, String title, String content);
    void deleteBoard(long boardNum);
    void insertBoard(BoardDto boardDto);
    List<BoardDto> selectBoardList();
    BoardDto selectBoard(long boardNum);
    void updateViewCnt(long boardNum);

    List<BoardDto> searchBoard(String start, String end, String title);
}
