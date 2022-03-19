package com.yrxc.horse.entity;

import java.util.Date;

public class User {
    private Long id;
    private String uname;
    private String regip;
    private Date regdate;
    private String ycode;
    private int coins;

    public int getCoins(){ return coins;}

    public void setCoins(int coins){this.coins =coins;}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getRegip() {
        return regip;
    }

    public void setRegip(String regip) {
        this.regip = regip;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public String getYcode() {
        return ycode;
    }

    public void setYcode(String ycode) {
        this.ycode = ycode;
    }
}
