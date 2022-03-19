package com.yrxc.horse.service;

import com.yrxc.horse.entity.Login;

public interface TokenService {

    String getToken(Login log);
}
