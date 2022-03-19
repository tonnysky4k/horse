package com.yrxc.horse.service.impl;

import com.yrxc.horse.entity.User;
import com.yrxc.horse.mapper.UserMapper;
import com.yrxc.horse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl  implements UserService {


    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public User selectByName(String uname) {
        return userMapper.selectByName(uname);
    }

    @Override
    public User selectById(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    public void insertUser(User u) {

        userMapper.insertUser(u);

    }

    @Override
    public void updateUser(User u) {

        userMapper.updateUser(u);

    }

    @Override
    public void deleteUser(Long id) {
        userMapper.deleteUser(id);

    }

    @Override
    public int selectCoins(String uname) {
        return userMapper.selectCoins(uname);
    }

    @Override
    public void updateCoins(User u) {
        userMapper.updateCoins(u);
    }
}
