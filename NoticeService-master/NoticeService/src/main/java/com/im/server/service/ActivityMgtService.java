package com.im.server.service;

import java.util.List;
import com.im.server.common.ExceptionConstants;
import com.im.server.common.ServiceException;
import com.im.server.dao.ActivityDao;
import com.im.server.mode.activity.ActivityEntity;
import com.im.server.mode.activity.ActivityPlanEntity;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by majun on 16/2/9.
 */
@Service
public class ActivityMgtService {

    private final static Log logger = LogFactory.getLog(ActivityMgtService.class);

    @Autowired
    private ActivityDao activityDao;

    public Long createActiviy(ActivityEntity activityEntity) throws ServiceException {
        logger.info(String.format("创建activity, activityEntity=%s", activityEntity));
        try {
            return activityDao.insertActivity(activityEntity);
        } catch (Exception exp) {
            logger.error("数据库异常,创建activity失败", exp);
            throw ExceptionConstants.ACCEESS_DB_EXCEPTION;
        }
    }

    public void createActiviyPlan(ActivityPlanEntity activityPlanEntity) throws ServiceException {
        logger.info(String.format("创建activity plan, activityPlanEntity=%s", activityPlanEntity));
        try {
            activityDao.insertActivityPlan(activityPlanEntity);
        } catch (Exception exp) {
            logger.error("数据库异常,创建activity plan失败", exp);
            throw ExceptionConstants.ACCEESS_DB_EXCEPTION;
        }
    }

    public void createActiviyPlans(List<ActivityPlanEntity> activityPlanEntities ) throws ServiceException {
        logger.info(String.format("创建activity plans, activityPlanEntities=%s", activityPlanEntities));
        try {

//            activityDao.insertActivityPlan(activityPlanEntities);
        } catch (Exception exp) {
            logger.error("数据库异常,创建activity plan失败", exp);
            throw ExceptionConstants.ACCEESS_DB_EXCEPTION;
        }
    }

    public void createActiviyPic(Long activityId, String url) throws ServiceException {
        logger.info(String.format("创建activity pic, activity=%s, url", activityId, url));
        try {
            activityDao.insertActivityPic(activityId, url);
        } catch (Exception exp) {
            logger.error("数据库异常,创建activity pic失败", exp);
            throw ExceptionConstants.ACCEESS_DB_EXCEPTION;
        }
    }


}
