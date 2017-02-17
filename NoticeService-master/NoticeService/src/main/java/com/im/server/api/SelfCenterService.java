package com.im.server.api;

import com.im.server.common.Constants;
import com.im.server.mode.Response;
import com.im.server.service.PathGenerator;
import com.im.server.utils.ScheduleTask;
import com.im.server.utils.UploadAsyTask;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.concurrent.Future;

/**
 * Created by majun on 16/2/21.
 */
@RestController
@RequestMapping("/self/service")
public class SelfCenterService {

    private Log logger = LogFactory.getLog(SelfCenterService.class);

    @Autowired
    private PathGenerator fileNameGenerator;

    @RequestMapping(value = "/uploadHeadPic", method = RequestMethod.POST)
    public Response uploadHeadPic(@RequestParam("pid") Long pid, @RequestParam("type") Long identify, @RequestParam("file") MultipartFile file, @RequestParam("suffix") String suffix) {
        logger.info(String.format("上传头像, pid=%s", pid));
        if (!file.isEmpty()) {
            String url = fileNameGenerator.generateHeadPath(pid, "." + suffix);
            return getResponse(ScheduleTask.submit(new UploadAsyTask(url, file)), url, identify);
        }
        return new Response().setStatus(Constants.Status.ERROR).setData("请选择图片");
    }

    private Response getResponse(Future<Boolean> result, String url, Long type) {
        try {
            if (result.get().equals(Boolean.TRUE)) {
                //人员信息
                return new Response().setStatus(Constants.Status.SUCCESS).setData(url);
            }
            return new Response().setStatus(Constants.Status.ERROR).setData("上传图片失败");
        } catch (Exception exp) {
        }
        return new Response().setStatus(Constants.Status.ERROR).setData("上传图片失败");
    }

}
