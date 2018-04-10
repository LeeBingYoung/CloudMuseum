package com.YunMuseum.service;

import com.YunMuseum.dao.ArtStoryDao;
import com.YunMuseum.model.ArtStory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * Created by Test Guo on 2017/4/12.
 */
@Service
public class ArtStoryService {
    @Autowired
    ArtStoryDao artStoryDao;
    //获取艺术故事详情
    public List<ArtStory> getArtStory(int stoid){
        return artStoryDao.selectArtStory(stoid);
    }
    //获取全部艺术故事
    public List<ArtStory> getArtStoryAll(){
        return artStoryDao.selectArtStoryAll();
    }
    //获取艺术故事数量
    public int getMaxStory(){
        return artStoryDao.selectMaxStory();
    }
}
