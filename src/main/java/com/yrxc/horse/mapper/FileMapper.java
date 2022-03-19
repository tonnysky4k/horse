package com.yrxc.horse.mapper;

import com.yrxc.horse.entity.TFile;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileMapper {

    List<TFile> selectAll();
    List<TFile> selectByName(String uname);

    TFile selectById(Long id);
    void insertFile(TFile file);
    void updateFile(TFile file);
}
