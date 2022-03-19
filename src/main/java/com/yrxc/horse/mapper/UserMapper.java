package com.yrxc.horse.mapper;

import com.yrxc.horse.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> selectAll();
    User selectByName(String uname);

    User selectById(Long id);
    void insertUser(User u);
    void updateUser(User u);
    void deleteUser(Long id);
    int selectCoins(String uname);
    void updateCoins(User u);
}
