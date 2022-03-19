package com.yrxc.horse.service.impl;

import com.yrxc.horse.entity.TFile;
import com.yrxc.horse.mapper.FileMapper;
import com.yrxc.horse.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    FileMapper fileMapper;
    @Override
    public List<TFile> selectAll() {
        return fileMapper.selectAll();
    }

    @Override
    public List<TFile> selectByName(String uname) {
        return fileMapper.selectByName(uname);
    }

    @Override
    public TFile selectById(Long id) {
        return fileMapper.selectById(id);
    }

    @Override
    public void insertFile(TFile file) {
        fileMapper.insertFile(file);

    }

    @Override
    public void updateFile(TFile file) {
        fileMapper.updateFile(file);
    }
}
