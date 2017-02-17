package com.im.server.api;

import com.im.server.mode.Response;
import com.im.server.utils.JsonUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by majun on 16/2/2.
 */
@RestController
@RequestMapping("/register/test/service")
public class TestService {
    private Log logger = LogFactory.getLog(TestService.class);

    @RequestMapping(path = "/ping", method = RequestMethod.GET)
    public Response ping() {
        logger.info("ping.....");
        //Mice
        return new Response().setData("OK!!!");
    }

}
