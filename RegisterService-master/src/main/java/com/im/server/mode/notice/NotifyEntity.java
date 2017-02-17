package com.im.server.mode.notice;

import com.im.server.mode.paramter.Sender;

/**
 * Created by majun on 16/4/19.
 */
public class NotifyEntity {
    private Long noticeId;
    private Sender sender;

    public Long getNoticeId() {
        return noticeId;
    }

    public NotifyEntity setNoticeId(Long noticeId) {
        this.noticeId = noticeId;
        return this;
    }

    public Sender getSender() {
        return sender;
    }

    public NotifyEntity setSender(Sender sender) {
        this.sender = sender;
        return this;
    }

    @Override
    public String toString() {
        return "NotifyEntity{" +
                "noticeId=" + noticeId +
                ", sender=" + sender +
                '}';
    }
}
