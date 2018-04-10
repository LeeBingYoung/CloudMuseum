package com.YunMuseum.service;

import com.YunMuseum.dao.ArtWorkPraiseDao;
import com.YunMuseum.model.ArtWorkPraise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * Created by Test Guo on 2017/5/4.
 */
@Service
public class ArtWorkPraiseService {
    @Autowired
    ArtWorkPraiseDao artWorkPraiseDao;
    //获取艺术品新增点赞
    public List<ArtWorkPraise> getArtWorkPraise(int userid){
        return artWorkPraiseDao.selectArtWorkPraise(userid);
    }
}
