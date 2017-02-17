package com.im.server.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by majun on 16/2/2.
 */
@RestController
@RequestMapping("/test/service")
public class TestService {

    @RequestMapping(path = "/ping", method = RequestMethod.GET)
    public String ping() {
        return "OK!!!";
    }
}
