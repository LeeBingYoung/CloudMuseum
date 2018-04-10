package com.YunMuseum.model;

public class Club {
    private Integer clubid;

    private String clubname;

    private String clubimage;

    private String cluba;

    private String clubw;

    private String clubcy;

    private String clubhd;

    private String clubt;

    private Byte status;

    public Integer getClubid() {
        return clubid;
    }

    public void setClubid(Integer clubid) {
        this.clubid = clubid;
    }

    public String getClubname() {
        return clubname;
    }

    public String getClubimage(){
        return clubimage;
    }

    public String getCluba(){
        return cluba;
    }

    public String getClubw(){
        return clubw;
    }

    public String getClubcy(){
        return clubcy;
    }

    public String getClubhd(){
        return clubhd;
    }

    public String getClubt(){
        return clubt;
    }

    public void setClubname(String clubname) {
        this.clubname = clubname;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}