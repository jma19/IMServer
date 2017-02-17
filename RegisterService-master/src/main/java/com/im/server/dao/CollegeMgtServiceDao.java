package com.im.server.dao;

import com.im.server.mode.db.College;
import java.util.List;
/**
 * Created by majun on 16/3/4.
 */
public interface CollegeMgtServiceDao {

    void createCollegeEntity(College college);

    List<College> queryCollegeEntities(String univName);

    Long queryCollegeId(Long univId, String collegeName);

}
