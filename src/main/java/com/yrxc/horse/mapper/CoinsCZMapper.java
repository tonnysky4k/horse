package com.yrxc.horse.mapper;

import com.yrxc.horse.entity.CoinsCZ;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CoinsCZMapper {

    List<CoinsCZ> selectAll();
    List<CoinsCZ> selectByName(String uname);
    CoinsCZ selectById(Long id);

    void insertCoinsCZ(CoinsCZ ccz);

    void deleteCoinsCZ(Long id);
}
