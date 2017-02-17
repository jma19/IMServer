package com.im.server.api;

import com.im.server.ServerApplication;
import com.im.server.dao.UnivMgtServiceDao;
import com.im.server.mode.Response;
import com.im.server.mode.db.University;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by majun on 16/3/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ServerApplication.class)
@WebAppConfiguration
public class IUniversityServiceTest {

    @Autowired
    private IUniversityService universityService;

    private Log logger = LogFactory.getLog(IUniversityServiceTest.class);


    @Test
    public void testGetUniversityEntity() throws Exception {
        Response allUniversityEntities = universityService.getUniversityEntity("南京邮电");
        logger.info(allUniversityEntities);
    }

    @Test
    public void testGetAllUniversityEntities() throws Exception {
        Response allUniversityEntities = universityService.getAllUniversityEntities();
        logger.info(allUniversityEntities);
    }
    
}


