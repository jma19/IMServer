package com.im.server.mode;

/**
 * Created by majun on 16/1/22.
 */
public class EnsureReadEntity {
    private Long pid;
    private Long noticeId;

    public Long getPid() {
        return pid;
    }

    public EnsureReadEntity setPid(Long pid) {
        this.pid = pid;
        return this;
    }

    public Long getNoticeId() {
        return noticeId;
    }

    public EnsureReadEntity setNoticeId(Long noticeId) {
        this.noticeId = noticeId;
        return this;
    }

    @Override
    public String toString() {
        return "EnsureReadEntity{" +
                "pid=" + pid +
                ", noticeId=" + noticeId +
                '}';
    }
}

