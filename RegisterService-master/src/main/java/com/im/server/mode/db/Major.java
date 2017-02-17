package com.im.server.mode.db;

/**
 * Created by majun on 16/3/3.
 */
public class Major {
    private Integer id;
    private String code;

    public String getCode() {
        return code;
    }

    public Major setCode(String code) {
        this.code = code;
        return this;
    }

    private String name;

    public Integer getId() {
        return id;
    }

    public Major setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Major setName(String name) {
        this.name = name;
        return this;
    }
    
    @Override
    public String toString() {
        return "Major{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
