package com.im.server.mode;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by majun on 16/1/2.
 */
public class DivideInfo {
    private Group group;
    private List<ContactEntity> contacts;

    public Group getGroup() {
        return group;
    }

    public DivideInfo setGroup(Group group) {
        this.group = group;
        return this;
    }

    public List<ContactEntity> getContacts() {
        return contacts;
    }

    public DivideInfo setContacts(List<ContactEntity> contacts) {
        this.contacts = contacts;
        return this;
    }

    @Override
    public String toString() {
        return "DivideInfo{" +
                ", group=" + group +
                ", contacts=" + contacts +
                '}';
    }
}
