package com.im.server.mode.notice;

import java.util.List;

/**
 * Created by majun on 16/1/2.
 */
public class Group {
    private ContactEntity admin;
    private ContactEntity assistant;
    private List<ContactEntity> classEntities;

    public List<ContactEntity> getClassEntities() {
        return classEntities;
    }

    public Group setClassEntities(List<ContactEntity> classEntities) {
        this.classEntities = classEntities;
        return this;
    }

    public ContactEntity getAdmin() {
        return admin;
    }

    public Group setAdmin(ContactEntity admin) {
        this.admin = admin;
        return this;
    }

    public ContactEntity getAssistant() {
        return assistant;
    }

    public Group setAssistant(ContactEntity assistant) {
        this.assistant = assistant;
        return this;
    }

    @Override
    public String toString() {
        return "Group{" +
                "admin=" + admin +
                ", assistant=" + assistant +
                ", classEntities=" + classEntities +
                '}';
    }
}
