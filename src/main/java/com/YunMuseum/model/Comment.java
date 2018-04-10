package com.YunMuseum.model;

import java.util.Date;

public class Comment {
    private Integer commentid;

    private Integer userid;

    private String name;

    private String text;

    private Integer type;

    private Integer id;

    private Integer toid;

    private Date time;

    private Byte cread;

    private Byte status;

    public Integer getCommentid() {
        return commentid;
    }

    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
    }

    public Integer getUserid() {
        return userid;
    }

    public String getName(){
        return name;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getID(){
        return id;
    }

    public void setID(Integer id){
        this.id = id;
    }

    public Integer getToid() {
        return toid;
    }

    public void setToid(Integer toid) {
        this.toid = toid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Byte getRead() {
        return cread;
    }

    public void setRead(Byte cread) {
        this.cread = cread;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}