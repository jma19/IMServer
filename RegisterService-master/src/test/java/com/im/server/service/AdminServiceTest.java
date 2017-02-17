package com.im.server.service;

import com.im.server.ServerApplication;
import com.im.server.mode.AdminInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by majun on 16/4/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ServerApplication.class)
@WebAppConfiguration
public class AdminServiceTest {

    @Autowired
    private AdminService adminService;

    @Test
    public void should_get_admin_info() throws Exception {
        AdminInfo first = adminService.findFirst();
        assertThat(first!=null, is(true));
    }
}