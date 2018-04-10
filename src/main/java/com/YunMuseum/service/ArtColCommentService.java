package com.YunMuseum.service;

import com.YunMuseum.dao.ArtColCommentDao;
import com.YunMuseum.model.ArtColComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * Created by Test Guo on 2017/5/4.
 */
@Service
public class ArtColCommentService {
    @Autowired
    ArtColCommentDao artColCommentDao;
    //获取艺术专栏评论是否已读
    public List<ArtColComment> getArtColCommentRead(int userid){
        return artColCommentDao.selectArtColCommentRead(userid);
    }
}
