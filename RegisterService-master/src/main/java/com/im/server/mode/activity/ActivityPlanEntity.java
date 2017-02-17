package com.im.server.mode.activity;

import java.sql.Timestamp;
/**
 * Created by majun on 16/2/8.
 */
public class ActivityPlanEntity {
    private Long activityId;
    private Long publisherPid;
    private String publisherName;
    private String publisherRemark;
    private Long recvPid;
    private String title;
    private String des;//content的一部分
    private String url;
    private Integer status;

    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Long getActivityId() {
        return activityId;
    }

    public ActivityPlanEntity setActivityId(Long activityId) {
        this.activityId = activityId;
        return this;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public ActivityPlanEntity setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getDes() {
        return des;
    }

    public ActivityPlanEntity setDes(String des) {
        this.des = des;
        return this;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public ActivityPlanEntity setPublisherName(String publisherName) {
        this.publisherName = publisherName;
        return this;
    }

    public Long getPublisherPid() {
        return publisherPid;
    }

    public ActivityPlanEntity setPublisherPid(Long publisherPid) {
        this.publisherPid = publisherPid;
        return this;
    }

    public String getPublisherRemark() {
        return publisherRemark;
    }

    public ActivityPlanEntity setPublisherRemark(String publisherRemark) {
        this.publisherRemark = publisherRemark;
        return this;
    }

    public Long getRecvPid() {
        return recvPid;
    }

    public ActivityPlanEntity setRecvPid(Long recvPid) {
        this.recvPid = recvPid;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public ActivityPlanEntity setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ActivityPlanEntity setTitle(String title) {
        this.title = title;
        return this;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public ActivityPlanEntity setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public ActivityPlanEntity setUrl(String url) {
        this.url = url;
        return this;
    }

    @Override
    public String toString() {
        return "ActivityPlanEntity{" +
                "activityId=" + activityId +
                ", publisherPid=" + publisherPid +
                ", publisherName='" + publisherName + '\'' +
                ", publisherRemark='" + publisherRemark + '\'' +
                ", recvPid=" + recvPid +
                ", title='" + title + '\'' +
                ", des='" + des + '\'' +
                ", url='" + url + '\'' +
                ", status=" + status +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
