package com.im.server.service;

import com.google.common.collect.Lists;
import com.im.server.common.Constants;
import com.im.server.mode.Response;
import com.im.server.utils.ScheduleTask;
import com.im.server.utils.UploadAsyTask;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

@Service
public class UploadFileService {

    @Autowired
    private PathGenerator fileNameGenerator;

    private final static Log logger = LogFactory.getLog(UploadFileService.class);

    public Response handleFileUpload(@RequestParam("pid") Long pid, @RequestParam("activityId") Long activityId, @RequestParam("file") MultipartFile file, @RequestParam("suffix") String suffix) {
        if (!file.isEmpty()) {
            String url = fileNameGenerator.generateHeadPath(pid, "." + suffix);
            return getResponse(ScheduleTask.submit(new UploadAsyTask(url, file)), url);
        }
        return Response.fail("请选择图片!!!");
    }

    /*
    Response返回失败的图片index,更新表
     */
    public Response batchFileUpload( @RequestParam("activityId") Long activityId,
                                    @RequestParam("files") List<MultipartFile> files) {
        //在指定的目录下生成activityId的目录
        //让前端限制上传的图片类型
        if (files != null && !files.isEmpty()) {
            File file = new File(fileNameGenerator.getActivityBasPath() + "/" + activityId);
            if (!file.exists()) {
                file.mkdir();
            }
        }

        ArrayList<Future<Boolean>> temResults = Lists.newArrayList();
        for (MultipartFile multipartFile : files) {
            Future<Boolean> result = ScheduleTask.submit(new UploadAsyTask(fileNameGenerator.generatActivityPath(activityId, fileNameGenerator.getPostfix(multipartFile)), multipartFile));
            temResults.add(result);
        }
        ArrayList<Integer> results = Lists.newArrayList();
        for (int i = 0; i < temResults.size(); i++) {
            Boolean result = getResult(temResults.get(i));
            if (Boolean.FALSE == result) {
                results.add(i);
            }
        }
        return new Response().setStatus(Constants.Status.SUCCESS).setData(results);
    }

    private Boolean getResult(Future<Boolean> result) {
        try {
            return result.get();
        } catch (Exception exp) {
        }
        return Boolean.FALSE;

    }

    private Response getResponse(Future<Boolean> result, String url) {
        try {
            if (result.get().equals(Boolean.TRUE)) {
                return new Response().setStatus(Constants.Status.SUCCESS).setData(url);
            }
            return new Response().setStatus(Constants.Status.ERROR).setData("上传图片失败");
        } catch (Exception exp) {
        }
        return new Response().setStatus(Constants.Status.ERROR).setData("上传图片失败");
    }


}