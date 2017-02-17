package com.im.server.mode.activity;

/**
 * Created by majun on 16/4/20.
 */
public class AttendentEntity {
    private Long pid;
    private String headUrl;
    private String name;

    public String getHeadUrl() {
        return headUrl;
    }

    public AttendentEntity setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
        return this;
    }

    public String getName() {
        return name;
    }

    public AttendentEntity setName(String name) {
        this.name = name;
        return this;
    }

    public Long getPid() {
        return pid;
    }

    public AttendentEntity setPid(Long pid) {
        this.pid = pid;
        return this;
    }

    @Override
    public String toString() {
        return "AttendentEntity{" +
                "headUrl='" + headUrl + '\'' +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                '}';
    }
}
