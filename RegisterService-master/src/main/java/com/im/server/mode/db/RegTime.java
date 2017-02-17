package com.im.server.mode.db;

import java.sql.Timestamp;

/**
 * Created by majun on 16/3/5.
 */
public class RegTime {

    private Long id;
    private Long pid;
    private String name;
    private String startAt;
    private String detail;
    private String endAt;
    private Integer isValid;

    public String getName() {
        return name;
    }

    public RegTime setName(String name) {
        this.name = name;
        return this;
    }

    public String getDetail() {
        return detail;
    }

    public RegTime setDetail(String detail) {
        this.detail = detail;
        return this;
    }

    public String getEndAt() {
        return endAt;
    }

    public RegTime setEndAt(String endAt) {
        this.endAt = endAt;
        return this;
    }

    public Long getId() {
        return id;
    }

    public RegTime setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getIsValid() {
        return isValid;
    }

    public RegTime setIsValid(Integer isValid) {
        this.isValid = isValid;
        return this;
    }

    public Long getPid() {
        return pid;
    }

    public RegTime setPid(Long pid) {
        this.pid = pid;
        return this;
    }

    public String getStartAt() {
        return startAt;
    }

    public RegTime setStartAt(String startAt) {
        this.startAt = startAt;
        return this;
    }


    @Override
    public String toString() {
        return "RegTime{" +
                "endAt=" + endAt +
                ", id=" + id +
                ", pid=" + pid +
                ", startAt=" + startAt +
                ", isValid=" + isValid +
                '}';
    }
}
