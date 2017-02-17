package com.im.server.dao;

import com.im.server.mode.activity.ActivityEntity;
import com.im.server.mode.activity.ActivityPlanEntity;
import org.apache.ibatis.annotations.Param;
import java.util.List;
/**
 * Created by majun on 16/2/8.
 */
public interface ActivityDao {

    Long insertActivity(ActivityEntity activityEntity);

    void insertActivityPlan(ActivityPlanEntity activiyPlanEntity);

    void insertActivityPlans(List<ActivityPlanEntity> activityPlanEntities);

    void insertActivityPic(@Param("activityId") Long activityId, @Param("url") String url);

}
