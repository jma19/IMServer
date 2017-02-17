package com.im.server.mode.db;

/**
 * Created by majun on 16/3/19.
 */
public class Grade {
    private Long id;
    private String name;
    private Long univId;

    public Long getId() {
        return id;
    }

    public Grade setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Grade setName(String name) {
        this.name = name;
        return this;
    }

    public Long getUnivId() {
        return univId;
    }

    public Grade setUnivId(Long univId) {
        this.univId = univId;
        return this;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", univId=" + univId +
                '}';
    }
}
