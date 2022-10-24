package com.choongang.erpproject.board.service;

import com.choongang.erpproject.board.dao.BoardMapper;
import com.choongang.erpproject.board.dto.BoardDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    @Autowired
    BoardMapper boardMapper;

    public BoardDto read(long boardNum) {
        BoardDto list = boardMapper.selectBoard(boardNum);
        return list;
    }
}
