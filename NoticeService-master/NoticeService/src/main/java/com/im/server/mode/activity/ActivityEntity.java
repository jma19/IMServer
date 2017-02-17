package com.im.server.mode.activity;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

/**
 * Created by majun on 16/2/6.
 */
public class ActivityEntity {
    private Long id;
    private Integer level;
    private String title;
    private String des;
    private String location;
    private Long publisherPid;
    private String publisherName;
    private String publisherRemark;
    private String startTime;
    private String endTime;
    private List<MultipartFile> multipartFiles;
    private Date createdAt;
    private Date updatedAt;

    public Integer getLevel() {
        return level;
    }

    public ActivityEntity setLevel(Integer level) {
        this.level = level;
        return this;
    }

    public List<MultipartFile> getMultipartFiles() {
        return multipartFiles;
    }

    public ActivityEntity setMultipartFiles(List<MultipartFile> multipartFiles) {
        this.multipartFiles = multipartFiles;
        return this;
    }

    public Long getId() {
        return id;
    }

    public ActivityEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDes() {
        return des;
    }

    public ActivityEntity setDes(String des) {
        this.des = des;
        return this;

    }

    public String getEndTime() {
        return endTime;
    }

    public ActivityEntity setEndTime(String endTime) {
        this.endTime = endTime;
        return this;

    }

    public String getLocation() {
        return location;
    }

    public ActivityEntity setLocation(String location) {
        this.location = location;
        return this;

    }

    public Long getPublisherPid() {
        return publisherPid;
    }

    public ActivityEntity setPublisherPid(Long publisherPid) {
        this.publisherPid = publisherPid;
        return this;

    }

    public String getPublisherName() {
        return publisherName;
    }

    public ActivityEntity setPublisherName(String publisherName) {
        this.publisherName = publisherName;
        return this;

    }


    public String getPublisherRemark() {
        return publisherRemark;
    }

    public ActivityEntity setPublisherRemark(String publisherRemark) {
        this.publisherRemark = publisherRemark;
        return this;
    }


    public String getStartTime() {
        return startTime;
    }

    public ActivityEntity setStartTime(String startTime) {
        this.startTime = startTime;
        return this;

    }

    public String getTitle() {
        return title;
    }

    public ActivityEntity setTitle(String title) {
        this.title = title;
        return this;

    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public ActivityEntity setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;

    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public ActivityEntity setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
        return this;

    }

    @Override
    public String toString() {
        return "ActivityEntity{" +
                "id=" + id +
                ", level=" + level +
                ", title='" + title + '\'' +
                ", des='" + des + '\'' +
                ", location='" + location + '\'' +
                ", publisherPid=" + publisherPid +
                ", publisherName='" + publisherName + '\'' +
                ", publisherRemark='" + publisherRemark + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", multipartFiles=" + multipartFiles +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
