package com.choongang.erpproject.employee.service;

import com.choongang.erpproject.employee.dto.*;

import com.choongang.erpproject.employee.dao.EmpMapper;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class EmpServiceImpl implements EmpService {

    private final EmpMapper empMapper;

    //직원 조회
    @Override
    public List<HrTableDto> getHrTable() {

        List<HrTableDto> Hrlist = Collections.emptyList();

        Hrlist = empMapper.getHrTable();

        return Hrlist;
    }

    @Override
    public List<HrTableDto> getHrTable(HrTableDto hrTableDto) {

        List<HrTableDto> Hrlist = Collections.emptyList();

        Hrlist = empMapper.getHrTable(hrTableDto);

        return Hrlist;
    }

    //직원정보 조회
    @Override
    public List<EmpTableDto> getEmpTable(String empId) {
        List<EmpTableDto> Emplist = Collections.emptyList();

        Emplist = empMapper.getEmpTable(empId);

        return Emplist;
    }

    //서명정보
    @Override
    public List<EmpSignDto> getEmpSign(String empId) {
        List<EmpSignDto> EmpSign = Collections.emptyList();
        EmpSign = empMapper.getEmpSign(empId);
        return EmpSign;
    }

    //직원 등록
    @Override
    public void empInput(EmpInputDto empInputDto) {
        empMapper.empInput(empInputDto);
    }

    //직원 수정
    @Override
    public void empUpdate(EmpUpdateDto empUpdateDto) {
        empMapper.empUpdate(empUpdateDto);
    }


    //생년월일 부여 메소드
    public static String getBirthday(String IdpNo1){
        // 주민 앞자리 나누기
        int ssn0 = Integer.parseInt(IdpNo1.substring(0, 2));
        String ssn1 = IdpNo1.substring(0, 2);
        String ssn2 = IdpNo1.substring(2, 4);
        String ssn3 = IdpNo1.substring(4, 6);

        //오늘 날짜 계산
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String transNow = format.format(now);
        int noYY = Integer.parseInt(transNow.substring(2,4));

        if (ssn0 < noYY) {
            IdpNo1 = "20" + ssn1 + "-" + ssn2 + "-" + ssn3;
        } else if (!(ssn0 < noYY)) {
            IdpNo1 = "19" + ssn1 + "-" + ssn2 + "-" + ssn3;
        } else {
            IdpNo1 = "-1";
        }
        if(IdpNo1.equals("-1")) return "재입력필요";

        return IdpNo1;

    }
    //권한코드 부여 메소드
    public static String getAuthCode(String depNo, String jobCode) {
        String authCode = "";

        switch (jobCode) {
            //부장급이하 사원 직급코드 부여
            case "SJPS_0001":
            case "SJPS_0002":
            case "SJPS_0003":
            case "SJPS_0004":
            case "SJPS_0005":
                switch (depNo){
                    case "SJDP_0001" :
                        authCode = "SJAU_0004";
                        break;
                    case "SJDP_0002" :
                        authCode = "SJAU_0005";
                        break;
                    case "SJDP_0003" :
                    case "SJDP_0004" :
                    case "SJDP_0005" :
                        authCode = "SJAU_0001";
                        break;
                    case "SJDP_0006" :
                        authCode = "SJAU_0003";
                        break;
                } return authCode;


                //부장급이상 임원 코드 부여
            case "SJPS_0006":
            case "SJPS_0007":
            case "SJPS_0008":
            case "SJPS_0009":
                authCode = "SJAU_0002";
                break;

            default :
                System.out.println("권한코드 부여 코드 오류"); break;
        }
        return authCode;
    }


}
