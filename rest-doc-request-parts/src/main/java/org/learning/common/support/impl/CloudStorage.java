package org.learning.common.support.impl;

import org.learning.common.support.FileUploader;
import org.springframework.stereotype.Component;

/**
 * Created by Lingfeng on 2016/5/27.
 */
@Component
public class CloudStorage implements FileUploader {

    @Override
    public String uploadFile(String fileName, byte[] data) {
        return null;
    }
}
