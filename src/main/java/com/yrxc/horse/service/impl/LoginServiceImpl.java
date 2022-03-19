package com.yrxc.horse.service.impl;

import com.yrxc.horse.entity.Login;
import com.yrxc.horse.mapper.LoginMapper;
import com.yrxc.horse.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {


    @Autowired
    LoginMapper loginMapper;
    @Override
    public Login selectByName(Login login) {
        return loginMapper.selectByName(login);
    }

    @Override
    public void insertLogin(Login login) {
        loginMapper.insertLogin(login);
    }

    @Override
    public Login selectById(Long id) {
        return loginMapper.selectById(id);
    }

    @Override
    public List<Login> selectAll() {
        return loginMapper.selectAll();
    }
}
