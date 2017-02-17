package com.im.server.mode;

/**
 * Created by majun on 16/1/21. 辅导员信息
 */
public class Assistant {
    private Long assistantId;
    private String facultyId;
    private String gender;
    private String assistantName;
    private String phone;
    private String phoneBak;
    private String univId;
    private String univName;
    private Long collegeId;
    private String collegeName;

    public Long getAssistantId() {
        return assistantId;
    }

    public void setAssistantId(Long assistantId) {
        this.assistantId = assistantId;
    }

    public String getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAssistantName() {
        return assistantName;
    }

    public void setAssistantName(String assistantName) {
        this.assistantName = assistantName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoneBak() {
        return phoneBak;
    }

    public void setPhoneBak(String phoneBak) {
        this.phoneBak = phoneBak;
    }

    public String getUnivId() {
        return univId;
    }

    public void setUnivId(String univId) {
        this.univId = univId;
    }

    public String getUnivName() {
        return univName;
    }

    public void setUnivName(String univName) {
        this.univName = univName;
    }

    public Long getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Long collegeId) {
        this.collegeId = collegeId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }


    @Override
    public String toString() {
        return "Assistant{" +
                "assistantId=" + assistantId +
                ", facultyId='" + facultyId + '\'' +
                ", gender='" + gender + '\'' +
                ", assistantName='" + assistantName + '\'' +
                ", phone='" + phone + '\'' +
                ", phoneBak='" + phoneBak + '\'' +
                ", univId='" + univId + '\'' +
                ", univName='" + univName + '\'' +
                ", collegeId=" + collegeId +
                ", collegeName='" + collegeName + '\'' +
                '}';
    }
}
