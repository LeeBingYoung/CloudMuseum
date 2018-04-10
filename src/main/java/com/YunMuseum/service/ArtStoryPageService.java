package com.YunMuseum.service;

import com.YunMuseum.dao.ArtStoryPageDao;
import com.YunMuseum.model.ArtStoryPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * Created by Test Guo on 2017/4/12.
 */
@Service
public class ArtStoryPageService {
    @Autowired
    ArtStoryPageDao artStoryPageDao;
    //获取艺术故事第一张轮播图
    public List<ArtStoryPage> getArtStoryFirstPage(int stoid){
        return artStoryPageDao.selectFirstArtStoPage(stoid);
    }
    //获取艺术故事其余轮播图
    public List<ArtStoryPage> getArtStoryPage(int stoid){
        return artStoryPageDao.selectArtStoPage(stoid);
    }
    //获取艺术故事放大图片
    public List<ArtStoryPage> getArtStoryLarge(int stoid){
        return artStoryPageDao.selectArtStoryLarge(stoid);
    }
}
