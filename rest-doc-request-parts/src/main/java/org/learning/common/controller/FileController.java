package org.learning.common.controller;

import org.learning.common.support.FileUploader;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

/**
 * Created by Lingfeng on 2016/5/18.
 */
@RestController
@RequestMapping("/api/files")
public class FileController {

    protected final Log log = LogFactory.getLog(this.getClass());

    @Autowired
    private FileUploader fileUploader;

    @RequestMapping(method = RequestMethod.POST)
    public String uploadFile(@RequestParam MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        String fileName = UUID.randomUUID() + originalFilename.substring(originalFilename.indexOf("."));

        try {
            return fileUploader.uploadFile(fileName, file.getBytes());
        } catch (IOException e) {
            log.error(e.getMessage());
        }

        return null;
    }
}
