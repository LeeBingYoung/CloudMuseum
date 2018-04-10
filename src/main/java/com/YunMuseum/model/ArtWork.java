package com.YunMuseum.model;

import java.util.Date;

public class ArtWork {
    private Integer workid;

    private Integer userid;

    private String wtitle;

    private String wyears;

    private String wartist;

    private String wcollector;

    private String wtype;

    private String wplace;

    private String wtext;

    private String wimage;

    private Date wtime;

    private Integer wclick;

    private Integer wpraise;

    private Integer wlength;

    private Integer wwidth;

    private Integer wheight;

    private Byte status;

    public Integer getWorkid() {
        return workid;
    }

    public void setWorkid(Integer workid) {
        this.workid = workid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getWtitle() {
        return wtitle;
    }

    public void setWtitle(String wtitle) {
        this.wtitle = wtitle;
    }

    public String getWyears() {
        return wyears;
    }

    public void setWyears(String wyears) {
        this.wyears = wyears;
    }

    public String getWartist() {
        return wartist;
    }

    public void setWartist(String wartist) {
        this.wartist = wartist;
    }

    public String getWcollector() {
        return wcollector;
    }

    public void setWcollector(String wcollector) {
        this.wcollector = wcollector;
    }

    public String getWtype() {
        return wtype;
    }

    public void setWtype(String wtype) {
        this.wtype = wtype;
    }

    public String getWplace() {
        return wplace;
    }

    public void setWplace(String wplace) {
        this.wplace = wplace;
    }

    public String getWtext() {
        return wtext;
    }

    public void setWtext(String wtext) {
        this.wtext = wtext;
    }

    public String getWimage() {
        return wimage;
    }

    public void setWimage(String wimage) {
        this.wimage = wimage;
    }

    public Date getWtime() {
        return wtime;
    }

    public void setWtime(Date wtime) {
        this.wtime = wtime;
    }

    public Integer getWclick() {
        return wclick;
    }

    public void setWclick(Integer wclick) {
        this.wclick = wclick;
    }

    public Integer getWpraise() {
        return wpraise;
    }

    public void setWpraise(Integer wpraise) {
        this.wpraise = wpraise;
    }

    public Integer getWlength() {
        return wlength;
    }

    public void setWlength(Integer wlength) {
        this.wlength = wlength;
    }

    public Integer getWwidth() {
        return wwidth;
    }

    public void setWwidth(Integer wwidth) {
        this.wwidth = wwidth;
    }

    public Integer getWheight() {
        return wheight;
    }

    public void setWheight(Integer wheight) {
        this.wheight = wheight;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}