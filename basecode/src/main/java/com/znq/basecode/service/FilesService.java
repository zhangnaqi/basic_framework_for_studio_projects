package com.znq.basecode.service;

import org.springframework.web.multipart.MultipartFile;

public interface FilesService {

    String upload(MultipartFile file);

}
