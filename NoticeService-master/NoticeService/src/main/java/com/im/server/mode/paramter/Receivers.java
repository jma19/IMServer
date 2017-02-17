package com.im.server.mode.paramter;

import com.im.server.mode.ContactEntity;

import java.util.List;

/**
 * Created by majun on 16/1/20.
 */
public class Receivers {
    private List<Long> classIds;
    private ContactEntity assistant;
    private List<ContactEntity> students;

    public List<Long> getClassIds() {
        return classIds;
    }

    public Receivers setClassIds(List<Long> classIds) {
        this.classIds = classIds;
        return this;
    }

    public ContactEntity getAssistant() {
        return assistant;
    }

    public Receivers setAssistant(ContactEntity assistant) {
        this.assistant = assistant;
        return this;
    }

    public List<ContactEntity> getStudents() {
        return students;
    }

    public Receivers setStudents(List<ContactEntity> students) {
        this.students = students;
        return this;
    }

    @Override
    public String toString() {
        return "Receivers{" +
                "classIds=" + classIds +
                ", assistant=" + assistant +
                '}';
    }
}
