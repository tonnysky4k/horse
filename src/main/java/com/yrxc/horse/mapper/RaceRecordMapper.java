package com.yrxc.horse.mapper;

import com.yrxc.horse.entity.RaceRecord;
import com.yrxc.horse.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RaceRecordMapper {

    List<RaceRecord> selectAll();
    List<RaceRecord>  selectByName(String uname);

    void insertRaceRecord(RaceRecord rr);

}
