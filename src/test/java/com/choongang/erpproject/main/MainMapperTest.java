//package com.choongang.erpproject.main;
//
//import com.choongang.erpproject.main.dto.MainRequestDto;
//import com.choongang.erpproject.main.dto.MainResponseDto;
//import com.choongang.erpproject.main.mapper.MainMapper;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.time.LocalDate;
//import java.util.List;
//import java.util.Map;
//
//@SpringBootTest
//public class MainMapperTest {
//
//    @Autowired
//    MainMapper mainMapper;
//
//    @Test
//    void getCalAll() {
//
//        MainRequestDto mainRequestDto = new MainRequestDto();
//
//        mainRequestDto.setStartDate(LocalDate.parse("2022-10-15"));
//
//        List<Map<String, Object>> allList = mainMapper.getCalAll();
//        System.out.println("전체 건 수 : " + allList.size() + "건");
//
//        List<MainResponseDto> detailList = mainMapper.getCalDetail(mainRequestDto);
//        System.out.println("상세 건 수 : " + detailList.size() + "건");
//
//    }
//
//}
