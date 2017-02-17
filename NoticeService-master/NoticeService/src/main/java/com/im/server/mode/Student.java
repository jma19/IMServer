package com.im.server.mode;

/**
 * Created by majun on 16/1/21.
 */
public class Student {
    
    private Long pid;
    private String name;
    private String gender;
    private String studentId;
    private String phone;
    private String phoneBak;
    private Long univId;
    private String univName;
    private String univCode;
    private String univAddress;
    private Long collegeId;
    private String collegeName;
    private Long gradeId;
    private String gradeName;
    private String assistantName;
    private Long assistantId;
    private Long classId;
    private String className;

    public Long getAssistantId() {
        return assistantId;
    }

    public Student setAssistantId(Long assistantId) {
        this.assistantId = assistantId;
        return this;
    }

    public String getAssistantName() {
        return assistantName;
    }

    public Student setAssistantName(String assistantName) {
        this.assistantName = assistantName;
        return this;
    }

    public Long getClassId() {
        return classId;
    }

    public Student setClassId(Long classId) {
        this.classId = classId;
        return this;
    }

    public String getClassName() {
        return className;
    }

    public Student setClassName(String className) {
        this.className = className;
        return this;
    }

    public Long getCollegeId() {
        return collegeId;
    }

    public Student setCollegeId(Long collegeId) {
        this.collegeId = collegeId;
        return this;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public Student setCollegeName(String collegeName) {
        this.collegeName = collegeName;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public Student setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public Long getGradeId() {
        return gradeId;
    }

    public Student setGradeId(Long gradeId) {
        this.gradeId = gradeId;
        return this;
    }

    public String getGradeName() {
        return gradeName;
    }

    public Student setGradeName(String gradeName) {
        this.gradeName = gradeName;
        return this;
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Student setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getPhoneBak() {
        return phoneBak;
    }

    public Student setPhoneBak(String phoneBak) {
        this.phoneBak = phoneBak;
        return this;
    }

    public Long getPid() {
        return pid;
    }

    public Student setPid(Long pid) {
        this.pid = pid;
        return this;
    }

    public String getStudentId() {
        return studentId;
    }

    public Student setStudentId(String studentId) {
        this.studentId = studentId;
        return this;
    }

    public String getUnivAddress() {
        return univAddress;
    }

    public Student setUnivAddress(String univAddress) {
        this.univAddress = univAddress;
        return this;
    }

    public String getUnivCode() {
        return univCode;
    }

    public Student setUnivCode(String univCode) {
        this.univCode = univCode;
        return this;
    }

    public Long getUnivId() {
        return univId;
    }

    public Student setUnivId(Long univId) {
        this.univId = univId;
        return this;
    }

    public String getUnivName() {
        return univName;
    }

    public Student setUnivName(String univName) {
        this.univName = univName;
        return this;
    }

    @Override
    public String toString() {
        return "Student{" +
                "assistantId=" + assistantId +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", studentId='" + studentId + '\'' +
                ", phone='" + phone + '\'' +
                ", phoneBak='" + phoneBak + '\'' +
                ", univId=" + univId +
                ", univName='" + univName + '\'' +
                ", univCode='" + univCode + '\'' +
                ", univAddress='" + univAddress + '\'' +
                ", collegeId=" + collegeId +
                ", collegeName='" + collegeName + '\'' +
                ", gradeId=" + gradeId +
                ", gradeName='" + gradeName + '\'' +
                ", assistantName='" + assistantName + '\'' +
                ", classId=" + classId +
                ", className='" + className + '\'' +
                '}';
    }
}
