package com.YunMuseum.service;

import com.YunMuseum.dao.ArtColPraiseDao;
import com.YunMuseum.model.ArtColPraise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * Created by Test Guo on 2017/5/4.
 */
@Service
public class ArtColPraiseService {
    @Autowired
    ArtColPraiseDao artColPraiseDao;
    //获取艺术专栏新增点赞
    public List<ArtColPraise> getArtColPraise(int userid){
        return artColPraiseDao.selectArtColPraise(userid);
    }
}
