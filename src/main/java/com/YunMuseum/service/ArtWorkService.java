package com.YunMuseum.service;

import com.YunMuseum.dao.ArtWorkDao;
import com.YunMuseum.model.ArtWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CookieValue;

import java.util.List;
/**
 * Created by zx G on 2017/4/4.
 */
@Service
public class ArtWorkService {
    @Autowired
    ArtWorkDao artWorkDao;
    //获取艺术品详情
    public List<ArtWork> getArtWork(int workid){
        return artWorkDao.selectArtWork(workid);
    }
    //获取全部艺术品
    public List<ArtWork> getArtWorkAll(){
        return artWorkDao.selectArtWorkAll();
    }
    //获取艺术品放大图片
    public List<ArtWork> getArtWorkLarge(int workid){
        return artWorkDao.selectArtWorkLarge(workid);
    }
    //获取艺术品发布者UserID
    public int getArtWorkUserID(int workid){
        return artWorkDao.selectArtWorkUserID(workid);
    }
    //获取发布的艺术品详情方比删除
    public List<ArtWork> getArtWorkDeatils(int userid){
        return artWorkDao.selectArtWorkDetails(userid);
    }
    //删除发布的艺术品
    public void updateArtWorkDetails(int workid,int userid){
        artWorkDao.updateArtWorkDetails(workid,userid);
    }
    //获取我关注的艺术品
    public List<ArtWork> getArtWorkFollow(int userid){
        return artWorkDao.selectArtWorkFollow(userid);
    }
    //获取我喜欢的艺术品
    public List<ArtWork> getArtWorkPraise(int userid){
        return artWorkDao.selectArtWorkPraise(userid);
    }
    //获取个人发布的艺术品
    public List<ArtWork> getArtWorkPerson(int userid){
        return artWorkDao.selectArtWorkPerson(userid);
    }
    //更新个人发布的艺术品
    public void uploadWork(int userid, String Wtitle, String WYears, String WType, String Wtext, String wimage){
        ArtWork artwork=new ArtWork();
        artwork.setUserid(userid);
        artwork.setWtitle(Wtitle);
        artwork.setWyears(WYears);
        artwork.setWtype(WType);
        artwork.setWtext(Wtext);
        artwork.setWimage(wimage);
        artWorkDao.uploadWork(artwork);
    }
    //获取艺术品数量
    public int getMaxWork(){
        return artWorkDao.selectMaxWork();
    }
    //获取艺术品年代推荐
    public List<ArtWork> getArtWorkCommendYears(String wyears){
        return artWorkDao.selectArtWorkCommendYears(wyears);
    }
    //获取艺术品类别推荐
    public List<ArtWork> getArtWorkCommendType(String wtype){
        return artWorkDao.selectArtWorkCommendType(wtype);
    }
    //获取首页艺术品类别
    public List<ArtWork> getArtWorkType(String wtype){
        return artWorkDao.selectArtWorkType(wtype);
    }
    //获取首页艺术品年代
    public List<ArtWork> getArtWorkYears(String wyears){
        return artWorkDao.selectArtWorkYears(wyears);
    }
}
