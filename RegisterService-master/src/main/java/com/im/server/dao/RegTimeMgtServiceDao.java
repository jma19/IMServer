package com.im.server.dao;

import com.im.server.mode.db.RegTime;

/**
 * Created by majun on 16/3/5.
 */
public interface RegTimeMgtServiceDao {

    void createRegTimeEntity(RegTime regTime);

    RegTime queryTimeEntity(Long pid);
}
