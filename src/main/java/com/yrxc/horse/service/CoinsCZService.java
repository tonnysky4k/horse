package com.yrxc.horse.service;

import com.yrxc.horse.entity.CoinsCZ;

import java.util.List;

public interface CoinsCZService {

    List<CoinsCZ> selectAll();
    List<CoinsCZ> selectByName(String uname);

    void insertCoinsCZ(CoinsCZ ccz);
    CoinsCZ selectById(Long id);

    void deleteCoinsCZ(Long id);
}
