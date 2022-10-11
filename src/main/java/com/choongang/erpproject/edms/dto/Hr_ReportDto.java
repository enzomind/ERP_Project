package com.choongang.erpproject.edms.dto;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Hr_ReportDto {
    private Long lev_num;
    private String appr;
    private String appr_yn;
    private Date appr_date;
    private String lev_date;
    private String lev_res;
    private Date start_date;
    private Date end_date;
    private int lev_count;
    private String rej_res;

    private String emp_id;

}
