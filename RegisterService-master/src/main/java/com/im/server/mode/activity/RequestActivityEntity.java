package com.im.server.mode.activity;

/**
 * Created by majun on 16/4/21.
 */
public class RequestActivityEntity {
    private Long pid;
    private Integer fromRow;
    private Integer size = 10;

    public Integer getFromRow() {
        return fromRow;
    }

    public RequestActivityEntity setFromRow(Integer fromRow) {
        this.fromRow = fromRow;
        return this;
    }

    public Long getPid() {
        return pid;
    }

    public RequestActivityEntity setPid(Long pid) {
        this.pid = pid;
        return this;
    }

    public Integer getSize() {
        return size;
    }

    public RequestActivityEntity setSize(Integer size) {
        this.size = size;
        return this;
    }

    @Override
    public String toString() {
        return "RequestActivityEntity{" +
                "fromRow=" + fromRow +
                ", pid=" + pid +
                ", size=" + size +
                '}';
    }
}
