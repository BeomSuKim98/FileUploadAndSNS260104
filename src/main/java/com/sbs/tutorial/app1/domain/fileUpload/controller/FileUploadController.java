package com.sbs.tutorial.app1.domain.fileUpload.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
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
    @Value("${custom.genFileDirPath}")
    private String genFileDirPath;
    @RequestMapping("")
    @ResponseBody
    public String upload(@RequestParam("img1")MultipartFile img1, @RequestParam("img2")MultipartFile img2){
        File directory = new File(genFileDirPath);

        if(!directory.exists()){
            directory.mkdirs();
        }

        try {
            img1.transferTo(new File(directory, "1.png"));
            img2.transferTo(new File(directory, "2.png"));
            return "파일 업로드 성공";
        } catch (Exception e) {
            e.printStackTrace();
            return "파일 업로드 실패 : " + e.getMessage();
        }
    }
}
