package com.choongang.erpproject.info.controller;

import com.choongang.erpproject.info.dao.NoticeMapper;


import com.choongang.erpproject.info.dto.NoticeDto;
import com.choongang.erpproject.info.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/info/*")
public class InfoController {
    //    @Autowired
//    PromotionMapper promotionMapper;

    @Autowired
    private FileService fileService;
    @Autowired
    NoticeMapper noticeMapper;

    @Value("${spring.servlet.multipart.location}")
    String filePath;

    @RequestMapping("/info")
    private String GotoInfo(Model model) {
        List<NoticeDto> list = noticeMapper.selectNoticeList();
        model.addAttribute("info", list);
        return "/notice/information";
    }

    @GetMapping("/viewinfo")
    private String viewInfo(long ntcNum, Model model) {
        System.out.println(ntcNum);
        NoticeDto dto = fileService.read(ntcNum);
        model.addAttribute("view", dto);
        noticeMapper.updateViewCnt(ntcNum);
        return "/notice/viewNotice";
    }


    @RequestMapping("/writinginfo")
    private String WriteInfo() {
        return "/notice/writinginfo";
    }



    @PostMapping("/upload")
// 업로드하는 파일들을 MultipartFile 형태의 파라미터로 전달된다.
    public String upload(@RequestParam MultipartFile[] fileName, Model model, @RequestParam String title, @RequestParam String content)
            throws IllegalStateException, IOException {
        if(fileName == null || fileName.length == 0) {
            List<NoticeDto> list = noticeMapper.selectNoticeList();
            fileService.upload(fileName, title, content);
            model.addAttribute("info", list);

            return "redirect:/info/info";
        } else {
            noticeMapper.insertNoticeNoFile(title,content);
            List<NoticeDto> list = noticeMapper.selectNoticeList();
            model.addAttribute("info", list);
            return  "redirect:/info/info";
        }
    }


    @GetMapping("/download")
    public ResponseEntity<Resource> download(@ModelAttribute NoticeDto dto) throws IOException {
        return fileService.download(dto);
    }


    @RequestMapping("/searchnotice")
    @ResponseBody
    private List<NoticeDto> searchList(@RequestParam String start , @RequestParam String end, @RequestParam String title) {
        List<NoticeDto> noticeList = noticeMapper.searchnotice(start, end, title);
        return noticeList;
    }


    @RequestMapping("/deleteNotice")
    private String DeleteInfo(Model model, long ntcNum) {
        noticeMapper.deleteNotice(ntcNum);
        List<NoticeDto> list = noticeMapper.selectNoticeList();
        model.addAttribute("info", list);
        return "redirect:/info/info";
    }


    @GetMapping("/updateNotice")
    private String UpdateInfo(Model model, long ntcNum) {
        NoticeDto dto = fileService.read(ntcNum);
        model.addAttribute("view", dto);
        return "/notice/updateinfo";
    }

    @PostMapping("/update")
// 업로드하는 파일들을 MultipartFile 형태의 파라미터로 전달된다.
    public String update(long ntcNum, @RequestParam MultipartFile[] fileName, Model model, @RequestParam String title, @RequestParam String content)
            throws IllegalStateException, IOException {
        List<NoticeDto> list = noticeMapper.selectNoticeList();
        fileService.update(ntcNum, fileName, title, content);
        model.addAttribute("info", list);
        return "redirect:/info/info";
    }


}


