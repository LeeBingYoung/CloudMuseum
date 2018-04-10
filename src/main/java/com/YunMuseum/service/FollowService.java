package com.YunMuseum.service;

import com.YunMuseum.dao.FollowDao;
import com.YunMuseum.model.Follow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * Created by Test Guo on 2017/4/30.
 */
@Service
public class FollowService {
    @Autowired
    FollowDao followDao;
    //获取艺术品用户是否关注
    public List<Follow> getArtWorkFollow(int userid,int workid){
        return followDao.selectArtWorkFollow(userid,workid);
    }
    //获取艺术故事是否关注
    public List<Follow> getArtStoFollow(int userid,int stoid){
        return followDao.selectArtStoFollow(userid,stoid);
    }
    //获取艺术专栏用户是否关注
    public List<Follow> getArtColFollow(int userid,int colid){
        return followDao.selectArtColFollow(userid,colid);
    }
    //更新艺术品用户为关注
    public void updateFollowWorkYes(String classname,int userid,int workid){
        followDao.updateFollowWorkYes(classname,userid,workid);
    }
    //更新艺术品用户为不关注
    public void updateFollowWorkNo(String classname,int userid,int workid){
        followDao.updateFollowWorkNo(classname,userid,workid);
    }
    //更新艺术故事为关注
    public void updateFollowStoYes(String classname,int userid,int stoid){
        followDao.updateFollowStoYes(classname,userid,stoid);
    }
    //更新艺术故事为不关注
    public void updateFollowStoNo(String classname,int userid,int stoid){
        followDao.updateFollowStoNo(classname,userid,stoid);
    }
    //更新艺术专栏为关注
    public void updateFollowColYes(String classname,int userid,int colid){
        followDao.updateFollowColYes(classname,userid,colid);
    }
    //更新艺术专栏为不关注
    public void updateFollowColNo(String classname,int userid,int colid){
        followDao.updateFollowColNo(classname,userid,colid);
    }
    //更新新增关注为已读
    public void updateFollow(int publisherid){
        followDao.updateFollow(publisherid);
    }
    //新注册用户插入用户关注
    public void insertUserFollow(int userid, int publisherid){
        followDao.insertUserFollow(userid,publisherid);
    }
    //新注册用户插入艺术故事关注
    public void insertStoFollow(int userid, int stoid){
        followDao.insertStoFollow(userid,stoid);
    }
}
