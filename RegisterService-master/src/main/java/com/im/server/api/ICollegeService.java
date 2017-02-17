package com.im.server.api;

import com.im.server.common.Constants;
import com.im.server.common.ServiceException;
import com.im.server.mode.Response;
import com.im.server.mode.db.College;
import com.im.server.service.CollegeMgtService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.im.server.common.Constants.Status.SUCCESS;
import static com.im.server.utils.ParamerChecker.isNull;

/**
 * Created by majun on 16/3/3.
 */
@RestController
@RequestMapping("/mgt/service")
public class ICollegeService {

    private Log logger = LogFactory.getLog(ILogInService.class);

    @Autowired
    private CollegeMgtService collegeMgtService;

    @RequestMapping(path = "/create/college")
    public Response createCollegeEntity(@RequestBody College college) {

        logger.info(String.format("录入学院信息, college=%s", college));

        if (isNull(college) || isNull(college.getCollegeName()) || isNull(college.getUnivId())
                || isNull(college.getUnivName())) {
            logger.warn(String.format("入参检验失败, 缺失关键参数, college=%s", college));
            return Constants.ErrorResponse.miss_param_error;
        }

        try {
            collegeMgtService.createCollegeEntity(college);
        } catch (ServiceException e) {
            logger.error("创建university entity失败");
            return Constants.ErrorResponse.access_db_error;
        }
        return Response.success(null);
    }

    @RequestMapping(path = "/get/College/{univName}")
    public Response getCollegeEntity(@PathVariable(value = "univName") String univName) {

        logger.info(String.format("获取所有学院名称, univName=%s", univName));

        if (isNull(univName)) {
            logger.warn(String.format("入参检验失败, 缺失关键参数, name=%s", univName));
            return Constants.ErrorResponse.miss_param_error;
        }

        try {
            List<College> collegeEntities = collegeMgtService.getCollegeEntities(univName);
            logger.info("-------" + collegeEntities);
            return collegeEntities == null || collegeEntities.isEmpty() ?
                    Response.success(null) :
                    Response.success(collegeEntities);
        } catch (ServiceException e) {
            return Constants.ErrorResponse.access_db_error;
        }
    }


}
