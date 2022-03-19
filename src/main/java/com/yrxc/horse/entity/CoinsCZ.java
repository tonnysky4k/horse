package com.yrxc.horse.entity;

import java.io.Serializable;
import java.util.Date;

public class CoinsCZ implements Serializable {

    private Long id;
    private String uname;
    private Integer czs;
    private Date cdate;
    private String ip;
    private String cztype;

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

    public Integer getCzs() {
        return czs;
    }

    public void setCzs(Integer czs) {
        this.czs = czs;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCztype() {
        return cztype;
    }

    public void setCztype(String cztype) {
        this.cztype = cztype;
    }
}
