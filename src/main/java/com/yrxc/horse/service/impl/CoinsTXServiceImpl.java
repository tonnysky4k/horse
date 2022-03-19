package com.yrxc.horse.service.impl;


import com.yrxc.horse.entity.CoinsTX;
import com.yrxc.horse.mapper.CoinsTXMapper;
import com.yrxc.horse.service.CoinsTXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoinsTXServiceImpl implements CoinsTXService {

    @Autowired
    CoinsTXMapper coinsTXMapper;

    @Override
    public List<CoinsTX> selectAll() {
        return coinsTXMapper.selectAll();
    }

    @Override
    public List<CoinsTX> selectByName(String uname) {
        return coinsTXMapper.selectByName(uname);
    }

    @Override
    public void insertCoinsTX(CoinsTX ctx) {
        coinsTXMapper.insertCoinsTX(ctx);
    }

    @Override
    public CoinsTX selectById(Long id) {
        return coinsTXMapper.selectById(id);
    }

    @Override
    public void deleteCoinsTX(Long id) {
        coinsTXMapper.deleteCoinsTX(id);
    }
}
