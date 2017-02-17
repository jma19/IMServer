package com.im.server.dao;

import com.im.server.mode.activity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by majun on 16/2/8.
 */
public interface ActivityServiceDao {

    Long insertActivity(ActivityEntity activityEntity);

    void insertActivityPlan(ActivityPlanEntity activiyPlanEntity);

    void insertActivityPlans(List<ActivityPlanEntity> activityPlanEntities);

    void insertActivityPic(@Param("activityId") Long activityId, @Param("url") String url);

    void updateActivityStatus(UpdateActivityStatusEntity activityStatusEntity);

    List<ActivityDesContent> queryActivityDesList(@Param("pid") Long pid, @Param("fromRow") Integer fromRow);

    List<ActivityDesContent> queryAttendedActivityList(@Param("pid") Long pid, @Param("fromRow") Integer fromRow);

    /**
     * 获取个人今天要参加的活动列表
     *
     * @param pid
     * @return
     */
    List<ActivityDesContent> queryMyWillAttendedActivityList(@Param("pid") Long pid, @Param("today") String today);

    /**
     * 获取活动具体内容
     *
     * @param activityId
     * @return
     */
    ActivityContent queryActivity(Long activityId);


    /**
     * 获取活动相关联的图像链接列表
     *
     * @param activityId
     * @return
     */
    List<String> queryAtivityUrls(Long activityId);

    /**
     * 获取我发布的活动列表
     *
     * @param pid
     * @param fromRow
     * @return
     */
    List<ActivityDesContent> queryPublishedActivities(@Param("pid") Long pid, @Param("fromRow") Integer fromRow);

}
