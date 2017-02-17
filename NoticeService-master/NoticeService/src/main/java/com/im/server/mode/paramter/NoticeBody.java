package com.im.server.mode.paramter;

/**
 * Created by majun on 16/1/20.
 */
public class NoticeBody {
    private Long noticeId;
    private String title;
    private String description;
    private String content;
    private Integer type;

    public Long getNoticeId() {
        return noticeId;
    }

    public NoticeBody setNoticeId(Long noticeId) {
        this.noticeId = noticeId;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public NoticeBody setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public NoticeBody setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getContent() {
        return content;
    }

    public NoticeBody setContent(String content) {
        this.content = content;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public NoticeBody setType(Integer type) {
        this.type = type;
        return this;
    }
    @Override
    public String toString() {
        return "NoticeBody{" +
                "noticeId=" + noticeId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", type=" + type +
                '}';
    }
}
