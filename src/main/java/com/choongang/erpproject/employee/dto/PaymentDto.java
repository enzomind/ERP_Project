package com.choongang.erpproject.employee.dto;

import lombok.Data;

@Data
public class PaymentDto {
    String empId;
    int wage;
    String empName;
    String jobName;
    String hqName;
    String depName;
    String serialNo;
    int tax;
    int MealExp;
    int trnExp;
    int welExp;
    String paymdate;
    String birth;


}
