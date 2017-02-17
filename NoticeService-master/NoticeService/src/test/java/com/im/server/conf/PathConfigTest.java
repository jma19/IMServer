package com.im.server.conf;

import com.im.server.ServerApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by majun on 16/1/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ServerApplication.class)
@WebAppConfiguration
public class PathConfigTest {
    @Autowired
    private PathConfig pathConfig;

    @Test
    public void should_get_pic_location() throws Exception {
        System.out.println(pathConfig.getHead());
    }
}