package com.im.server.dao;


import com.im.server.mode.RegisterEntity;

public interface RegisterServiceDao {


    Integer isRegistered(Long pid);

    void register(RegisterEntity register);

    RegisterEntity queryRegisterInfo(Long pid);

    void updateRegisterInfo(RegisterEntity register);
}
