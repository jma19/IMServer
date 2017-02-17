package com.im.server.service;

import com.cloopen.rest.sdk.CCPRestSDK;
import com.im.server.common.ExceptionConstants;
import com.im.server.common.ServiceException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by majun on 16/2/27.
 */
@Service
public class IMService {
    //    private final static String APPID = "aaf98f8952f7367a015321be5a2e4e97";
//    private final static String TOKEN = "b19b0834e83fabbe26c241ca90ab1583";
    private final static String HOST = "https://sandboxapp.cloopen.com:8883";
    //测试环境
    private final static String ACCOUNTSID = "8a48b55152f73add015321bbd0344d79";
    private final static String AUTHTOKEN = "798336779cc0417aa79efbe899daf286";
    private final static String APPID = "aaf98f8952f7367a015321bc324c4e91";
    private final static String TOKEN = "32c322807040f32910aeafe83fa80612";

    private String get(String phone) {
        return null;
    }

    /*
    1.免费开发测试需要使用"控制台—应用—测试demo"下相关信息，如主账号，应用ID。
    2.免费开发测试使用的模板ID为1，形式为：【云通讯】您使用的是云通讯短信模板，您的验证码是{1}，请于{2}分钟内正确输入，{1}和{2}为短信模板的参数。
    3.免费开发测试需要使用沙盒环境。
    4.免费开发测试需要在"控制台—应用—号码管理—测试号码"绑定测试号码。
    5.开发测试过程请参考 开发指南 及 Demo示例 。
     */
    public static void main(String[] args) {
        HashMap result = null;
        CCPRestSDK restAPI = new CCPRestSDK();

        // 初始化服务器地址和端口，沙盒环境配置成sandboxapp.cloopen.com，生产环境配置成app.cloopen.com，端口都是8883.
        restAPI.init("sandboxapp.cloopen.com", "8883");

        // 初始化主账号名称和主账号令牌，登陆云通讯网站后，可在"控制台-应用"中看到开发者主账号ACCOUNT SID和主账号令牌AUTH TOKEN。
        restAPI.setAccount(ACCOUNTSID, AUTHTOKEN);

        // 初始化应用ID，如果是在沙盒环境开发，请配置"控制台-应用-测试DEMO"中的APPID。
        restAPI.setAppId(APPID);
        //如切换到生产环境，请使用自己创建应用的APPID

        result = restAPI.sendTemplateSMS("13501738796", "1", new String[]{"8888"});
        System.out.println("SDKTestGetSubAccounts result=" + result);

        if ("000000".equals(result.get("statusCode"))) {
            //正常返回输出data包体信息（map）
            HashMap data = (HashMap) result.get("data");
            Set<String> keySet = data.keySet();
            for (String key : keySet) {
                Object object = data.get(key);
                System.out.println(key + " = " + object);
            }
        } else {
            //异常返回输出错误码和错误信息
            System.out.println("错误码=" + result.get("statusCode") + " 错误信息= " + result.get("statusMsg"));
        }
    }

    public void sendValidateCode (String phone, String randomValue) throws ServiceException {
        HashMap result = null;
        CCPRestSDK restAPI = new CCPRestSDK();
        // 初始化服务器地址和端口，沙盒环境配置成sandboxapp.cloopen.com，生产环境配置成app.cloopen.com，端口都是8883.
        restAPI.init("sandboxapp.cloopen.com", "8883");
        // 初始化主账号名称和主账号令牌，登陆云通讯网站后，可在"控制台-应用"中看到开发者主账号ACCOUNT SID和主账号令牌AUTH TOKEN。
        restAPI.setAccount(ACCOUNTSID, AUTHTOKEN);
        // 初始化应用ID，如果是在沙盒环境开发，请配置"控制台-应用-测试DEMO"中的APPID。
        restAPI.setAppId(APPID);
        //如切换到生产环境，请使用自己创建应用的APPID


        result = restAPI.sendTemplateSMS("13501738796", "1", new String[]{randomValue});
        if ("000000".equals(result.get("statusCode"))) {
            //正常返回输出data包体信息（map）
            HashMap data = (HashMap) result.get("data");
            Set<String> keySet = data.keySet();
            for (String key : keySet) {
                Object object = data.get(key);
                System.out.println(key + " = " + object);
            }
        } else {
            //异常返回输出错误码和错误信息
            System.out.println("错误码=" + result.get("statusCode") + " 错误信息= " + result.get("statusMsg"));
            throw ExceptionConstants.SEND_VALIDATE_CPDE_EXCEPTION;
        }

    }

}
