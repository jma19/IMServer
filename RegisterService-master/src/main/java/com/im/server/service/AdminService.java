package com.im.server.service;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.im.server.dao.AdminDao;
import com.im.server.mode.AdminInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;

/**
 * Created by majun on 16/2/6.
 */
@Service
public class AdminService {
    private final static Log logger = LogFactory.getLog(AdminService.class);
    private final Supplier<Map<Long, AdminInfo>> mapSupplier = Suppliers.memoize(() -> getAll());

    @Autowired
    private AdminDao adminDao;

    private Map<Long, AdminInfo> getAll() {
        Map<Long, AdminInfo> adminInfoMap = new ConcurrentHashMap<>();
        try {
            List<AdminInfo> allAdmins = adminDao.getAllAdmins();
            for (AdminInfo adminInfo : allAdmins) {
                adminInfoMap.put(adminInfo.getId(), adminInfo);
            }
        } catch (Exception exp) {
            logger.error("获取管理员信息失败, 数据库异常!!", exp);
        }
        return adminInfoMap;

    }

    public AdminInfo findFirst() {
        Map<Long, AdminInfo> adminInfoMap = mapSupplier.get();
        try {
            Long first = adminInfoMap.keySet().stream().findFirst().get();
            return adminInfoMap.get(first);
        } catch (Exception exp) {
            logger.warn("获取AdminInfo失败,");
            return null;
        }
    }

    public AdminInfo get(Long pid) {
        return mapSupplier.get().get(pid);
    }
}
