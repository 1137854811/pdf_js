package com.example.springsecurity.controller;

import com.example.springsecurity.utils.ExportFileUtil;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author: Tz
 * @date: 2020/9/2 17:17
 */
@RestController
public class hello {
    @PostMapping("/user")
    public User hello(@RequestBody User user) {
        System.err.println("userID"+user);
        return user;
    }


    /**
     * pdf 预览公共
     *
     * @param response
     * @param fileUrl
     */
    @GetMapping("/readPdfFile")
    public void previewPdf(HttpServletResponse response , String fileUrl){
        ExportFileUtil.preview(response, fileUrl);
    }
}
