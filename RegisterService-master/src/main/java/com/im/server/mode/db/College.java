package com.im.server.mode.db;


/**
 * Created by majun on 16/3/3.
 */
//建立major表, 建立接入大学的表, 建立大学下面的学院表
    //年级表
public class College {
    private Integer id;
    private Integer univId;
    private String univName;
    private String collegeName;

    public Integer getId() {
        return id;
    }

    public College setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public College setCollegeName(String collegeName) {
        this.collegeName = collegeName;
        return this;
    }

    public Integer getUnivId() {
        return univId;
    }

    public College setUnivId(Integer univId) {
        this.univId = univId;
        return this;
    }

    public String getUnivName() {
        return univName;
    }

    public College setUnivName(String univName) {
        this.univName = univName;
        return this;
    }

    @Override
    public String toString() {
        return "College{" +
                "id=" + id +
                ", univId=" + univId +
                ", univName='" + univName + '\'' +
                ", collegeName='" + collegeName + '\'' +
                '}';
    }
}
