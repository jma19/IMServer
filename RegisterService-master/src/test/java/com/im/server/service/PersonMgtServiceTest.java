package com.im.server.service;

import com.google.common.collect.Lists;
import com.im.server.ServerApplication;
import com.im.server.mode.LoginResponse;
import com.im.server.mode.notice.ContactEntity;
import com.im.server.mode.notice.DivideInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * Created by majun on 16/4/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ServerApplication.class)
@WebAppConfiguration
public class PersonMgtServiceTest {

    @Autowired
    private PersonMgtService personMgtService;
    @Test
    public void testGetPerInfo() throws Exception {
        LoginResponse perInfo = personMgtService.getPerInfo("18168058010", 2);
        System.out.println(perInfo);
    }

    @Test
    public void should_get_person_contact_list_when_input_student_id() throws Exception {
        DivideInfo contactInfo = personMgtService.getContactInfo(1, 123456789l);
        System.out.println(contactInfo);
    }

    @Test
    public void shold_get_person_contact_list_when_input_assistant_id() throws Exception {
        DivideInfo contactInfo = personMgtService.getContactInfo(2, 121331l);
        System.out.println(contactInfo);
    }

    @Test
    public void should_get_students_by_class_ids() throws Exception {
        List<ContactEntity> students = personMgtService.getStudentsByClassIds(Lists.newArrayList(1));
        System.out.println(students);
    }

    @Test
    public void should_get_students_by_assistant_id() throws Exception {
        List<ContactEntity> studentsByAssistantId = personMgtService.getStudentsByAssistantId(121331l);
        System.out.println(studentsByAssistantId);
    }




}