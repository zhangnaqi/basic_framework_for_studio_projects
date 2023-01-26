package com.znq.basecode.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.znq.basecode.service.FilesService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Api(tags = "文件上传模块")
@RestController
@RequestMapping("/api/file")
@Slf4j
public class FileController {

    @Resource
    private FilesService filesService;

    @ApiOperation("文件上传")
    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        log.info("文件上传");
        return filesService.upload(file);
    }

}