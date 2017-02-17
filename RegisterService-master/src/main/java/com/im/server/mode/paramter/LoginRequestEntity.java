package com.im.server.mode.paramter;

/**
 * Created by majun on 16/1/28.
 */
public class LoginRequestEntity {
    private Long pid;
    private String phone;
    private Integer identity;
    private String pwd;
    private Integer platform; //platform = 1 Android,  platform = 2 IOS
    private String devId; //

    public Long getPid() {
        return pid;
    }

    public LoginRequestEntity setPid(Long pid) {
        this.pid = pid;
        return this;
    }

    public Integer getPlatform() {
        return platform;
    }

    public LoginRequestEntity setPlatform(Integer platform) {
        this.platform = platform;
        return this;
    }

    public String getDevId(){
        return devId;
    }

    public Integer getIdentity() {
        return identity;

    }
    public  LoginRequestEntity setDevId(String devId){
        this.devId=devId;
        return this;
    }
    public LoginRequestEntity setIdentity(Integer identity) {
        this.identity = identity;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public LoginRequestEntity setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getPwd() {
        return pwd;
    }

    public LoginRequestEntity setPwd(String pwd) {
        this.pwd = pwd;
        return this;
    }

    @Override
    public String toString() {
        return "LoginRequestEntity{" +
                "devId='" + devId + '\'' +
                ", phone='" + phone + '\'' +
                ", identity=" + identity +
                ", pwd='" + pwd + '\'' +
                ", platform=" + platform +
                '}';
    }
}
