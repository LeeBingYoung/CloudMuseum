package com.YunMuseum.model;

import java.util.Date;

public class ShareHomeCol {
    private Integer userid;

    private String text;

    private Integer colid;

    private String ctitle;

    private String ctype;

    private String cimage;

    private Date cctime;

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

    public String getCtype(){
        return ctype;
    }

    public void setCtype(String ctype){
        this.ctype = ctype;
    }

    public String getCimage(){
        return cimage;
    }

    public void setCimage(String cimage){
        this.cimage = cimage;
    }

    public Date getCctime(){
        return cctime;
    }

    public void setCctime(Date cctime){
        this.cctime = cctime;
    }
}
