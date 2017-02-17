package com.im.server.mode.paramter;

/**
 * Created by majun on 16/1/20.
 */
public class Sender {
    private Long pid;
    private String name;

    public String getName() {
        return name;
    }

    public Sender setName(String name) {
        this.name = name;
        return this;
    }

    public Long getPid() {
        return pid;
    }

    public Sender setPid(Long pid) {
        this.pid = pid;
        return this;
    }

    @Override
    public String toString() {
        return "Sender{" +
                "pid=" + pid +
                ", name='" + name + '\'' +
                '}';
    }
}
