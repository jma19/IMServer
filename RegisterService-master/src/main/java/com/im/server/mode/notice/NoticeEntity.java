package com.im.server.mode.notice;

import com.im.server.mode.paramter.Sender;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by majun on 16/1/24.
 */
public class NoticeEntity {
    private Long noticeId;
    private String title;
    private String des;
    private Sender sender;
    private Timestamp createdAt;
    private Integer isRead;//

    public Integer getIsRead() {
        return isRead;
    }

    public NoticeEntity setIsRead(Integer isRead) {
        this.isRead = isRead;
        return this;
    }

    public Long getNoticeId() {
        return noticeId;
    }

    public NoticeEntity setNoticeId(Long noticeId) {
        this.noticeId = noticeId;
        return this;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public NoticeEntity setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public NoticeEntity setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDes() {
        return des;
    }

    public NoticeEntity setDes(String des) {
        this.des = des;
        return this;
    }

    public Sender getSender() {
        return sender;
    }

    public NoticeEntity setSender(Sender sender) {
        this.sender = sender;
        return this;
    }

    @Override
    public String toString() {
        return "NoticeEntity{" +
                "createdAt=" + createdAt +
                ", noticeId=" + noticeId +
                ", title='" + title + '\'' +
                ", des='" + des + '\'' +
                ", sender=" + sender +
                ", isRead=" + isRead +
                '}';
    }
}
