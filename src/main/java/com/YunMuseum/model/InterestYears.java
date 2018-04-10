package com.YunMuseum.model;

public class InterestYears extends InterestYearsKey {
    private Integer userid;

    private Integer years;

    private Float sum;

    private Byte status;

    public Integer getUserid(){
        return userid;
    }

    public void setUserid(Integer userid){
        this.userid = userid;
    }

    public Integer getYears(){
        return years;
    }

    public void setYears(Integer years){
        this.years = years;
    }

    public Float getSum() {
        return sum;
    }

    public void setSum(Float sum) {
        this.sum = sum;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}