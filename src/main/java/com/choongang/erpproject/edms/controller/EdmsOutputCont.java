package com.choongang.erpproject.edms.controller;

import com.choongang.erpproject.edms.dto.EdmsRequestDto;
import com.choongang.erpproject.edms.dto.EdmsResponseDto;
import com.choongang.erpproject.edms.service.EdmsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class EdmsOutputCont {

    private final EdmsService edmsService;

    @GetMapping("/edmsoutput")
    public String edmsRoot(Model model, Principal principal) {

        EdmsRequestDto params = new EdmsRequestDto();

        params.setApprId(principal.getName());

        List<EdmsResponseDto> list = edmsService.findAll(params);
        model.addAttribute("edmsOutputList", list);

        return "/edms/edmsoutput";
    }

}
