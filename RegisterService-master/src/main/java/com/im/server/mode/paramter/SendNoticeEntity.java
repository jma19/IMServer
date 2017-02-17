package com.im.server.mode.paramter;

import com.im.server.mode.notice.ContactEntity;

import java.util.List;

/**
 * Created by majun on 16/1/1.
 */
public class SendNoticeEntity {
    private Long from;
    private String name;
    private List<ContactEntity> to;
    private String title;
    private String msg;
    private Integer type;

    public String getName() {
        return name;
    }

    public SendNoticeEntity setName(String name) {
        this.name = name;
        return this;
    }

    public Long getFrom() {
        return from;
    }

    public SendNoticeEntity setFrom(Long from) {
        this.from = from;
        return this;
    }

    public List<ContactEntity> getTo() {
        return to;
    }

    public SendNoticeEntity setTo(List<ContactEntity> to) {
        this.to = to;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public SendNoticeEntity setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public SendNoticeEntity setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public SendNoticeEntity setType(Integer type) {
        this.type = type;
        return this;
    }

    @Override
    public String toString() {
        return "SendNoticeEntity{" +
                "from=" + from +
                ", to=" + to +
                ", title='" + title + '\'' +
                ", msg='" + msg + '\'' +
                ", type=" + type +
                '}';
    }
}
