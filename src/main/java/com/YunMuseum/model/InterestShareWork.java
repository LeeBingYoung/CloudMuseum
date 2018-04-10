package com.YunMuseum.model;

import java.util.Date;

public class InterestShareWork {
    private Integer userid;

    private String text;

    private Integer workid;

    private String name;

    private String image;

    private String wtitle;

    private String wimage;

    private Date wtime;

    public Integer getUserid(){
        return userid;
    }

    public void setUserid(int userid){
        this.userid = userid;
    }

    public String getText(){
        return text;
    }

    public void setText(String text){
        this.text = text;
    }

    public Integer getWorkid(){
        return workid;
    }

    public void setWorkid(int workid){
        this.workid = workid;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getImage(){
        return image;
    }

    public void setImage(String image){
        this.image = image;
    }

    public String getWtitle(){
        return wtitle;
    }

    public void setWtitle(String wtitle){
        this.wtitle = wtitle;
    }

    public String getWimage(){
        return wimage;
    }

    public void setWimage(String wimage){
        this.wimage = wimage;
    }

    public Date getWtime(){
        return wtime;
    }

    public void setWtime(Date wtime){
        this.wtime = wtime;
    }
}
