package com.choongang.erpproject.main.cont;

import com.choongang.erpproject.main.dto.MainRequestDto;
import com.choongang.erpproject.main.dto.MainResponseDto;
import com.choongang.erpproject.main.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/main")
public class MainApiCont {

    private final MainService mainService;

    @GetMapping("/getHireDash/{month}")
    public int requestHireDash(@PathVariable final String month) {

        MainRequestDto params = new MainRequestDto();
        params.setMonth(Integer.parseInt(month));

        int result = mainService.getHireDash(params);

        return result;
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

        List<MainResponseDto> list = mainService.getNoticeDash();

        return list;
    }

    @GetMapping("/getBirthDash")
    public int requestBirthDash() {
        int count = mainService.getBirthDash();

        return count;
    }

}
