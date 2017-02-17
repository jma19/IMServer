package com.im.server.mode;

/**
 * Created by majun on 16/2/6.
 */
public class AdminInfo {
    private String name;
    private Long id;
    private String remark;

    public Long getId() {
        return id;
    }

    public AdminInfo setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AdminInfo setName(String name) {
        this.name = name;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public AdminInfo setRemark(String remark) {
        this.remark = remark;
        return this;
    }
}
