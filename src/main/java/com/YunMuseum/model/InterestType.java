package com.YunMuseum.model;

public class InterestType extends InterestTypeKey {
    private Integer userid;

    private Integer type;

    private Float sum;

    private Byte status;

    public Integer getUserid(){
        return userid;
    }

    public void setUserid(Integer userid){
        this.userid = userid;
    }

    public Integer getType(){
        return type;
    }

    public void setType(Integer type){
        this.type = type;
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