package com.im.server.mode.paramter;


/**
 * Created by majun on 16/3/5.
 */
public class RegTimeEntity {
    private Long id;
    private Long pid;
    private String name;
    private String startAt;
    private String endAt;
    private String detail;
    private Integer isValid;

    public String getName() {
        return name;
    }

    public RegTimeEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getDetail() {
        return detail;
    }

    public RegTimeEntity setDetail(String detail) {
        this.detail = detail;
        return this;
    }

    public String getEndAt() {
        return endAt;
    }

    public RegTimeEntity setEndAt(String endAt) {
        this.endAt = endAt;
        return this;
    }

    public Long getId() {
        return id;
    }

    public RegTimeEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getIsValid() {
        return isValid;
    }

    public RegTimeEntity setIsValid(Integer isValid) {
        this.isValid = isValid;
        return this;
    }

    public Long getPid() {
        return pid;
    }

    public RegTimeEntity setPid(Long pid) {
        this.pid = pid;
        return this;
    }

    public String getStartAt() {
        return startAt;
    }

    public RegTimeEntity setStartAt(String startAt) {
        this.startAt = startAt;
        return this;
    }

    @Override
    public String toString() {
        return "RegTimeEntity{" +
                "endAt=" + endAt +
                ", id=" + id +
                ", pid=" + pid +
                ", startAt=" + startAt +
                ", isValid=" + isValid +
                '}';
    }
}
