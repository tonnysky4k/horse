package com.yrxc.horse.mapper;

import com.yrxc.horse.entity.CoinsTX;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CoinsTXMapper {

    List<CoinsTX> selectAll();
    List<CoinsTX> selectByName(String uname);
    void insertCoinsTX(CoinsTX ctx);

    CoinsTX selectById(Long id);
    void deleteCoinsTX(Long id);
}
