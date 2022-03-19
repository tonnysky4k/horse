package com.yrxc.horse.util;

import com.yrxc.horse.entity.RaceData;

import java.util.*;
import java.util.concurrent.BlockingDeque;

public class RunHorse {

    private RaceData raceData;
    List<String> marks;// 跑马编号 1-6 1-5 等
    List<Integer> bls;   //赢率 3 ，4,5,10 ，20
    List<Integer> index =new ArrayList<>(); //随机 倍率抽取
    Random rand =new Random();//随机数
    int  rz_bl;//中马倍率 ，中马编号索引
    int zm_typ1=0,zm_typ2=0,zm_typ3=0;// 中马类型 type1:3,4,5  typ2:8,10,20  type3:其他
    int zm_co1=0,zm_co2=0;//类型的次数统计，co1 中马类型1 次数统计，co2 中马次数2 统计；

    public RaceData generatRace()
    {
        if(raceData == null)
            raceData =new RaceData();
        init();
         raceData.setBl_list(new ArrayList<>());
         raceData.setBtm_list(new ArrayList<>());
         while (index.size()<15)
         {
            Integer i= rand.nextInt(15);
            if(!index.contains(i))
             index.add(i);
         }
        List<Integer> bl =raceData.getBl_list();
        for(int i =0;i<index.size();i++)
            bl.add(bls.get(index.get(i)));
        rz_bl =rand_zm();
        int ind= bl.indexOf(rz_bl);
        raceData.setBl_list(bl);
        raceData.setMark_list(marks);
        raceData.setIndex(ind);
        index.clear();

        return raceData;
    }
    private int rand_zm()
    {
      int k=rand.nextInt(100);
      int t=rand.nextInt(10);
        // type 1:3,4,5
      if(k>=0 & k< 68 - zm_typ1)
      {
          if(t>=0 & t<4)
              rz_bl =3;
          if(t>=4 & t<7)
              rz_bl =4;
          if(t>=7 & t<10)
              rz_bl =5;
          zm_co1 ++;
          if(zm_co1>2)
          {
              zm_typ1 +=5;
              zm_typ2 +=3;
              zm_typ3 +=1;
              zm_co1 =0;
          }
      }
      //type2: 8,10,20
      if(k>= 68 - zm_typ1 & k<91 - zm_typ2)
      {
          if(t>=0 & t<4)
              rz_bl =8;
          if(t>=4 & t<7)
              rz_bl= 10;
          if(t>=7 & t<10)
              rz_bl =20;
          zm_co2++;
          if(zm_co2>1)
          {
              zm_typ2 =0;
              zm_typ3 =0;
              zm_co2=0;
          }
          zm_typ1 =0;
      }
      // type3:30 ,60 ,80
      if(k>=91 - zm_typ2 & k<96 -zm_typ3)
      {
          if(t>=0 & t<4)
              rz_bl=30;
          if(t>=4 & t<7)
              rz_bl=60;
          if(t>=7 & t<10)
              rz_bl=80;
          zm_typ3 =0;
          zm_typ2 =0;
          zm_typ1=0;
          zm_co2 =0;
          zm_co1=0;
      }// type4:100,125,175
      if(k>= 96 -zm_typ3 & k<99)
      {
          if(t>=0 & t<4)
              rz_bl=100;
          if(t>=4 & t<7)
              rz_bl=125;
          if(t>=7 & t<10)
              rz_bl=175;
          zm_typ3=0;
          zm_typ2=0;
          zm_typ1=0;
          zm_co1=0;
          zm_co2=0;
      }// type 5:250 ,500 ,1000
        if(k==99)
        {
            if(t>=0 & t<6)
                rz_bl=250;
            if(t>=6 & t<8)
                rz_bl=500;
            if(t==9)
                rz_bl=1000;
            zm_typ3=0;
            zm_typ2=0;
            zm_typ1=0;
            zm_co1=0;
            zm_co2=0;
        }
        return rz_bl;
    }
    void init()
    {
        if(bls == null)
            bls = new ArrayList<>();
        bls.clear();
        bls.add(3);
        bls.add(4);
        bls.add(5);
        bls.add(8);
        bls.add(10);

        bls.add(20);
        bls.add(30);
        bls.add(60);
        bls.add(80);
        bls.add(100);

        bls.add(125);
        bls.add(175);
        bls.add(250);
        bls.add(500);
        bls.add(1000);

        if(marks == null)
            marks = new ArrayList<>();
        marks.clear();
        marks.add("1-6");
        marks.add("1-5");
        marks.add("1-4");
        marks.add("1-3");
        marks.add("1-2");
        marks.add("2-6");
        marks.add("2-5");
        marks.add("2-4");
        marks.add("2-3");
        marks.add("3-6");
        marks.add("3-5");
        marks.add("3-4");
        marks.add("4-6");
        marks.add("4-5");
        marks.add("5-6");
    }

}
