package com.YunMuseum.model;

public class ArtWorkPraise {
    private Integer userid;

    private Integer workid;

    private String wtitle;

    private String name;

    private Byte read;

    public Integer getUserid(){
        return userid;
    }

    public void setUserid(int userid){
        this.userid = userid;
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
