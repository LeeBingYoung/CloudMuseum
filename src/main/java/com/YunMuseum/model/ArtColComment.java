package com.YunMuseum.model;

import java.util.Date;

public class ArtColComment {
    private Integer userid;

    private String name;

    private String text;

    private Integer id;

    private String ctitle;

    private Date time;

    public Integer getUserid(){
        return userid;
    }

    public void setUserid(int userid){
        this.userid = userid;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getText(){
        return text;
    }

    public void setText(String text){
        this.text = text;
    }

    public Integer getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getCtitle(){
        return ctitle;
    }

    public void setCtitle(String ctitle){
        this.ctitle = ctitle;
    }

    public Date getTime(){
        return time;
    }

    public void setTime(Date time){
        this.time = time;
    }
}
