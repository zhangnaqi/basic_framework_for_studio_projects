package com.znq.basecode.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FileGlobalConfig {

    @Value("${myProject.hostUrl}")
    public String hostUrl;

    @Value("${myProject.file-path}")
    public String globalFilePath;

}
