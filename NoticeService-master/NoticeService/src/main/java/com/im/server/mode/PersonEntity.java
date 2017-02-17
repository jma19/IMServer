package com.im.server.mode;

public class PersonEntity {
    private String name;
    private String pid;
    private String studentId;
    private String majorName;
    private String className;
    private String univName;
    private String phone;
    private String remark;

    public String getRemark() {
        return remark;
    }

    public PersonEntity setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public PersonEntity setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getStudentId() {
        return studentId;
    }

    public PersonEntity setStudentId(String studentId) {
        this.studentId = studentId;
        return this;
    }

    public String getClassName() {
        return className;
    }

    public PersonEntity setClassName(String className) {
        this.className = className;
        return this;
    }

    public String getMajorName() {
        return majorName;
    }

    public PersonEntity setMajorName(String majorName) {
        this.majorName = majorName;
        return this;
    }

    public String getUnivName() {
        return univName;
    }

    public PersonEntity setUnivName(String univName) {
        this.univName = univName;
        return this;
    }

    public String getName() {
        return name;
    }

    public PersonEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getPid() {
        return pid;
    }

    public PersonEntity setPid(String pid) {
        this.pid = pid;
        return this;
    }

    @Override
    public String toString() {
        return "PersonEntity{" +
                "className='" + className + '\'' +
                ", name='" + name + '\'' +
                ", pid='" + pid + '\'' +
                ", studentId='" + studentId + '\'' +
                ", majorName='" + majorName + '\'' +
                ", univName='" + univName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
