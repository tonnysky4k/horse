package com.yrxc.horse.service;

import com.yrxc.horse.entity.Login;

import java.util.List;

public interface LoginService {

    Login selectByName(Login login);
    void insertLogin(Login login);
    Login selectById(Long id);
    List<Login> selectAll();
}
