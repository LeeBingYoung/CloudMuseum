package com.YunMuseum.model;

public class ArtColImage extends ArtColImageKey{
    private Integer colid;

    private String image;

    private Integer imagepage;

    private Byte status;

    public Integer getColid()
    {
        return colid;
    }

    public void setColID(Integer colid){
        this.colid = colid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getImagePage(){
        return imagepage;
    }

    public void setImagePage(Integer imagepage){
        this.imagepage = imagepage;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}