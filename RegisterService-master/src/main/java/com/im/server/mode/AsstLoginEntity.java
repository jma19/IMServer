package com.im.server.mode;

/**
 * Created by JSexy on 2016/2/1.
 */

public class AsstLoginEntity {
    private Long id;
    private Long pid;
    private Integer identity;
    private String name;
    private String univName;
    private String collegeName;
    private String imgUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnivName() {
        return univName;
    }

    public void setUnivName(String univName) {
        this.univName = univName;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "AsstLoginEntity{" +
                "id=" + id +
                ", pid=" + pid +
                ", identity=" + identity +
                ", name='" + name + '\'' +
                ", univName='" + univName + '\'' +
                ", college='" + collegeName + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
