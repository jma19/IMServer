package com.im.server.dao;

import com.im.server.mode.NoticePlan;
import com.im.server.mode.PersonEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NoticePlanServiceDao {


    void insertNoticePlan(NoticePlan noticePlan);

    void insertNoticePlans(List<NoticePlan> noticePlan);

    void ensureRead(@Param("noticeId") Long messageId, @Param("pid") Long pid);

    List<NoticePlan> querySendedNotices(@Param("pid") Long pid, @Param("fromRow") Integer fromRow, @Param("size") Integer size);

    Integer queryUnReadNoticeCount(Long pid);

    List<NoticePlan> queryReceivedMessageNotice(@Param("pid") Long pid, @Param("fromRow") Integer fromRow, @Param("size") Integer size);


    Integer queryUnReadNoticePersonCount(Long noticeId);

    Integer queryReadNoticePersonCount(Long noticeId);

    List<PersonEntity> queryUnReadNoticePersonList(Long noticeId);

    List<PersonEntity> queryReadNoticePersonList(Long noticeId);

}
