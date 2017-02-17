package com.im.server.mode;

/**
 * Created by majun on 15/12/27.
 */
public class Location {
    private String province;
    private String city;
    private String text;

    public String getProvince() {
        return province;
    }

    public Location setProvince(String province) {
        this.province = province;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Location setCity(String city) {
        this.city = city;
        return this;
    }

    public String getText() {
        return text;
    }

    public Location setText(String text) {
        this.text = text;
        return this;
    }

}
