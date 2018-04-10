package com.YunMuseum.model;

public class Interest {
    private Integer interestid;

    private String typename;

    private String yearsname;

    private String placename;

    private String image;

    public Integer getInterestid(){
        return interestid;
    }

    public void setInterestid(int interestid){
        this.interestid = interestid;
    }

    public String getTypename(){
        return typename;
    }

    public void setTypename(String typename){
        this.typename = typename;
    }

    public String getYearsname(){
        return yearsname;
    }

    public void setYearsname(String yearsname){
        this.yearsname = yearsname;
    }

    public String getPlacename(){
        return placename;
    }

    public void setPlacename(String placename){
        this.placename = placename;
    }

    public String getImage(){
        return image;
    }

    public void setImage(String image){
        this.image = image;
    }
}
