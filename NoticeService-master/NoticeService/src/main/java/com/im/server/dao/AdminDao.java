package com.im.server.dao;

import com.im.server.mode.AdminInfo;

import java.util.List;

/**
 * Created by majun on 16/2/6.
 */
public interface AdminDao {
    List<AdminInfo> getAllAdmins();
}
