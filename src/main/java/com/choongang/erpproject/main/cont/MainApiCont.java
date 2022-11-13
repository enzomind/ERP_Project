package com.choongang.erpproject.main.cont;

import com.choongang.erpproject.main.dto.MainRequestDto;
import com.choongang.erpproject.main.dto.MainResponseDto;
import com.choongang.erpproject.main.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/main")
public class MainApiCont {

    private final MainService mainService;

    @GetMapping("/getHireDash")
    public int requestHireDash() {
        return mainService.getHireDash();
    }

    @GetMapping("/getEmpDash")
    public Long requestEmpDash() {
        return mainService.getEmpDash();
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/getExpreportDash")
    public int requestExpreportDash(Principal principal) {

        String empId = principal.getName();

        MainRequestDto params = new MainRequestDto();
        params.setEmpId(empId);

        return mainService.getExpreportDash(params);
    }

    @GetMapping("/getNoticeDash")
    public List<MainResponseDto> requestNoticeDash() {
        return mainService.getNoticeDash();
    }

    @GetMapping("/getBirthDash")
    public List<MainResponseDto> requestBirthDash() {
        return mainService.getBirthDash();
    }

}
