package com.choongang.erpproject.info.service;


import com.choongang.erpproject.info.dao.NoticeMapper;
import com.choongang.erpproject.info.dto.FileDto;
import com.choongang.erpproject.info.dto.NoticeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Service
public class FileService {

    @Autowired
    NoticeMapper noticeMapper;
    @Value("${spring.servlet.multipart.location}")
    String filePath;

    public NoticeDto read(long ntcNum) {
        NoticeDto list = noticeMapper.selectNotice(ntcNum);
        return list;
    }

    public List<FileDto> upload(MultipartFile[] fileName, String title, String content) throws IllegalStateException, IOException {
        List<FileDto> list = new ArrayList<>();
        for (MultipartFile file : fileName) {
            if (!file.isEmpty()) {
                // UUID를 이용해 unique한 파일 이름을 만들어준다.
                FileDto dto = new FileDto(UUID.randomUUID().toString(),
                        file.getOriginalFilename(),
                        file.getContentType());
                list.add(dto);

                if (!new File(filePath).exists()) {
                    try {
                        new File(filePath).mkdir();
                    } catch (Exception e) {
                        e.getStackTrace();
                    }
                }

                System.out.println(list);
                File newFileName = new File(dto.getUuid() + "_" + dto.getFileName());
                // 전달된 내용을 실제 물리적인 파일로 저장해준다.
                file.transferTo(newFileName);

                System.out.println("file : ===========" + filePath + newFileName);
                noticeMapper.insertNotice(title, content, dto.getUuid(),dto.getFileName() );
            }

        }

        return list;
    }

    public ResponseEntity<Resource> download(NoticeDto dto) throws IOException {
        Path path = Paths.get(filePath + "/" + dto.getFileName());
        System.out.println(path);
        String contentType = Files.probeContentType(path);
        // header를 통해서 다운로드 되는 파일의 정보를 설정한다.


        HttpHeaders headers = new HttpHeaders();
        headers.setContentDisposition(ContentDisposition.builder("attachment")
                .filename(dto.getFileName(), StandardCharsets.UTF_8)
                .build());
        headers.add(HttpHeaders.CONTENT_TYPE, contentType);


        Resource resource = new InputStreamResource(Files.newInputStream(path));

        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
    }

}