package com.im.server.mode.db;

/**
 * Created by majun on 16/3/2.
 */
public class University {

    private Integer id;
    private String name;
    private String code;
    private String address;

    public String getAddress() {
        return address;
    }

    public University setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getCode() {
        return code;
    }

    public University setCode(String code) {
        this.code = code;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public University setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public University setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "University{" +
                "address='" + address + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
