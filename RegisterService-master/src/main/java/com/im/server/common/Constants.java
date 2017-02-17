package com.im.server.common;

import com.im.server.mode.Response;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by majun on 15/12/28.
 */
public interface Constants {

    interface ERROR_CODE {
        String SYSTEM_ERROR = "SYSTEM_ERROR";
        String MISS_PARAM = "MISS_PARAM_ERROR";
    }

    int DES_TEXT_LENGTH = 15;

    interface Status {
        String SUCCESS = "SUCCESS";

        String ERROR = "ERROR";
    }

    interface Identify {
        Integer student = 1;
        Integer assistant = 2;
        Integer adim = 3;
    }

    Map<Integer, String> registerStatusMap = new HashMap<Integer, String>() {
        private static final long serialVersionUID = 1L;

        {
            put(0, "尚未开始报到");
            put(10, "报到中....");
            put(20, "完成报到");
        }
    };

    interface ErrorResponse {
        Response no_such_person = new Response().setData("手机号有误,请重新输入或者点击反馈按钮向管理员反馈您的情况").setStatus(Status.ERROR).setCode("NO_SUCH_PHONE");
        Response access_db_error = new Response().setData("访问数据库异常").setStatus(Status.ERROR).setCode("SYSTEM_ERROR");
        Response send_validate_code_error = new Response().setData("发送验证码失败").setStatus(Status.ERROR).setCode("SYSTEM_ERROR");

        Response miss_param_error = new Response().setData("缺少关键参数").setStatus(Status.ERROR).setCode("MISS_PARAM_ERROR");

    }

    Map<Integer, String> transportMap = new HashMap<Integer, String>() {
        private static final long serialVersionUID = 1L;

        {
            put(1, "火车");
            put(2, "汽车");
            put(3, "自驾");
            put(4, "飞机");
        }
    };

    enum FileType {
        jpeg("JPEG", "FFD8FF"), png("png", "89504E47");

        private String name;
        private String code;

        FileType(String name, String code) {
            this.name = name;
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    enum AtendentStatus {
        INTEREST(1), REGISTER(2), CANCEL(3);

        Integer value;

        AtendentStatus(Integer integer) {
            this.value = integer;
        }

        public Integer getValue() {
            return value;
        }
    }


    enum Level {
        CLASS(1), GRADE(2), COLLEGE(3), UNIV(4);

        Integer value;

        Level(Integer integer) {
            this.value = integer;
        }

        public Integer getValue() {
            return value;
        }
    }

}
