package com.im.server.mode;


/**
 * Created by majun on 15/12/27.
 */
public class RegisterEntity {
    private Long id;
    private Long pid;
    private String name;
    private Integer univId;
    private Integer collegeId;
    private Long assistantId;
    private String accompany;
    private String preStartTime;
    private String preArriveTime;
    private String actStartTime;
    private String actArriveTime;
    private Integer transType;
    private String transShift; //班次
    private Integer status;
    private String remark;


    public String getAccompany() {
        return accompany;
    }

    public RegisterEntity setAccompany(String accompany) {
        this.accompany = accompany;
        return this;

    }


    public String getActArriveTime() {
        return actArriveTime;
    }

    public RegisterEntity setActArriveTime(String actArriveTime) {
        this.actArriveTime = actArriveTime;
        return this;

    }

    public String getActStartTime() {
        return actStartTime;
    }

    public RegisterEntity setActStartTime(String actStartTime) {
        this.actStartTime = actStartTime;
        return this;

    }

    public String getPreArriveTime() {
        return preArriveTime;
    }

    public RegisterEntity setPreArriveTime(String preArriveTime) {
        this.preArriveTime = preArriveTime;
        return this;

    }

    public Long getAssistantId() {
        return assistantId;
    }

    public RegisterEntity setAssistantId(Long assistantId) {
        this.assistantId = assistantId;
        return this;

    }

    public Integer getCollegeId() {
        return collegeId;
    }

    public RegisterEntity setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
        return this;

    }

    public Long getId() {
        return id;
    }

    public RegisterEntity setId(Long id) {
        this.id = id;
        return this;


    }

    public String getName() {
        return name;
    }

    public RegisterEntity setName(String name) {
        this.name = name;
        return this;

    }


    public Long getPid() {
        return pid;
    }

    public RegisterEntity setPid(Long pid) {
        this.pid = pid;
        return this;

    }

    public String getRemark() {
        return remark;
    }

    public RegisterEntity setRemark(String remark) {
        this.remark = remark;
        return this;

    }

    public String getPreStartTime() {
        return preStartTime;
    }

    public RegisterEntity setPreStartTime(String preStartTime) {
        this.preStartTime = preStartTime;
        return this;

    }

    public Integer getStatus() {
        return status;
    }

    public RegisterEntity setStatus(Integer status) {
        this.status = status;
        return this;

    }


    public String getTransShift() {
        return transShift;
    }

    public RegisterEntity setTransShift(String transShift) {
        this.transShift = transShift;
        return this;

    }

    public Integer getTransType() {
        return transType;
    }

    public RegisterEntity setTransType(Integer transType) {
        this.transType = transType;
        return this;

    }

    public Integer getUnivId() {
        return univId;
    }

    public RegisterEntity setUnivId(Integer univId) {
        this.univId = univId;
        return this;
    }

    @Override
    public String toString() {
        return "RegisterEntity{" +
                "accompany='" + accompany + '\'' +
                ", id=" + id +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                ", univId=" + univId +
                ", collegeId=" + collegeId +
                ", assistantId=" + assistantId +
                ", preStartTime='" + preStartTime + '\'' +
                ", preArriveTime='" + preArriveTime + '\'' +
                ", actStartTime='" + actStartTime + '\'' +
                ", actArriveTime='" + actArriveTime + '\'' +
                ", transType=" + transType +
                ", transShift='" + transShift + '\'' +
                ", status=" + status +
                ", remark='" + remark + '\'' +
                '}';
    }
}
