package com.yrxc.horse.entity;

import java.util.Date;

public class CoinsTX {

    private Long id;
    private String uname;
    private Date tdate;
    private int tsl;
    private String ip;
    private String ttype;

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

    public Date getTdate() {
        return tdate;
    }

    public void setTdate(Date tdate) {
        this.tdate = tdate;
    }

    public int getTsl() {
        return tsl;
    }

    public void setTsl(int tsl) {
        this.tsl = tsl;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getTtype() {
        return ttype;
    }

    public void setTtype(String ttype) {
        this.ttype = ttype;
    }
}
