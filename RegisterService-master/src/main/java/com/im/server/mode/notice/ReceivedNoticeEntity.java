package com.im.server.mode.notice;

/**
 * Created by majun on 16/4/19.
 */
public class ReceivedNoticeEntity {
    private Long senderId;
    private String senderName;
    private Long noticeId;
    private String noticeDes;

    public String getNoticeDes() {
        return noticeDes;
    }

    public ReceivedNoticeEntity setNoticeDes(String noticeDes) {
        this.noticeDes = noticeDes;
        return this;
    }

    public Long getNoticeId() {
        return noticeId;
    }

    public ReceivedNoticeEntity setNoticeId(Long noticeId) {
        this.noticeId = noticeId;
        return this;
    }

    public Long getSenderId() {
        return senderId;
    }

    public ReceivedNoticeEntity setSenderId(Long senderId) {
        this.senderId = senderId;
        return this;
    }

    public String getSenderName() {
        return senderName;
    }

    public ReceivedNoticeEntity setSenderName(String senderName) {
        this.senderName = senderName;
        return this;
    }

    @Override
    public String toString() {
        return "ReceivedNoticeEntity{" +
                "noticeDes='" + noticeDes + '\'' +
                ", senderId=" + senderId +
                ", senderName='" + senderName + '\'' +
                ", noticeId=" + noticeId +
                '}';
    }
}
