package com.im.server.mode.paramter;

import com.im.server.utils.JsonUtils;

/**
 * Created by majun on 16/1/5.
 */
public class RequestNoticeEntity {
    private Long pid;
    private Integer fromRow;
    private Integer size = 10;

    public Integer getFromRow() {
        return fromRow;
    }

    public RequestNoticeEntity setFromRow(Integer fromRow) {
        this.fromRow = fromRow;
        return this;
    }

    public Long getPid() {
        return pid;
    }

    public RequestNoticeEntity setPid(Long pid) {
        this.pid = pid;
        return this;
    }

    public Integer getSize() {
        return size;
    }

    public RequestNoticeEntity setSize(Integer size) {
        this.size = size;
        return this;
    }

    @Override
    public String toString() {
        return "RequestNoticeEntity{" +
                "fromRow=" + fromRow +
                ", pid=" + pid +
                ", size=" + size +
                '}';
    }
    public static void main(String [] args){
        RequestNoticeEntity requestNoticeEntity = new RequestNoticeEntity();
        requestNoticeEntity
                .setPid(3l)
                .setFromRow(0)
                .setSize(5);
        System.out.println(JsonUtils.toJson(requestNoticeEntity));
    }
}
