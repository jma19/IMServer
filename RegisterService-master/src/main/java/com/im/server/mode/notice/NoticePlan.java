package com.im.server.mode.notice;

import java.util.Date;

/**
 * Created by majun on 16/1/21.
 */
public class NoticePlan {

    private Long id;
    private Long noticeId;
    private String title;
    private String des;
    private Long senderPid;
    private String senderName;
    private Integer senderIdentify;
    private Long recvPid;
    private String recvName;
    private Integer recvIdentify;
    private Integer isRead;
    private Date createdAt;
    private Date updatedAt;

    public Integer getRecvIdentify() {
        return recvIdentify;
    }

    public NoticePlan setRecvIdentify(Integer recvIdentify) {
        this.recvIdentify = recvIdentify;
        return this;
    }

    public Integer getSenderIdentify() {
        return senderIdentify;
    }

    public NoticePlan setSenderIdentify(Integer senderIdentify) {
        this.senderIdentify = senderIdentify;
        return this;
    }

    public Long getId() {
        return id;
    }

    public NoticePlan setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getNoticeId() {
        return noticeId;
    }

    public NoticePlan setNoticeId(Long noticeId) {
        this.noticeId = noticeId;
        return this;
    }

    public Long getSenderPid() {
        return senderPid;
    }

    public NoticePlan setSenderPid(Long senderPid) {
        this.senderPid = senderPid;
        return this;
    }

    public String getSenderName() {
        return senderName;
    }

    public NoticePlan setSenderName(String senderName) {
        this.senderName = senderName;
        return this;
    }

    public Long getRecvPid() {
        return recvPid;
    }

    public NoticePlan setRecvPid(Long recvPid) {
        this.recvPid = recvPid;
        return this;
    }

    public String getRecvName() {
        return recvName;
    }

    public NoticePlan setRecvName(String recvName) {
        this.recvName = recvName;
        return this;
    }

    public Integer getIsRead() {
        return isRead;
    }

    public NoticePlan setIsRead(Integer isRead) {
        this.isRead = isRead;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public NoticePlan setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public NoticePlan setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public NoticePlan setTitle(String title) {
        this.title = title;
        return this;
    }


    public String getDes() {
        return des;
    }

    public NoticePlan setDes(String des) {
        this.des = des;
        return this;
    }

    @Override
    public String toString() {
        return "NoticePlan{" +
                "id=" + id +
                ", noticeId=" + noticeId +
                ", title='" + title + '\'' +
                ", des='" + des + '\'' +
                ", senderPid=" + senderPid +
                ", senderName='" + senderName + '\'' +
                ", recvPid=" + recvPid +
                ", recvName='" + recvName + '\'' +
                ", isRead=" + isRead +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
