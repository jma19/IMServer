package com.im.server.dao;

import com.im.server.mode.notice.ContactEntity;
import com.im.server.mode.notice.NoticeEntity;
import com.im.server.mode.notice.NoticePlan;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NoticePlanServiceDao {


    void insertNoticePlan(NoticePlan noticePlan);

    void insertNoticePlans(List<NoticePlan> noticePlan);

    void ensureRead(@Param("noticeId") Long noticeId, @Param("pid") Long pid);

    List<NoticeEntity> querySendedNotices(@Param("pid") Long pid, @Param("fromRow") Integer fromRow, @Param("size") Integer size);

    Integer queryUnReadNoticeCount(Long pid);

    List<NoticeEntity> queryReceivedNotices(@Param("pid") Long pid, @Param("fromRow") Integer fromRow, @Param("size") Integer size);


    Integer queryUnReadNoticePersonCount(Long noticeId);

    Integer queryReadNoticePersonCount(Long noticeId);

    List<ContactEntity> queryUnReadPersonList(@Param("noticeId") Long noticeId);

    List<ContactEntity> queryReadNoticePersonList(Long noticeId);

}
