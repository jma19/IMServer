package com.im.server.service;

import com.im.server.ServerApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

/**
 * Created by majun on 16/2/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ServerApplication.class)
@WebAppConfiguration
public class PathGeneratorTest {

    @Autowired
    private PathGenerator pathGenerator;
    @Test
    public void testGenerateHeadPath() throws Exception {
        String s = pathGenerator.generateHeadPath(1l, ".jpg'");

        System.out.println(s);
    }

    @Test
    public void testGeneratActivityPath() throws Exception {
        String s = pathGenerator.generatActivityPath(100l, ".jpg");
        System.out.println(s);
    }
}