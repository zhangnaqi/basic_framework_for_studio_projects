package com.znq.basecode.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.znq.basecode.config.FileGlobalConfig;
import com.znq.basecode.service.FilesService;

import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Service
@Slf4j
public class FilesServiceImpl implements FilesService {

    @Resource
    private FileGlobalConfig fileGlobalConfig;

    @Override
    public String upload(MultipartFile file) {

        log.info("文件开始上传。。。");
        try {
            // 文件是否为空
            if (file.isEmpty())
                throw new RuntimeException("文件为空");
            // 获取文件名
            String filename = file.getOriginalFilename();
            // 获取文件名后缀
            String suffixName = filename.substring(filename.lastIndexOf("."));
            // 文件的新名字
            String savefileName = UUID.randomUUID().toString() + suffixName;
            // 文件存储路径
            String fileNameNew = fileGlobalConfig.hostUrl +
                    "/upload/school/news/" + savefileName;
            String dir = fileGlobalConfig.globalFilePath;
            // 构建路径

            File dest = new File(dir);
            // 判断路径是否存在
            if (!dest.exists())
                dest.mkdirs();
            // 文件写入
            file.transferTo(new File(dir + savefileName));
            // 返回
            return fileNameNew;
        } catch (IOException e) {
            log.info("上传文件失败 ===》{}", e.toString());
            throw new RuntimeException("上传文件失败");
        }

    }
}
