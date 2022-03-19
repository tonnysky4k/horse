package com.yrxc.horse.mapper;

import com.yrxc.horse.entity.Login;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LoginMapper {

    Login selectByName(Login login);
    Login selectById(Long id);
    List<Login> selectAll();
    void insertLogin(Login login);
}
