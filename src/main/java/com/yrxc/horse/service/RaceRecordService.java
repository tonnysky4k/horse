package com.yrxc.horse.service;

import com.yrxc.horse.entity.RaceRecord;

import java.util.List;

public interface RaceRecordService {

    List<RaceRecord> selectAll();
    List<RaceRecord>  selectByName(String uname);

    void insertRaceRecord(RaceRecord rr);
}
