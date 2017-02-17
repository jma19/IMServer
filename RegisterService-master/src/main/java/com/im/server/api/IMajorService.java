package com.im.server.api;

import com.im.server.common.Constants;
import com.im.server.common.ServiceException;
import com.im.server.mode.Response;
import com.im.server.mode.db.Major;
import com.im.server.service.MajorMgtService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static com.im.server.common.Constants.Status.SUCCESS;
import static com.im.server.utils.ParamerChecker.isNull;

/**
 * Created by majun on 16/3/3.
 */
@RestController
@RequestMapping("/mgt/service")
public class IMajorService {

    private Log logger = LogFactory.getLog(ILogInService.class);

    @Autowired
    private MajorMgtService majorMgtService;

    @RequestMapping(path = "/create/major")
    public Response createMajorEntity(@RequestBody Major major) {

        logger.info(String.format("录入专业信息, major=%s", major));

        if (isNull(major) || isNull(major.getName())) {
            logger.warn(String.format("入参检验失败, 缺失关键参数, major=%s", major));
            return Constants.ErrorResponse.miss_param_error;
        }

        try {
            majorMgtService.createMajorEntity(major);
        } catch (ServiceException e) {
            logger.error("创建major entity失败");
            return Constants.ErrorResponse.access_db_error;
        }

        return Response.success(null);
    }

    @RequestMapping(path = "/get/major/all")
    public Response getMajorEntities() {

        logger.info(String.format("获取所有学院名称"));

        try {
            List<Major> majorEntities = majorMgtService.getMajorEntities();

            return majorEntities == null || majorEntities.isEmpty() ?
                    Response.success(new ArrayList<>()) :
                    Response.success(majorEntities);
        } catch (ServiceException e) {
            return Constants.ErrorResponse.access_db_error;
        }
    }


}
