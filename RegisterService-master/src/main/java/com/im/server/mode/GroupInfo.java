package com.im.server.mode;

/**
 * Created by majun on 16/4/16.
 */
public class GroupInfo {


    private Long classId;
    private String className;
    private Long assistantId;
    private String assistantName;

    public Long getAssistantId() {
        return assistantId;
    }

    public GroupInfo setAssistantId(Long assistantId) {
        this.assistantId = assistantId;
        return this;
    }

    public String getAssistantName() {
        return assistantName;
    }

    public GroupInfo setAssistantName(String assistantName) {
        this.assistantName = assistantName;
        return this;
    }

    public Long getClassId() {
        return classId;
    }

    public GroupInfo setClassId(Long classId) {
        this.classId = classId;
        return this;
    }

    public String getClassName() {
        return className;
    }

    public GroupInfo setClassName(String className) {
        this.className = className;
        return this;
    }

    @Override
    public String toString() {
        return "GroupInfo{" +
                "assistantId=" + assistantId +
                ", classId=" + classId +
                ", className='" + className + '\'' +
                ", assistantName='" + assistantName + '\'' +
                '}';
    }
}
