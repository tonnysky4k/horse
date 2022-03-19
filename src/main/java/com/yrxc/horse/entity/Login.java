package com.yrxc.horse.entity;

import java.util.Date;

public class Login {

    private Long id;
    private String uname;
    private Date indate;
    private String ip;
    private String logstat;
    private String scode;
    private String ycode ;

    public String getYcode(){ return ycode;}
    public void setYcode(String ycode){this.ycode =ycode;}

    public String getScode(){ return scode;}

    public void setScode(String scode){this.scode =scode;}

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

    public Date getIndate() {
        return indate;
    }

    public void setIndate(Date indate) {
        this.indate = indate;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getLogstat() {
        return logstat;
    }

    public void setLogstat(String logstat) {
        this.logstat = logstat;
    }


}
