package com.im.server.utils;

import java.util.UUID;

/**
 * Created by majun on 16/2/1.
 */
public class UUIDGenerator {
    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-", "");
    }
}
