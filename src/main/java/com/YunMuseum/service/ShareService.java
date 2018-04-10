package com.YunMuseum.service;

import com.YunMuseum.dao.ShareDao;
import com.YunMuseum.model.Share;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * Created by Test Guo on 2017/5/1.
 */
@Service
public class ShareService {
    @Autowired
    ShareDao shareDao;
    //插入艺术品分享
    public void insertShareWork(int userid,String text,int answerid,int workid){
        Share share = new Share();
        share.setUserid(userid);
        share.setText(text);
        share.setAnswerid(answerid);
        share.setWorkid(workid);
        shareDao.insertShaerWork(share);
    }
    //插入艺术故事分享
    public void insertShareSto(int userid,String text,int stoid){
        Share share = new Share();
        share.setUserid(userid);
        share.setText(text);
        share.setStoid(stoid);
        shareDao.insertShaerSto(share);
    }
    //插入艺术专栏分享
    public void insertShareCol(int userid,String text,int answerid,int colid){
        Share share = new Share();
        share.setUserid(userid);
        share.setText(text);
        share.setAnswerid(answerid);
        share.setColid(colid);
        shareDao.insertShaerCol(share);
    }
    //更新新增分享为已读
    public void updateShare(int answerid){
        shareDao.updateShare(answerid);
    }
}
