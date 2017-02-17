package com.im.server.mode.db;

/**
 * Created by majun on 16/3/19.
 */
public class ClassEntity {
    private Long id;
    private String className;
    private Long gradeId;

    public String getClassName() {
        return className;
    }

    public ClassEntity setClassName(String className) {
        this.className = className;
        return this;
    }

    public Long getGradeId() {
        return gradeId;
    }

    public ClassEntity setGradeId(Long gradeId) {
        this.gradeId = gradeId;
        return this;
    }

    public Long getId() {
        return id;
    }

    public ClassEntity setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public String toString() {
        return "ClassEntity{" +
                "className='" + className + '\'' +
                ", id=" + id +
                ", gradeId=" + gradeId +
                '}';
    }
}
