package com.im.server.mode;

public class ContactEntity {
    private String name;
    private Long pid;
    private Integer type;

    public Integer getType() {
        return type;
    }

    public ContactEntity setType(Integer type) {
        this.type = type;
        return this;
    }

    public String getName() {
        return name;
    }

    public ContactEntity setName(String name) {
        this.name = name;
        return this;
    }

    public Long getPid() {
        return pid;
    }

    public ContactEntity setPid(Long pid) {
        this.pid = pid;
        return this;
    }

    @Override
    public String toString() {
        return "ContactEntity{" +

                "name='" + name + '\'' +
                ", pid=" + pid +
                '}';
    }
}
