package com.im.server.mode.activity;

import java.sql.Timestamp;
import java.util.List;
/**
 * Created by majun on 16/4/20.
 */
public class ActivityContent {
    private Long activityId;
    private String title;
    private String des;
    private Integer publisherType;
    private String publisherName;
    private String publisherRemark;
    private Long publisherPid;
    private String location;
    private String content;
    private Integer numberOfInterest;
    private Timestamp start;
    private Timestamp end;
    private List<String> urls;
    private List<AttendentEntity> attendentEntityList;

    public String getContent() {
        return content;
    }

    public ActivityContent setContent(String content) {
        this.content = content;
        return this;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public Integer getPublisherType() {
        return publisherType;
    }

    public ActivityContent setPublisherType(Integer publisherType) {
        this.publisherType = publisherType;
        return this;
    }

    public ActivityContent setPublisherName(String publisherName) {
        this.publisherName = publisherName;
        return this;
    }

    public Long getPublisherPid() {
        return publisherPid;
    }

    public ActivityContent setPublisherPid(Long publisherPid) {
        this.publisherPid = publisherPid;
        return this;
    }

    public String getPublisherRemark() {
        return publisherRemark;
    }

    public ActivityContent setPublisherRemark(String publisherRemark) {
        this.publisherRemark = publisherRemark;
        return this;
    }

    public Timestamp getEnd() {
        return end;
    }

    public ActivityContent setEnd(Timestamp end) {
        this.end = end;
        return this;
    }

    public Timestamp getStart() {
        return start;
    }

    public ActivityContent setStart(Timestamp start) {
        this.start = start;
        return this;
    }

    public Long getActivityId() {
        return activityId;
    }


    public List<String> getUrls() {
        return urls;
    }

    public ActivityContent setUrls(List<String> urls) {
        this.urls = urls;
        return this;
    }

    public ActivityContent setActivityId(Long activityId) {
        this.activityId = activityId;
        return this;
    }

    public List<AttendentEntity> getAttendentEntityList() {
        return attendentEntityList;
    }

    public ActivityContent setAttendentEntityList(List<AttendentEntity> attendentEntityList) {
        this.attendentEntityList = attendentEntityList;
        return this;
    }

    public String getDes() {
        return des;
    }

    public ActivityContent setDes(String des) {
        this.des = des;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public ActivityContent setLocation(String location) {
        this.location = location;
        return this;
    }

    public Integer getNumberOfInterest() {
        return numberOfInterest;
    }

    public ActivityContent setNumberOfInterest(Integer numberOfInterest) {
        this.numberOfInterest = numberOfInterest;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ActivityContent setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public String toString() {
        return "ActivityContent{" +
                "activityId=" + activityId +
                ", title='" + title + '\'' +
                ", des='" + des + '\'' +
                ", location='" + location + '\'' +
                ", numberOfInterest=" + numberOfInterest +
                ", urls=" + urls +
                ", attendentEntityList=" + attendentEntityList +
                '}';
    }
}
