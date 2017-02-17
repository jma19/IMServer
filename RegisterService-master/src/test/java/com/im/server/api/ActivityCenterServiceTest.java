package com.im.server.api;

import com.google.common.collect.Lists;
import com.im.server.ServerApplication;
import com.im.server.common.Constants;
import com.im.server.mode.activity.ActivityEntity;
import com.im.server.utils.JsonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * Created by majun on 16/4/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ServerApplication.class)
@WebAppConfiguration
public class ActivityCenterServiceTest {

    @Autowired
    private ActivityCenterService activityCenterService;

    @Test
    public void should_transform_into_json() throws Exception {
        ActivityEntity activityEntity = new ActivityEntity().setPublisherName("马军")
                .setPublisherPid(123456789l)
                .setPublisherRemark("科学技术协会")
                .setDes("test des")
                .setStartTime("2016-05-01 12:30:00")
                .setEndTime("2016-05-01 14:00:00")
                .setLevel(Constants.Level.CLASS.getValue())
                .setLocation("教一307")
                .setTitle("期末补习");

        System.out.println(JsonUtils.toJson(activityEntity));


    }
}