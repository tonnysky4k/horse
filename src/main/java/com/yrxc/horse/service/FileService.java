package com.yrxc.horse.service;

import com.yrxc.horse.entity.TFile;

import java.util.List;

public interface FileService {

    List<TFile> selectAll();
    List<TFile> selectByName(String uname);

    TFile selectById(Long id);
    void insertFile(TFile file);
    void updateFile(TFile file);
}
