package com.im.server.service;

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.AppMessage;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.LinkTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PushService {

    private static String appId = "T9bKeD7jvo7Fn36tSFZyZ6";
    private static String appKey = "rghHsAi3L46N6UWeeITzg4";
    private static String masterSecret = "tfoNpxlY6V585YfkQnujhA";
    private static String url = "http://sdk.open.api.igexin.com/serviceex";

    public void push(String title, String msg) throws IOException {
        IGtPush push = new IGtPush(url, appKey, masterSecret);
        push.connect();
        AppMessage message = new AppMessage();
        LinkTemplate template = new LinkTemplate();
        template.setAppId(appId);
        template.setAppkey(appKey);
        template.setTitle("欢迎使用个推!");
        template.setText("");
        template.setUrl("http://getui.com");
        List<String> appIds = new ArrayList<String>();
        appIds.add(appId);
        message.setData(template);
        message.setAppIdList(appIds);
        message.setOffline(true);
        message.setOfflineExpireTime(1000 * 600);
        IPushResult ret = push.pushMessageToApp(message);
        System.out.println(ret.getResponse().toString());
    }

    public static void main(String[] args) throws IOException {
        IGtPush push = new IGtPush(url, appKey, masterSecret);
        push.connect();
        AppMessage message = new AppMessage();
        LinkTemplate template = new LinkTemplate();
        template.setAppId(appId);
        template.setAppkey(appKey);
        template.setTitle("欢迎使用个推!");
        template.setText("这是一条推送消息~");
        template.setUrl("http://getui.com");
        List<String> appIds = new ArrayList<String>();
        appIds.add(appId);
        message.setData(template);
        message.setAppIdList(appIds);
        message.setOffline(true);
        message.setOfflineExpireTime(1000 * 600);
        IPushResult ret = push.pushMessageToApp(message);
        System.out.println(ret.getResponse().toString());
    }
}