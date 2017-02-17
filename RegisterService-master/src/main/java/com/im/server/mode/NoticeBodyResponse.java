package com.im.server.mode;

import com.im.server.mode.paramter.NoticeBody;

/**
 * Created by majun on 16/4/18.
 */
public class NoticeBodyResponse {
    private NoticeBody noticeBody;
    private Integer unReadCount;
    private Integer readCount;


    public NoticeBody getNoticeBody() {
        return noticeBody;
    }

    public NoticeBodyResponse setNoticeBody(NoticeBody noticeBody) {
        this.noticeBody = noticeBody;
        return this;
    }

    public Integer getReadCount() {
        return readCount;
    }

    public NoticeBodyResponse setReadCount(Integer readCount) {
        this.readCount = readCount;
        return this;
    }

    public Integer getUnReadCount() {
        return unReadCount;
    }

    public NoticeBodyResponse setUnReadCount(Integer unReadCount) {
        this.unReadCount = unReadCount;
        return this;
    }

    @Override
    public String toString() {
        return "NoticeBodyResponse{" +
                "noticeBody=" + noticeBody +
                ", unReadCount=" + unReadCount +
                ", readCount=" + readCount +
                '}';
    }
}
