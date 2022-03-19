package com.yrxc.horse.service.impl;

import com.yrxc.horse.entity.RaceRecord;
import com.yrxc.horse.mapper.RaceRecordMapper;
import com.yrxc.horse.service.RaceRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceRecordServiceImpl implements RaceRecordService {


    @Autowired
    RaceRecordMapper raceRecordMapper;
    @Override
    public List<RaceRecord> selectAll() {
        return raceRecordMapper.selectAll();
    }

    @Override
    public List<RaceRecord> selectByName(String uname) {
        return raceRecordMapper.selectByName(uname);
    }

    @Override
    public void insertRaceRecord(RaceRecord rr) {

        raceRecordMapper.insertRaceRecord(rr);

    }
}
