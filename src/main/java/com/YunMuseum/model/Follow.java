package com.YunMuseum.model;

import java.util.Date;

public class Follow {
    private Integer userid;

    private Integer publisherid;

    private Integer stoid;

    private String classname;

    private Byte read;

    private Byte status;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getPublisherid() {
        return publisherid;
    }

    public void setPublisherid(Integer publisherid) {
        this.publisherid = publisherid;
    }

    public Integer getStoid() {
        return stoid;
    }

    public void setStoid(Integer stoid) {
        this.stoid = stoid;
    }

    public String getClassname(){
        return classname;
    }

    public void setClassname(String classname){
        this.classname = classname;
    }

    public Byte getRead() {
        return read;
    }

    public void setRead(Byte read) {
        this.read = read;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}