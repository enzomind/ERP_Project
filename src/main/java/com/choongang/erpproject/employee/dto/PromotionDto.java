package com.choongang.erpproject.employee.dto;



import lombok.*;




@Data
public class PromotionDto {

    private String empId;
    private String empName;
    private String birth;
    private String hqName;
    private String depName;
    private String jobName;
    private String authName;
    private String start;

    private String end;
    public PromotionDto(String empId, String empName, String birth, String hqName, String depName, String jobName, String authName) {
        this.empId = empId;
        this.empName = empName;
        this.birth = birth;
        this.hqName = hqName;
        this.depName = depName;
        this.jobName = jobName;
        this.authName = authName;
    }







}
