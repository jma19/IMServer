package com.im.server.dao;

import com.im.server.mode.db.Major;
import java.util.List;


/**
 * Created by majun on 16/3/5.
 */
public interface MajorServiceDao {

    void createMajorEntity(Major major);

    List<Major> queryMajorEntities();
}
