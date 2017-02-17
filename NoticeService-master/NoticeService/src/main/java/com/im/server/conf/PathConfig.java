package com.im.server.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by majun on 16/2/1.
 */
@ConfigurationProperties(prefix = "path")
public class PathConfig {

    private String activity;
    private String head;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }
}
