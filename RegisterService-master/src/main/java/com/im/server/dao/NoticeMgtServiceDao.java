package com.im.server.dao;

import com.im.server.mode.paramter.NoticeBody;

/**
 * 接口不对外暴露
 */
public interface NoticeMgtServiceDao {

    void insertNotice(NoticeBody noticeBody);

    NoticeBody queryNotice(Long noticeId);

}
