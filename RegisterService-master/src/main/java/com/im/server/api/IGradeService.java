package com.im.server.api;

import com.im.server.common.Constants;
import com.im.server.common.ServiceException;
import com.im.server.mode.IdentifyEntity;
import com.im.server.mode.Response;
import com.im.server.mode.paramter.RegTimeEntity;
import com.im.server.service.RegTimeMgtService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.im.server.utils.ParamerChecker.isNull;

/**
 * Created by majun on 16/3/5.
 */
@RestController
@RequestMapping("/mgt/service")
public class IGradeService {

    private Log logger = LogFactory.getLog(IGradeService.class);

//    @Autowired
//    private RegTimeMgtService regTimeMgtService;

//    @RequestMapping(path = "/create/regTime")
//    public Response createGradeEntity(@RequestBody RegTimeEntity regTimeEntity) {
//        //
//        logger.info(String.format("输入, university=%s", regTimeEntity));
//
//        if (isNull(regTimeEntity) || isNull(regTimeEntity.getPid()) || isNull(regTimeEntity.getEndAt())
//                || isNull(regTimeEntity.getStartAt())) {
//            logger.warn(String.format("入参检验失败, 缺失关键参数, regTime=%s", regTimeEntity));
//            return Constants.ErrorResponse.miss_param_error;
//        }
//
//        try {
//            regTimeMgtService.createRegTimeEntity(regTimeEntity);
//        } catch (ServiceException e) {
//            logger.error("创建university entity失败");
//            return Constants.ErrorResponse.access_db_error;
//        }
//        return Response.success(null);
//    }
//
//
//    @RequestMapping(path = "/get/regTime/")
//    public Response getRegTimeEntity(@RequestBody IdentifyEntity identifyEntity) {
//        logger.info(String.format("获取RegTimeEntity, IdenfiyEntity=%s", identifyEntity));
//
//        if (isNull(identifyEntity) || isNull(identifyEntity.getIdentify())
//                || isNull(identifyEntity.getPid())) {
//            logger.warn(String.format("入参检验失败, 缺失关键参数, identifyEntity=%s", identifyEntity));
//            return Constants.ErrorResponse.miss_param_error;
//        }
//        try {
//            RegTimeEntity regTimeEntity = regTimeMgtService.getRegTimeEntity(identifyEntity.getPid(), identifyEntity.getIdentify());
//            return Response.success(regTimeEntity);
//        } catch (ServiceException e) {
//            logger.error("获取RegTime entity失败");
//            return Constants.ErrorResponse.access_db_error;
//        }
//    }

}
