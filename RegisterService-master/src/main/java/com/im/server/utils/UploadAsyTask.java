package com.im.server.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.concurrent.Callable;

/**
 * Created by majun on 16/2/1.
 */
public class UploadAsyTask implements Callable {

    private final static Log logger = LogFactory.getLog(UploadAsyTask.class);

    private String name;
    private MultipartFile file;

    public UploadAsyTask(String name, MultipartFile file) {
        this.file = file;
        this.name = name;
    }

    @Override
    public Boolean call() throws Exception {
        try {
            byte[] bytes = file.getBytes();
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(name)));
            stream.write(bytes);
            stream.close();
            return Boolean.TRUE;
        } catch (Exception exp) {
            logger.error(String.format("上传图片失败,fileName={}", name), exp);
        }
        return Boolean.FALSE;
    }
}
