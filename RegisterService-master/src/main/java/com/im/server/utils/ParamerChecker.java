package com.im.server.utils;

import com.google.common.base.Strings;
import com.im.server.common.ServiceException;

import java.util.Collection;

/**
 * Created by majun on 16/1/20.
 */
public class ParamerChecker {

    public static boolean isNull(Object obj) {
        return obj == null;
    }

    public static boolean isNullOrEmpty(String str) {
        return Strings.isNullOrEmpty(str);
    }

    public static <T extends Collection> boolean isNull(T coll) {
        return coll == null || coll.isEmpty();
    }

    public static void checkNotNull(Object obj, String msg) throws ServiceException {
        if (isNull(obj)) {
            throw new ServiceException("MISS_PARAMETER_ERROR", msg);
        }
    }
}
