package com.YunMuseum.model;

import java.util.Date;

public class ArtCol {
    private Integer colid;

    private Integer userid;

    private String ctitle;

    private Integer totalimage;

    private String cyears;

    private String ctype;

    private String cplace;

    private String tag1;

    private String tag2;

    private String tag3;

    private String cabstract;

    private String cimage;

    private Date cctime;

    private Integer cclick;

    private Integer cpraise;

    private String username;

    private Byte status;

    private String ctext;

    public Integer getColid() {
        return colid;
    }

    public void setColid(Integer colid) {
        this.colid = colid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getCtitle() {
        return ctitle;
    }

    public void setCtitle(String ctitle) {
        this.ctitle = ctitle;
    }

    public Integer getTotalimage() {
        return totalimage;
    }

    public void setTotalimage(Integer totalimage) {
        this.totalimage = totalimage;
    }

    public String getCyears() {
        return cyears;
    }

    public void setCyears(String cyears) {
        this.cyears = cyears;
    }

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }

    public String getCplace() {
        return cplace;
    }

    public void setCplace(String cplace) {
        this.cplace = cplace;
    }

    public String getTag1() {
        return tag1;
    }

    public void setTag1(String tag1) {
        this.tag1 = tag1;
    }

    public String getTag2() {
        return tag2;
    }

    public void setTag2(String tag2) {
        this.tag2 = tag2;
    }

    public String getTag3() {
        return tag3;
    }

    public void setTag3(String tag3) {
        this.tag3 = tag3;
    }

    public String getCabstract() {
        return cabstract;
    }

    public void setCabstract(String cabstract) {
        this.cabstract = cabstract;
    }

    public String getCimage() {
        return cimage;
    }

    public void setCimage(String cimage) {
        this.cimage = cimage;
    }

    public Date getCctime() {
        return cctime;
    }

    public void setCctime(Date cctime) {
        this.cctime = cctime;
    }

    public Integer getCclick() {
        return cclick;
    }

    public void setCclick(Integer cclick) {
        this.cclick = cclick;
    }

    public Integer getCpraise() {
        return cpraise;
    }

    public void setCpraise(Integer cpraise) {
        this.cpraise = cpraise;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getCtext() {
        return ctext;
    }

    public void setCtext(String ctext) {
        this.ctext = ctext;
    }
}