package com.im.server.dao;

import com.im.server.mode.db.University;
import java.util.List;
/**
 * Created by majun on 16/3/3.
 */
public interface UnivMgtServiceDao {

    void createUniversityEntity(University university);

    List<University> queryUniversityEntity(String name);

    List<University> queryUniversityEntities();

}
