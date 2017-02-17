package com.im.server.mode;

/**
 * Created by majun on 16/3/5.
 */
public class IdentifyEntity {
    private Long pid;
    private Integer identify ;

    public Integer getIdentify() {
        return identify;
    }

    public IdentifyEntity setIdentify(Integer identify) {
        this.identify = identify;
        return this;
    }

    public Long getPid() {
        return pid;
    }

    public IdentifyEntity setPid(Long pid) {
        this.pid = pid;
        return this;
    }

    @Override
    public String toString() {
        return "IdentifyEntity{" +
                "identify=" + identify +
                ", pid=" + pid +
                '}';
    }
}
