package com.yrxc.horse.service;

import com.yrxc.horse.entity.CoinsTX;

import java.util.List;

public interface CoinsTXService {

    List<CoinsTX> selectAll();
    List<CoinsTX> selectByName(String uname);
    void insertCoinsTX(CoinsTX ctx);

    CoinsTX selectById(Long id);
    void deleteCoinsTX(Long id);
}
