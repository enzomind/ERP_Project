package com.choongang.erpproject;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class empSignConfig implements WebMvcConfigurer {
    private String myPrjPath = "/Users/seonghuchoi/Downloads/intelliJFolder/erp_Project/";
    // private String myPrjPath = "C:\\Users\\user\\erp_Project\\";

    //업로드 이미지 접근 시 로컬 권한 문제 해결 Config
    private String RequestPath = myPrjPath + "resources/upload/**";
    private String ResponsePath = "file://"+ myPrjPath +"resources/upload/";

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(RequestPath)
                .addResourceLocations(ResponsePath);
    }
}
