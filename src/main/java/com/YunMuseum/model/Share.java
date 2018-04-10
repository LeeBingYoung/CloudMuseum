package com.YunMuseum.model;

public class Share {
    private Integer shareid;

    private Integer userid;

    private String text;

    private Integer answerid;

    private Integer workid;

    private Integer stoid;

    private Integer colid;

    private Byte read;

    private Byte status;

    public Integer getShareid(){
        return shareid;
    }

    public void setShareid(Integer shareid){
        this.shareid = shareid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getAnswerid() {
        return answerid;
    }

    public void setAnswerid(Integer answerid) {
        this.answerid = answerid;
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

    public Byte getRead(){
        return read;
    }

    public void setRead(Byte read){
        this.read = read;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}