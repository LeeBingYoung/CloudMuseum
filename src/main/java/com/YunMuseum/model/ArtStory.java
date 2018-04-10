package com.YunMuseum.model;

import java.util.Date;

public class ArtStory {
    private Integer stoid;

    private String stitle;

    private Integer totalpage;

    private String image;

    private String syears;

    private String stype;

    private String splace;

    private String sabstract;

    private Date stime;

    private Integer sclick;

    private Integer spraise;

    private Byte status;

    public Integer getStoid() {
        return stoid;
    }

    public void setStoid(Integer stoid) {
        this.stoid = stoid;
    }

    public String getStitle() {
        return stitle;
    }

    public void setStitle(String stitle) {
        this.stitle = stitle;
    }

    public Integer getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(Integer totalpage) {
        this.totalpage = totalpage;
    }

    public String getImage(){
        return image;
    }

    public void setImage(String image){
        this.image = image;
    }

    public String getSyears() {
        return syears;
    }

    public void setSyears(String syears) {
        this.syears = syears;
    }

    public String getStype() {
        return stype;
    }

    public void setStype(String stype) {
        this.stype = stype;
    }

    public String getSplace() {
        return splace;
    }

    public void setSplace(String splace) {
        this.splace = splace;
    }

    public String getSabstract() {
        return sabstract;
    }

    public void setSabstract(String sabstract) {
        this.sabstract = sabstract;
    }

    public Date getStime() {
        return stime;
    }

    public void setStime(Date stime) {
        this.stime = stime;
    }

    public Integer getSclick() {
        return sclick;
    }

    public void setSclick(Integer sclick) {
        this.sclick = sclick;
    }

    public Integer getSpraise() {
        return spraise;
    }

    public void setSpraise(Integer spraise) {
        this.spraise = spraise;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}