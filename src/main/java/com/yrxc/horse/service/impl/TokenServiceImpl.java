package com.yrxc.horse.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.yrxc.horse.entity.Login;
import com.yrxc.horse.service.TokenService;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class TokenServiceImpl implements TokenService {

    @Override
    public String getToken(Login log) {
        String token ="";
        JWTCreator.Builder builder = JWT.create();
        builder.withAudience(log.getId().toString());
        builder.withExpiresAt(new Date(System.currentTimeMillis()+ 10800 *1000));
        token = builder.sign(Algorithm.HMAC256(log.getScode()));
        return token;
    }
}
