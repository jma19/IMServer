//package com.im.server.api;
//
//import com.google.common.collect.Lists;
//import com.im.server.ServerApplication;
//import com.im.server.mode.Response;
//import com.im.server.mode.notice.ContactEntity;
//import com.im.server.mode.paramter.*;
//import com.im.server.utils.JsonUtils;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.AutoConfigureOrder;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//import static org.junit.Assert.*;
//
///**
// * Created by majun on 16/4/15.
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = ServerApplication.class)
//@WebAppConfiguration
//public class NoticeCenterServiceTest {
//
//    @Autowired
//    private NoticeCenterService noticeCenterService;
//
//    @Test
//    public void testSendNotice() throws Exception {
//        //辅导员发信
//        SendNoticeRequestEntity sendNoticesRequestEntity = new SendNoticeRequestEntity()
//                .setSender(new ContactEntity().setPid(123456789l).setName("马军").setType(1))
//                .setReceivers(new Receivers().setClassIds(Lists.newArrayList(1)).setAssistant(new ContactEntity().setName("李森").setPid(121331l).setType(2)).setStudents(Lists.newArrayList(new ContactEntity().setPid(10l).setName("小王"))))
//                .setNoticeBody(new NoticeBody().setTitle("5.1放假通知").setContent("受寒流影响5.1号放假10天左右,请相关的班长做好准备"));
//
//        System.out.println(JsonUtils.toJson(sendNoticesRequestEntity));
//        //Response response = noticeCenterService.sendNotice(sendNoticesRequestEntity);
//        //System.out.println(response);
//    }
//
//    @Test
//    public void testEnsureRead() throws Exception{
//        Response response = noticeCenterService.ensureRead(new EnsureReadEntity().setNoticeId(2818669601441792l).setPid(123456789l));
//        System.out.println(response);
//    }
//
//    @Test
//    public void testGetSendedNotices() throws Exception {
//        RequestNoticeEntity requestNoticeEntity = new RequestNoticeEntity().setFromRow(0).setPid(123456789l);
//        System.out.println(JsonUtils.toJson(requestNoticeEntity));
//        Response sendedNotices = noticeCenterService.getSendedNotices(requestNoticeEntity);
//        System.out.println(sendedNotices);
//    }
//
//    @Test
//    public void testGetReceivedNotices() throws Exception {
//        Response receivedNotices = noticeCenterService.getReceivedNotices(new RequestNoticeEntity().setPid(123456789l).setFromRow(0));
//        System.out.println(receivedNotices);
//    }
//
//    @Test
//    public void testGetUnReadNoticeCount() throws Exception {
//        Response unReadNoticeCount = noticeCenterService.getUnReadNoticeCount(121331l);
//        System.out.println(unReadNoticeCount);
//    }
//
//    @Test
//    public void should_get_notice_content() throws Exception {
//        //获取某条消息的具体内容
//        Response noticeContent = noticeCenterService.getNoticeContent(2819132484700160l);
//
//        System.out.println(noticeContent);
//    }
//
//    @Test
//    public void shuuld_get_person_unread_notice_list() throws Exception {
//        Response unreadPersonList = noticeCenterService.getUnreadPersonList(2819132484700160l);
//        System.out.println(unreadPersonList);
//    }
//
//    @Test
//    public void should_get_contact_list() throws Exception {
//        Response personContactList = noticeCenterService.getPersonContactList(1, 123456789l);
//        System.out.println(personContactList);
//    }
//}