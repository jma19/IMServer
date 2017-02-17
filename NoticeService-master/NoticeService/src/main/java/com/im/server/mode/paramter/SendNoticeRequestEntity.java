package com.im.server.mode.paramter;

public class SendNoticeRequestEntity {
    private Sender sender;
    private Receivers receivers;
    private NoticeBody noticeBody;

    public Sender getSender() {
        return sender;
    }

    public SendNoticeRequestEntity setSender(Sender sender) {
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
                "sender=" + sender +
                ", receivers=" + receivers +
                ", noticeBody=" + noticeBody +
                '}';
    }
}
