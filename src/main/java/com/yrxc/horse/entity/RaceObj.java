package com.yrxc.horse.entity;

import java.util.List;

public class RaceObj {

    List<Integer> bls;
    List<Integer> btms;
    String uname;
    int zmbl;

    public void setZmbl(int zmbl){this.zmbl =zmbl;}

    public int getZmbl(){ return zmbl;}

    public List<Integer> getBls() {
        return bls;
    }

    public void setBls(List<Integer> bls) {
        this.bls = bls;
    }

    public List<Integer> getBtms() {
        return btms;
    }

    public void setBtms(List<Integer> btms) {
        this.btms = btms;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    @Override
    public String toString() {
        return "RaceObj{" +
                "bls=" + bls +
                ", btms=" + btms +
                ", uname='" + uname + '\'' +
                '}';
    }
}
