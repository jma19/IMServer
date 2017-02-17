package com.im.server.mode;

/**
 * Created by majun on 16/3/2.
 */
public class LoginResponse {
    private Long pid;
    private String name;
    private String uniqueId;
    private String  identity;
    private Integer  univId;
    private String univName;
    private Integer collegeId;
    private String collegeName;
    private Long assistantId;
    private String assistantName;
    private Integer gradeId;
    private String gradeName;
    private String majorName;
    private Integer classId;
    private String className;
    private String imgUrl;

    public Integer getClassId() {
        return classId;
    }

    public LoginResponse setClassId(Integer classId) {
        this.classId = classId;
        return this;
    }

    public Integer getGradeId() {
        return gradeId;
    }

    public LoginResponse setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
        return this;
    }

    public String getAssistantName() {
        return assistantName;
    }

    public LoginResponse setAssistantName(String assistantName) {
        this.assistantName = assistantName;
        return this;
    }

    public Long  getAssistantId() {
        return assistantId;
    }

    public LoginResponse setAssistantId(Long assistantId) {
        this.assistantId = assistantId;
        return this;
    }

    public Integer getCollegeId() {
        return collegeId;
    }

    public LoginResponse setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
        return this;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getClassName() {
        return className;
    }

    public LoginResponse setClassName(String className) {
        this.className = className;
        return this;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public LoginResponse setCollegeName(String collegeName) {
        this.collegeName = collegeName;
        return this;
    }

    public String getGradeName() {
        return gradeName;
    }

    public LoginResponse setGradeName(String gradeName) {
        this.gradeName = gradeName;
        return this;
    }

    public String getIdentity() {
        return identity;
    }

    public LoginResponse setIdentity(String identity) {
        this.identity = identity;
        return this;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public LoginResponse setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    public String getMajorName() {
        return majorName;
    }

    public LoginResponse setMajorName(String majorName) {
        this.majorName = majorName;
        return this;
    }

    public String getName() {
        return name;
    }

    public LoginResponse setName(String name) {
        this.name = name;
        return this;
    }

    public Long getPid() {
        return pid;
    }

    public LoginResponse setPid(Long pid) {
        this.pid = pid;
        return this;
    }


    public LoginResponse setUnivId(Integer univId) {
        this.univId = univId;
        return this;
    }

    public String getUnivName() {
        return univName;
    }

    public Integer getUnivId() {
        return univId;
    }

    public LoginResponse setUnivName(String univName) {
        this.univName = univName;
        return this;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "assistantId=" + assistantId +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                ", uniqueId='" + uniqueId + '\'' +
                ", identity='" + identity + '\'' +
                ", univId=" + univId +
                ", univName='" + univName + '\'' +
                ", collegeId=" + collegeId +
                ", collegeName='" + collegeName + '\'' +
                ", assistantName='" + assistantName + '\'' +
                ", gradeId=" + gradeId +
                ", gradeName='" + gradeName + '\'' +
                ", majorName='" + majorName + '\'' +
                ", classId=" + classId +
                ", className='" + className + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
