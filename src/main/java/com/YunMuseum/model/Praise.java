package com.YunMuseum.model;

import java.util.Date;

public class Praise {
    private Integer userid;

    private Integer workid;

    private Integer stoid;

    private Integer colid;

    private String classname;

    private Byte read;

    private Byte status;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getWorkid() {
        return workid;
    }

    public void setWorkid(Integer workid) {
        this.workid = workid;
    }

    public Integer getStoid() {
        return stoid;
    }

    public void setStoid(Integer stoid) {
        this.stoid = stoid;
    }

    public Integer getColid() {
        return colid;
    }

    public void setColid(Integer colid) {
        this.colid = colid;
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