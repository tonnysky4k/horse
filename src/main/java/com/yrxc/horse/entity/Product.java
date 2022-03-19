package com.yrxc.horse.entity;

public class Product {

    private String img;
    private String txt;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    @Override
    public String toString() {
        return "{" +
                "img='" + img + '\'' +
                ", txt='" + txt + '\'' +
                '}';
    }
}
