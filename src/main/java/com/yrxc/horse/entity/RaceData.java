package com.yrxc.horse.entity;

import java.util.Date;
import java.util.List;
import java.util.Queue;

public class RaceData {

    List<Integer> bl_list;
    List<Integer> btm_list;
    List<String> mark_list;

    Queue<String> his_mark;
    Queue<Integer>his_bl;
    String uname;
    Date g_date;
    int index;
    Long win_bl;
    Long win_btm;

    public Queue<Integer> getHis_bl() {
        return his_bl;
    }
    public int getIndex(){return index;}
    public void setIndex(int index){this.index =index;}
    public void setHis_bl(Queue<Integer> his_bl) {
        this.his_bl = his_bl;
    }

    public Queue<String> getHis_mark() {
        return his_mark;
    }

    public void setHis_mark(Queue<String> his_list) {
        this.his_mark = his_list;
    }

    public List<Integer> getBl_list() {
        return bl_list;
    }

    public void setBl_list(List<Integer> bl_list) {
        this.bl_list = bl_list;
    }

    public List<Integer> getBtm_list() {
        return btm_list;
    }

    public void setBtm_list(List<Integer> btm_list) {
        this.btm_list = btm_list;
    }

    public List<String> getMark_list() {
        return mark_list;
    }

    public void setMark_list(List<String> mark_list) {
        this.mark_list = mark_list;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Date getG_date() {
        return g_date;
    }

    public void setG_date(Date g_date) {
        this.g_date = g_date;
    }

    public Long getWin_bl() {
        return win_bl;
    }

    public void setWin_bl(Long win_bl) {
        this.win_bl = win_bl;
    }

    public Long getWin_btm() {
        return win_btm;
    }

    public void setWin_btm(Long win_btm) {
        this.win_btm = win_btm;
    }
}
