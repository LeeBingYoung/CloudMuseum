package com.YunMuseum.model;

public class ShareWorkView {
    private Integer userid;

    private String text;

    private Integer answerid;

    private Integer workid;

    private String wtitle;

    private String name;

    private Byte read;

    public Integer getUserid(){
        return getUserid();
    }

    public void setUserid(int userid){
        this.userid = userid;
    }

    public String getText(){
        return  text;
    }

    public void setText(String text){
        this.text = text;
    }

    public Integer getAnswerid(){
        return answerid;
    }

    public void setAnswerid(int answerid){
        this.answerid = answerid;
    }

    public Integer getWorkid(){
        return workid;
    }

    public void setWorkid(int workid){
        this.workid = workid;
    }

    public String getWtitle(){
        return wtitle;
    }

    public void setWtitle(String wtitle){
        this.wtitle = wtitle;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Byte getRead(){
        return read;
    }

    public void setRead(Byte read){
        this.read = read;
    }
}
