package com.jc.controller;

import com.jc.util.ResultMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {

    @RequestMapping("/upload")
    @ResponseBody
    public ResultMap upload(MultipartFile file){
        try {
            file.transferTo(new File("F:\\JC\\img\\"+file.getOriginalFilename()));
        } catch (IOException e) {
            return ResultMap.fail(null);
        }
        return ResultMap.ok(null);
    }
}
