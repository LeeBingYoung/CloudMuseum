package com.YunMuseum.service;

import com.YunMuseum.dao.CommentDao;
import com.YunMuseum.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * Created by zx G on 2017/4/9.
 */
@Service
public class CommentService {
    @Autowired
    CommentDao commentDao;
    //获取艺术品评论
    public List<Comment> getArtWorkComment(int workid){
        return commentDao.selectArtWorkComment(workid);
    }
    //获取艺术故事评论
    public List<Comment> getArtStoryComment(int stoid){
        return commentDao.selectArtStoComment(stoid);
    }
    //获取艺术专栏评论
    public List<Comment> getArtColComment(int colid){
        return commentDao.selectArtColComment(colid);
    }
    //发送艺术品评论
    public void insertArtWorkComment(int userid,String text,int workid){
        Comment comment = new Comment();
        comment.setUserid(userid);
        comment.setText(text);
        comment.setID(workid);
        commentDao.insertArtWorkComment(comment);
    }
    //发送艺术故事评论
    public void insertArtStoryComment(int userid,String text,int stoid){
        Comment comment = new Comment();
        comment.setUserid(userid);
        comment.setText(text);
        comment.setID(stoid);
        commentDao.insertArtStoryComment(comment);
    }
    //发送艺术专栏评论
    public void insertArtColComment(int userid,String text,int colid){
        Comment comment = new Comment();
        comment.setUserid(userid);
        comment.setText(text);
        comment.setID(colid);
        commentDao.insertArtColComment(comment);
    }
    //更新评论用户名称
    public void updateComment(int userid){
        commentDao.updateComment(userid);
    }
    //更新艺术品评论为已读
    public void updateArtWorkComment(int userid){
        commentDao.updateArtWorkComment(userid);
    }
    //更新艺术专栏评论为已读
    public void updateArtColComment(int userid){
        commentDao.updateArtColComment(userid);
    }
    //获取兴趣圈分享作品评论
    public List<Comment> getInterestWorkComment(int id){
        return commentDao.selectInterestWorkComment(id);
    }
}
