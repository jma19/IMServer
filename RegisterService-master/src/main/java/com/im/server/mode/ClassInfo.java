package com.im.server.mode;

/**
 * Created by majun on 16/2/6.
 */
public class ClassInfo {
    private Long classId;
    private String className;

    public Long getClassId() {
        return classId;
    }

    public ClassInfo setClassId(Long classId) {
        this.classId = classId;
        return this;
    }

    public String getClassName() {
        return className;
    }

    public ClassInfo setClassName(String className) {
        this.className = className;
        return this;
    }

    @Override
    public String toString() {
        return "ClassInfo{" +
                "classId=" + classId +
                ", className='" + className + '\'' +
                '}';
    }
}
