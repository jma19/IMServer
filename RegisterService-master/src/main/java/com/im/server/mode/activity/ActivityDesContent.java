package com.im.server.mode.activity;

import java.sql.Timestamp;
import java.util.List;
/**
 * Created by majun on 16/4/20.
 */
public class ActivityDesContent {
    private String title;
    private Long activityId;
    private String des;
    private String publisherName;
    private Integer publisherPid;
    private String publishRemark;
    private List<String> urls;
    private Timestamp startAt;
    private Timestamp endAt;
    private Timestamp createdAt;

    public Timestamp getEndAt() {
        return endAt;
    }

    public ActivityDesContent setEndAt(Timestamp endAt) {
        this.endAt = endAt;
        return this;
    }

    public Timestamp getStartAt() {
        return startAt;
    }

    public ActivityDesContent setStartAt(Timestamp startAt) {
        this.startAt = startAt;
        return this;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public ActivityDesContent setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public ActivityDesContent setPublisherName(String publisherName) {
        this.publisherName = publisherName;
        return this;
    }

    public Integer getPublisherPid() {
        return publisherPid;
    }

    public ActivityDesContent setPublisherPid(Integer publisherPid) {
        this.publisherPid = publisherPid;
        return this;
    }

    public String getPublishRemark() {
        return publishRemark;
    }

    public ActivityDesContent setPublishRemark(String publishRemark) {
        this.publishRemark = publishRemark;
        return this;
    }

    public List<String> getUrls() {
        return urls;
    }

    public ActivityDesContent setUrls(List<String> urls) {
        this.urls = urls;
        return this;
    }

    public Long getActivityId() {
        return activityId;
    }

    public ActivityDesContent setActivityId(Long activityId) {
        this.activityId = activityId;
        return this;
    }
    public String getDes() {
        return des;
    }

    public ActivityDesContent setDes(String des) {
        this.des = des;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ActivityDesContent setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public String toString() {
        return "ActivityDesContent{" +
                "activityId=" + activityId +
                ", title='" + title + '\'' +
                ", des='" + des + '\'' +
                ", publisherName='" + publisherName + '\'' +
                ", publisherPid=" + publisherPid +
                ", publishRemark='" + publishRemark + '\'' +
                ", urls=" + urls +
                ", startAt=" + startAt +
                ", endAt=" + endAt +
                ", createdAt=" + createdAt +
                '}';
    }
}
