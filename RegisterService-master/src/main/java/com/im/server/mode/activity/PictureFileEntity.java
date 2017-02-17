package com.im.server.mode.activity;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by majun on 16/2/13.
 */
public class PictureFileEntity {

    private List<MultipartFile> multipartFiles;
    private List<String> suffixs;

    public List<MultipartFile> getMultipartFiles() {
        return multipartFiles;
    }

    public PictureFileEntity setMultipartFiles(List<MultipartFile> multipartFiles) {
        this.multipartFiles = multipartFiles;
        return this;
    }

    public List<String> getSuffixs() {
        return suffixs;
    }

    public PictureFileEntity setSuffixs(List<String> suffixs) {
        this.suffixs = suffixs;
        return this;
    }


    @Override
    public String toString() {
        return "PictureFileEntity{" +
                "multipartFiles=" + multipartFiles +
                ", suffixs=" + suffixs +
                '}';
    }
}
