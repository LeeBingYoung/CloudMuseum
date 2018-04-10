package com.YunMuseum.service;

import com.YunMuseum.dao.MessageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * Created by zx G on 2017/5/11.
 */
@Service
public class MessageService {
    @Autowired
    MessageDao messageDao;
    //获取艺术品未读评论总数
    public int getCountCommentWork(int userid){
        return messageDao.selectCountCommentWork(userid);
    }
    //获取艺术专栏未读评论总数
    public int getCountCommentCol(int userid){
        return messageDao.selectCountCommentCol(userid);
    }
    //获取艺术品未读点赞总数
    public int getCountPraiseWork(int userid){
        return messageDao.selectCountPraiseWork(userid);
    }
    //获取艺术专栏未读点赞总数
    public int getCountPraiseCol(int userid){
        return messageDao.selectCountPraiseCol(userid);
    }
    //获取未读关注总数
    public int getCountFollow(int publisherid){
        return messageDao.selectCountFollow(publisherid);
    }
    //获取未读分享总数
    public int getCountShare(int answerid){
        return messageDao.selectCountShare(answerid);
    }
}
