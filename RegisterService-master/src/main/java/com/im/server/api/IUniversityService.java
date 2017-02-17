package com.im.server.api;

import com.im.server.common.Constants;
import com.im.server.common.ServiceException;
import com.im.server.mode.Response;
import com.im.server.mode.db.University;
import com.im.server.service.UnivMgtService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.im.server.common.Constants.Status.SUCCESS;
import static com.im.server.utils.ParamerChecker.isNull;

/**
 * Created by majun on 16/3/3.
 */
@RestController
@RequestMapping("/mgt/service")
public class IUniversityService {

    private Log logger = LogFactory.getLog(ILogInService.class);

    @Autowired
    private UnivMgtService univMgtService;

    @RequestMapping(path = "/create/university")
    public Response createUniversityEntity(@RequestBody University university) {

        logger.info(String.format("输入学校信息, university=%s", university));

        if (isNull(university) || isNull(university.getName()) || isNull(university.getCode())
                || isNull(university.getAddress())) {
            logger.warn(String.format("入参检验失败, 缺失关键参数, university=%s", university));
            return Constants.ErrorResponse.miss_param_error;
        }
        try {
            univMgtService.createUniversityEntity(university);
        } catch (ServiceException e) {
            logger.error("创建university entity失败");
            return Constants.ErrorResponse.access_db_error;
        }

        return new Response().setData(null).setStatus(SUCCESS);
    }

    @RequestMapping(path = "/get/university/{name}")
    public Response getUniversityEntity(@PathVariable(value = "name") String name) {

        logger.info(String.format("获取学校entity, name=%s", name));

        if (isNull(name)) {
            logger.warn(String.format("入参检验失败, 缺失关键参数, name=%s", name));
            return Constants.ErrorResponse.miss_param_error;
        }

        try {
            List<University> universities = univMgtService.getUniversityEntities(name);
            logger.info("-------" + universities);
            return universities == null || universities.isEmpty() ?
                    new Response().setData(null).setStatus(SUCCESS) :
                    new Response().setData(universities.get(0)).setStatus(SUCCESS);
        } catch (ServiceException e) {
            return Constants.ErrorResponse.access_db_error;
        }
    }

    //获取所有的学校信息
    @RequestMapping(path = "/get/university/all")
    public Response getAllUniversityEntities() {

        logger.info(String.format("获取all university entities"));

        try {
            List<University> universities = univMgtService.getUniversityEntities(null);
            logger.info("---------" + universities);
            return universities == null || universities.isEmpty() ?
                    new Response().setData(null).setStatus(SUCCESS) :
                    new Response().setData(universities).setStatus(SUCCESS);
        } catch (ServiceException e) {
            return Constants.ErrorResponse.access_db_error;
        }
    }
    //获取所有的学校信息
    @RequestMapping(path = "/update/university/")
    public Response updateUniversityEntity(University university) {

        logger.info(String.format("更新学校的信息"));
        try {
            List<University> universities = univMgtService.getUniversityEntities(null);
            logger.info("---------" + universities);
            return universities == null || universities.isEmpty() ?
                    new Response().setData(null).setStatus(SUCCESS) :
                    new Response().setData(universities).setStatus(SUCCESS);
        } catch (ServiceException e) {
            return Constants.ErrorResponse.access_db_error;
        }
    }



}
