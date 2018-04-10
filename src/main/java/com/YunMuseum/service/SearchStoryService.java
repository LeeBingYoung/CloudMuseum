package com.YunMuseum.service;

import com.YunMuseum.dao.SearchStoryDao;
import com.YunMuseum.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * Created by lby on 2017/5/14.
 */
@Service
public class SearchStoryService {
    @Autowired
    SearchStoryDao  searchStoryDao;
    //获取艺术故事标题相似
    public List<ArtStory> getArtStorySTitle(String search){
        return searchStoryDao.selectArtStorySTitle(search);
    }
    //获取艺术故事年代相似
    public List<ArtStory> getArtStorySYears(String search){
        return searchStoryDao.selectArtStorySYears(search);
    }
    //获取艺术故事类型相似
    public List<ArtStory> getArtStorySType(String search){
        return searchStoryDao.selectArtStorySType(search);
    }
    //获取艺术故事地点相似
    public List<ArtStory> getArtStorySPlace(String search){
        return searchStoryDao.selectArtStorySPlace(search);
    }
    //获取艺术故事摘要相似
    public List<ArtStory> getArtStorySAbstract(String search){
        return searchStoryDao.selectArtStorySAbstract(search);
    }
    //获取艺术故事期号相似
    public List<ArtStory> getArtStoryNo(String search){
        return searchStoryDao.selectArtStoryNo(search);
    }
    //获取艺术故事系列相似
    public List<ArtStory> getArtStorySeries(String search){
        return searchStoryDao.selectArtStorySeries(search);
    }
}
