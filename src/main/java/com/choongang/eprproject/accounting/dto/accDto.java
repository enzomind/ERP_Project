package com.choongang.eprproject.accounting.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class accDto {


//    회계전표 리스트
//    전표번호, 거래처명, 전표 생성일자, 지출금액, 수입금액;
//    상세내역(지출결의서)
//    결의번호, 기안자, 승인자, 승인일자, 거래처명(카드/계좌), 지출금액, 수입금액;

    //전표 정보
    private int stat_num; //전표번호
    private LocalDateTime stat_date; //전표발생날짜

    //카드/계좌 정보
    private String com_acc; // 카드/계좌(거래처명)

    //유저테이블 정보
    private int emp_id; //사번
    private String emp_name; //기안자

    //지출결의서 정보
    private String exp_num; //결의번호
    private LocalDateTime appl_date; //신청일자(지출결의서 상신일자)
    private LocalDateTime appr_date; //지출결의서 승인일자
    private String appr; //승인자
    private int expense; //지출금액
    private int income; //수입금액

}
