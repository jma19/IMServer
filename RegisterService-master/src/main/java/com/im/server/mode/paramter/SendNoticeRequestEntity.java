package com.im.server.mode.paramter;

import com.im.server.mode.notice.ContactEntity;

public class SendNoticeRequestEntity {
    private ContactEntity sender;
    private Receivers receivers;
    private NoticeBody noticeBody;

    public ContactEntity getSender() {
        return sender;
    }

    public SendNoticeRequestEntity setSender(ContactEntity sender) {
        this.sender = sender;
        return this;
    }


    public Receivers getReceivers() {
        return receivers;
    }

    public SendNoticeRequestEntity setReceivers(Receivers receivers) {
        this.receivers = receivers;
        return this;
    }

    public NoticeBody getNoticeBody() {
        return noticeBody;
    }

    public SendNoticeRequestEntity setNoticeBody(NoticeBody noticeBody) {
        this.noticeBody = noticeBody;
        return this;
    }

    @Override
    public String toString() {
        return "SendNoticeRequestEntity{" +
                "noticeBody=" + noticeBody +
                ", sender=" + sender +
                ", receivers=" + receivers +
                '}';
    }
}
