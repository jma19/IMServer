package com.im.server.service;


import com.im.server.conf.PathConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

/**
 * Created by majun on 16/2/1.
 */
@Service
public class PathGenerator {

    @Autowired
    private PathConfig pathConfig;

    public String generateHeadPath(Long pid, String postfix) {
        return new StringBuilder().append(pathConfig.getHead()).append("/").append(pid).append(postfix).toString();
    }

    public String generatActivityPath(Long activityId, String postfix){
        return new StringBuilder()
                .append(pathConfig.getActivity()).append("/")
                .append(activityId).append("/")
                .append(getRandomName()).append(postfix).toString();
    }

    public String getPostfix(MultipartFile file) {
        String name = file.getName();
        int index = name.lastIndexOf(".");
        return name.substring(index);
    }

    public boolean isPic(File file) {
        String name = file.getName();
        return name.endsWith(".jpg") || name.endsWith(".png");
    }


    public String getActivityBasPath(){
        return pathConfig.getActivity();
    }
    
    private String getRandomName() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
