package com.yrxc.horse.service;

import com.yrxc.horse.entity.User;

import java.util.List;

public interface UserService {

    List<User>  selectAll();
    User selectByName(String uname);
    User selectById(Long id);
    void insertUser(User u);
    void updateUser(User u);
    void deleteUser(Long id);
    int selectCoins(String uname);
    void updateCoins(User u);
}
