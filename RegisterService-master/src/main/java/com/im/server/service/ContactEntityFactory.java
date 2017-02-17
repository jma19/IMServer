package com.im.server.service;

import com.im.server.common.Constants;
import com.im.server.mode.notice.ContactEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by majun on 16/3/24.
 */
@Service
public class ContactEntityFactory {


    @FunctionalInterface
    interface ContactEntityService{
        List<ContactEntity> getContactEntities(Long groupId);
    }
//
//    public Map<Integer,ContactEntityService> contactEntityServiceMap = new HashMap<Integer, ContactEntityService>(){
//        {
//             put(Constants.Level.CLASS.getValue(), new ContactEntityService() {
//                 @Override
//                 public List<ContactEntity> getContactEntities(Long groupId) {
//                     return new ;
//                 }
//             });
//
//        }
//
//    };
}
