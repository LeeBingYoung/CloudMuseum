package com.YunMuseum.service;

import com.YunMuseum.dao.ArtWorkCommentDao;
import com.YunMuseum.model.ArtWorkComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * Created by Test Guo on 2017/5/4.
 */
@Service
public class ArtWorkCommentService {
    @Autowired
    ArtWorkCommentDao artWorkCommentDao;
    //获取艺术品评论是否已读
    public List<ArtWorkComment> getArtWorkCommentRead(int userid){
        return artWorkCommentDao.selectArtWorkCommentRead(userid);
    }
}
