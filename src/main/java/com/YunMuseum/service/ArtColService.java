package com.YunMuseum.service;

import com.YunMuseum.dao.ArtColumnDao;
import com.YunMuseum.model.ArtCol;
import com.YunMuseum.model.ArtColImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
/**
 * Created by zx G on 2017/4/5.
 */
@Service
public class ArtColService {
    @Autowired
    ArtColumnDao artColumnDao;
    //获取艺术专栏详情
    public List<ArtCol> getArtCol(int colid){
        return artColumnDao.selectArtCol(colid);
    }
    //获取艺术专栏文章
    public List<ArtCol> getArtColText(int colid){
        return artColumnDao.selectArtColText(colid);
    }
    //获取全部艺术专栏
    public List<ArtCol> getArtColAll(){
        return artColumnDao.selectArtColAll();
    }
    //获取艺术专栏发布者ID
    public int getArtColUserID(int colid){
        return artColumnDao.selectArtColUserID(colid);
    }
    //获取我关注的艺术专栏
    public List<ArtCol> getArtColFollow(int userid){
        return artColumnDao.selectArtColFollow(userid);
    }
    //获取我喜欢的艺术专栏
    public List<ArtCol> getArtColPraise(int userid){
        return artColumnDao.selectArtColPraise(userid);
    }
    //上传艺术专栏
    public void insertCol(int userid, String username, String name, String type, String place, String year, String path, String text){
        ArtCol artcol = new ArtCol();
        artcol.setUserid(userid);
        artcol.setCtitle(name);
        artcol.setCtype(type);
        artcol.setCimage(path);
        artcol.setCplace(place);
        artcol.setCyears(year);
        artcol.setCtext(text);
        artcol.setUsername(username);
        artColumnDao.InsertColumn(artcol);
    }
    //上传艺术专栏图片
    public void insertCImage(int colid, int imagepage, String path){
        ArtColImage artColImage=new ArtColImage();
        artColImage.setColID(colid);
        artColImage.setImagePage(imagepage);
        artColImage.setImage(path);
        artColumnDao.InsertColImg(artColImage);
    }
    //获取个人发布的艺术专栏
    public List<ArtCol> getArtColPerson(int userid){
        return artColumnDao.selectArtColPerson(userid);
    }
    //获取艺术专栏的数量
    public int getMaxCol(){
        return artColumnDao.selectMaxCol();
    }
    //获取艺术专栏推荐
    public List<ArtCol> getArtColCommend(){
        return artColumnDao.selectArtColCommend();
    }
    //更新艺术专栏图片
    public int updateArtColImage(String cimage, int colid){
        return artColumnDao.updateArtColImage(cimage,colid);
    }
}
