package com.choongang.eprproject.test;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestDto {
    String auth_code;
    String auth_name;
}
