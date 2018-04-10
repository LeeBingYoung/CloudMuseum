package com.YunMuseum.model;

public class ArtColPraise {
    private Integer userid;

    private Integer colid;

    private String ctitle;

    private String name;

    private Byte read;

    public Integer getUserid(){
        return userid;
    }

    public void setUserid(int userid){
        this.userid = userid;
    }

    public Integer getColid(){
        return colid;
    }

    public void setColid(int colid){
        this.colid = colid;
    }

    public String getCtitle(){
        return ctitle;
    }

    public void setCtitle(String ctitle){
        this.ctitle = ctitle;
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
