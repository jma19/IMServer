package com.im.server.service;

import com.im.server.common.ExceptionConstants;
import com.im.server.common.ServiceException;
import com.im.server.dao.ActivityServiceDao;
import com.im.server.mode.activity.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by majun on 16/2/9.
 */
@Service
public class ActivityMgtService {

    private final static Log logger = LogFactory.getLog(ActivityMgtService.class);

    @Autowired
    private ActivityServiceDao activityDao;

    public Long createActiviy(ActivityEntity activityEntity) throws ServiceException {
        logger.info(String.format("创建activity, activityEntity=%s", activityEntity));
        try {
            return activityDao.insertActivity(activityEntity);
        } catch (Exception exp) {
            logger.error("数据库异常,创建activity失败", exp);
            throw ExceptionConstants.ACCEESS_DB_EXCEPTION;
        }
    }

    public void createActiviyPlans(List<ActivityPlanEntity> activityPlanEntities) throws ServiceException {
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

    public List<ActivityDesContent> getActivities(Long pid, Integer fromRow) throws ServiceException {
        //activity_plan_
        logger.info(String.format("获取活动列表, pid=%s, fromRow=%s", pid, fromRow));
        try {
            return activityDao.queryActivityDesList(pid, fromRow);
        } catch (Exception exp) {
            logger.error("数据库异常,获取活动列表失败", exp);
            throw ExceptionConstants.ACCEESS_DB_EXCEPTION;
        }
    }

    public List<ActivityDesContent> getAttendedActivityList(Long pid, Integer fromRow) throws ServiceException {
        //activity_plan_
        logger.info(String.format("获取已参加的活动列表, pid=%s, fromRow=%s", pid, fromRow));
        try {
            return activityDao.queryAttendedActivityList(pid, fromRow);
        } catch (Exception exp) {
            logger.error("数据库异常,获取已参加的活动列表失败", exp);
            throw ExceptionConstants.ACCEESS_DB_EXCEPTION;
        }
    }

    public ActivityContent getActivityContent(Long activityId) throws ServiceException {
        //activity_plan_
        logger.info(String.format("获取活动详情, activityId=%s", activityId));
        try {
            return activityDao.queryActivity(activityId);
        } catch (Exception exp) {
            logger.error("数据库异常,获取活动详情失败!!!", exp);
            throw ExceptionConstants.ACCEESS_DB_EXCEPTION;
        }
    }

    public void updateActivityStatus(UpdateActivityStatusEntity updateActivityStatusEntity) throws ServiceException {

        try {
            activityDao.updateActivityStatus(updateActivityStatusEntity);
        } catch (Exception exp) {
            logger.error("数据库异常,更新活动状态失败!!!", exp);
            throw ExceptionConstants.ACCEESS_DB_EXCEPTION;
        }
    }

    public List<ActivityDesContent> getPublishedActivities(Long pid, Integer fromRow) throws ServiceException {
        //activity_plan_
        logger.info(String.format("获取已参加的活动列表, pid=%s, fromRow=%s", pid, fromRow));
        try {
            return activityDao.queryPublishedActivities(pid, fromRow);
        } catch (Exception exp) {
            logger.error("数据库异常,获取已参加的活动列表失败", exp);
            throw ExceptionConstants.ACCEESS_DB_EXCEPTION;
        }
    }

}
