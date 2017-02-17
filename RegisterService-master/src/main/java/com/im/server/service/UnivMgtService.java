package com.im.server.service;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.collect.Lists;
import com.im.server.common.ExceptionConstants;
import com.im.server.common.ServiceException;
import com.im.server.dao.UnivMgtServiceDao;
import com.im.server.mode.db.University;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by majun on 16/3/3.
 */
@Service
public class UnivMgtService {

    private final static Log logger = LogFactory.getLog(UnivMgtService.class);

    @Autowired
    private UnivMgtServiceDao univMgtServiceDao;

    //使用缓存机制
    private final Supplier<Map<Integer, University>> univSupplier = Suppliers.memoize(() -> getUniversityEntities());

    private Map<Integer, University> getUniversityEntities() {
        ConcurrentHashMap<Integer, University> result = new ConcurrentHashMap<>();

        try {
            univMgtServiceDao.queryUniversityEntities()
                    .stream().map(university -> result.put(university.getId(), university));
        } catch (Exception exp) {
            logger.error("数据库异常,读取学校信息失败", exp);
        }
        return result;
    }

    public void createUniversityEntity(University university) throws ServiceException {

        logger.info(String.format("插入学校entity, university=%s", university));
        try {
            univMgtServiceDao.createUniversityEntity(university);
        } catch (Exception exp) {
            logger.error("数据库异常,插入学校信息失败", exp);
            throw ExceptionConstants.ACCEESS_DB_EXCEPTION;
        }
    }

    public List<University> getUniversityEntities(String name) throws ServiceException {

        logger.info(String.format("获取学校信息, name=%s", name));

        try {
            return name == null ?
                    Lists.newArrayList(univSupplier.get().values()) :
                    univMgtServiceDao.queryUniversityEntity(name.trim());

        } catch (Exception exp) {
            logger.error("数据库异常,读取学校信息失败", exp);
            throw ExceptionConstants.ACCEESS_DB_EXCEPTION;
        }
    }

    public University getUniversityEntitiy(Integer id) throws ServiceException {
        logger.info(String.format("获取学校信息, id=%s", id));
        return univSupplier.get().get(id);
    }


}
