package com.im.server.service;

import com.im.server.ServerApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by majun on 16/4/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ServerApplication.class)
@WebAppConfiguration
public class LoginServiceTest {

    @Autowired
    private LoginService loginService;
    @Test
    public void should_get_studnet_info() throws Exception {
        boolean exist = loginService.isExist("13501738796", "9990");
        System.out.println(exist);
    }
}