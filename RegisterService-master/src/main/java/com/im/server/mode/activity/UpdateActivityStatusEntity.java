package com.im.server.mode.activity;

/**
 * Created by majun on 16/4/21.
 */
public class UpdateActivityStatusEntity {
    private Long activityId;
    private Long pid;
    private Integer status;

    public Long getActivityId() {
        return activityId;
    }

    public UpdateActivityStatusEntity setActivityId(Long activityId) {
        this.activityId = activityId;
        return this;
    }

    public Long getPid() {
        return pid;
    }

    public UpdateActivityStatusEntity setPid(Long pid) {
        this.pid = pid;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public UpdateActivityStatusEntity setStatus(Integer status) {
        this.status = status;
        return this;
    }

    @Override
    public String toString() {
        return "UpdateActivityStatusEntity{" +
                "activityId=" + activityId +
                ", pid=" + pid +
                ", status=" + status +
                '}';
    }
}
