package com.YunMuseum.service;

import com.YunMuseum.dao.PraiseDao;
import com.YunMuseum.model.Praise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * Created by Test Guo on 2017/4/29.
 */
@Service
public class PraiseService {
    @Autowired
    PraiseDao praiseDao;
    //获取艺术品是否点赞
    public List<Praise> getArtWorkPraise(int userid, int workid){
        return praiseDao.selectArtWorkPraise(userid,workid);
    }
    //获取艺术故事是否点赞
    public List<Praise> getArtStoPraise(int userid,int stoid){
        return praiseDao.selectArtStoPraise(userid,stoid);
    }
    //获取艺术专栏是否点赞
    public List<Praise> getArtColPraise(int userid,int colid){
        return praiseDao.selectArtColPraise(userid,colid);
    }
    //更新艺术品为点赞
    public void updateWorkPraiseYes(String classname,int userid,int workid){
        praiseDao.updatePraiseWorkYes(classname,userid,workid);
    }
    //更新艺术品为不点赞
    public void updateWorkPraiseNo(String classname,int userid,int workid){
        praiseDao.updatePraiseWorkNo(classname,userid,workid);
    }
    //更新艺术故事为点赞
    public void updateStoPraiseYes(String classname,int userid,int stoid){
        praiseDao.updatePraiseStoYes(classname,userid,stoid);
    }
    //更新艺术故事为不点赞
    public void updateStoPraiseNo(String classname,int userid,int stoid){
        praiseDao.updatePraiseStoNo(classname,userid,stoid);
    }
    //更新艺术专栏为点赞
    public void updateColPraiseYes(String classname,int userid,int colid){
        praiseDao.updatePraiseColYes(classname,userid,colid);
    }
    //更新艺术专栏为不点赞
    public void updateColPraiseNo(String classname,int userid,int colid){
        praiseDao.updatePraiseColNo(classname,userid,colid);
    }
    //更新新增艺术品点赞为已读
    public void updateWorkPraise(int userid){
        praiseDao.updateWorkPraise(userid);
    }
    //更新新增艺术品点赞为已读
    public void updateColPraise(int userid){
        praiseDao.updateColPraise(userid);
    }
    //新注册用户插入艺术品点赞
    public void insertWorkPraise(int userid, int workid){
        praiseDao.insertWorkPraise(userid,workid);
    }
    //新注册用户插入艺术故事点赞
    public void insertStoPraise(int userid, int stoid){
        praiseDao.insertStoPraise(userid,stoid);
    }
    //新注册用户插入艺术专栏点赞
    public void insertColPraise(int userid, int colid){
        praiseDao.insertColPraise(userid,colid);
    }
    //获取新插入艺术专栏的ID
    public int getNewColID(String ctitle){
        return praiseDao.selectNewColID(ctitle);
    }
    //获取新插入的艺术品的ID
    public int getNewWorkID(String wtitle){
        return praiseDao.selectNewWorkID(wtitle);
    }
}
