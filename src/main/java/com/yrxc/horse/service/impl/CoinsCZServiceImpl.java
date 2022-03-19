package com.yrxc.horse.service.impl;


import com.yrxc.horse.entity.CoinsCZ;
import com.yrxc.horse.mapper.CoinsCZMapper;
import com.yrxc.horse.service.CoinsCZService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoinsCZServiceImpl  implements CoinsCZService {


    @Autowired
    CoinsCZMapper coinsCZMapper;
    @Override
    public List<CoinsCZ> selectAll() {
        return coinsCZMapper.selectAll();
    }

    @Override
    public List<CoinsCZ> selectByName(String uname) {
        return coinsCZMapper.selectByName(uname);
    }

    @Override
    public void insertCoinsCZ(CoinsCZ ccz) {
        coinsCZMapper.insertCoinsCZ(ccz);
    }

    @Override
    public CoinsCZ selectById(Long id) {
        return coinsCZMapper.selectById(id);
    }

    @Override
    public void deleteCoinsCZ(Long id) {
        coinsCZMapper.deleteCoinsCZ(id);
    }
}
