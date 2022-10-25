package com.choongang.erpproject.info.dao;

import com.choongang.erpproject.info.dto.NoticeDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {
    void updateNotice(long ntcNum, String title, String content, String uuid, String fileName);
    void deleteNotice(long ntcNum);
    void insertNotice(String title, String content,String uuid, String fileName);

    List<NoticeDto> selectNoticeList();
    void updateViewCnt(long ntcNum);
    NoticeDto selectNotice(long ntcNum);

    List<NoticeDto> searchnotice(String start, String end, String title);
}
