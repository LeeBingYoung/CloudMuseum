package com.YunMuseum.model;

import java.util.Date;

public class ShareHomeWork {
    private Integer userid;

    private String text;

    private Integer workid;

    private String wtitle;

    private String wtype;

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

    public String getWtitle(){
        return wtitle;
    }

    public void setWtitle(String wtitle){
        this.wtitle = wtitle;
    }

    public String getWtype(){
        return wtype;
    }

    public void setWtype(String wtype){
        this.wtype = wtype;
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
