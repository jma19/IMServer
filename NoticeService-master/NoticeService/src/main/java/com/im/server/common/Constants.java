package com.im.server.common;

import java.util.InputMismatchException;

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

    interface Type {
        Integer STUDENT = 1;
        Integer ASSISTANT = 2;
    }

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


    interface Level {
        Integer classLevel = 1;
        Integer gradeLevel = 2;
        Integer collegeLevel = 3;
        Integer univLevel = 4;
    }
}
