package com.sbs.tutorial.app1.domain.fileUpload.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Controller
@RequiredArgsConstructor
@RequestMapping("/upload")
public class FileUploadController {
    @RequestMapping("")
    @ResponseBody
    public String upload(@RequestParam("img1")MultipartFile file){
        String uploadDir = "C:/spring-temp/uploadImg";
        String fileName = "1.png";

        File directory = new File(uploadDir);

        if(!directory.exists()){
            directory.mkdirs();
        }

        File saveFile = new File(uploadDir, fileName);

        try {
            file.transferTo(saveFile);
            return "파일 업로드 성공 : " + saveFile.getAbsolutePath();
        } catch (Exception e) {
            e.printStackTrace();
            return "파일 업로드 실패 : " + e.getMessage();
        }
    }
}
