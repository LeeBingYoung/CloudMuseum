package com.YunMuseum.model;

public class ArtStoryPage extends ArtStoryPageKey {
    private Integer stoid;

    private Integer page;

    private String image;

    private Byte status;

    private String text;

    public Integer getStoid(){
        return stoid;
    }

    public  void setStoid(Integer stoid){
        this.stoid = stoid;
    }

    public Integer getPage(){
        return page;
    }

    public void setPage(Integer page){
        this.page = page;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}