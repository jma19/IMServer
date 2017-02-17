package com.im.server.mode;

import com.im.server.mode.paramter.Sender;
import java.util.List;
/**
 * Created by majun on 16/1/24.
 */
public class NoticeEntity {
    private String title;
    private String des;
    private Sender sender;
    private List<ContactEntity> receivers;

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

    public List<ContactEntity> getReceivers() {
        return receivers;
    }

    public NoticeEntity setReceivers(List<ContactEntity> receivers) {
        this.receivers = receivers;
        return this;
    }
}
