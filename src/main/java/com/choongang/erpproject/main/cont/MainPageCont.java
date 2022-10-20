package com.choongang.erpproject.main.cont;

import com.choongang.erpproject.main.service.MainService;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/main")
@RequiredArgsConstructor
public class MainPageCont {

    private final MainService mainService;

    @GetMapping("/")
    public String mainRoot() {
        return "/main";
    }

    @RequestMapping(value = "/getCalAll", method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String, Object>> getCalAll() {
        List<Map<String, Object>> list = mainService.getCalAll();

        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        HashMap<String, Object> hash = new HashMap<String, Object>();

        for(int i=0; i<list.size(); i++) {
            hash.put("title", list.get(i).get("emp_name"));
            hash.put("start", list.get(i).get("start_date"));
            hash.put("end", list.get(i).get("end_date"));

            jsonObject = new JSONObject(hash); //중괄호 {key:value, key:value, key:value}
            jsonArray.add(jsonObject); //대괄호 안에 넣어주기 [{key:value, key:value, key:value}]
        }

        return jsonArray;
    }
}
