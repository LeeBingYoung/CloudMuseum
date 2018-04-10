package com.YunMuseum.service;

import com.YunMuseum.dao.SearchWorkDao;
import com.YunMuseum.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * Created by lby on 2017/5/14.
 */
@Service
public class SearchWorkService {
    @Autowired
    SearchWorkDao searchWorkDao;
    //获取艺术品上传者相似
    public List<ArtWork> getArtWorkWName(String search){
        return searchWorkDao.selectArtWorkWName(search);
    }
    //获取艺术品标题相似
    public List<ArtWork> getArtWorkWTitle(String search){
        return searchWorkDao.selectArtWorkWTitle(search);
    }
    //获取艺术品年代相似
    public List<ArtWork> getArtWorkWYears(String search){ return searchWorkDao.selectArtWorkWYears(search); }
    //获取艺术品原作者相似
    public List<ArtWork> getArtWorkWArtist(String search){ return searchWorkDao.selectArtWorkWArtist(search); }
    //获取艺术品所有者相似
    public List<ArtWork> getArtWorkWCollector(String search){
        return searchWorkDao.selectArtWorkWCollector(search);
    }
    //获取艺术品类型相似
    public List<ArtWork> getArtWorkWType(String search){
        return searchWorkDao.selectArtWorkWType(search);
    }
    //获取艺术品地点相似
    public List<ArtWork> getArtWorkWPlace(String search){
        return searchWorkDao.selectArtWorkWPlace(search);
    }
    //获取艺术品简介相似
    public List<ArtWork> getArtWorkWText(String search){
        return searchWorkDao.selectArtWorkWText(search);
    }
    /*//获取艺术品上传时间相似
    public List<ArtWork> getArtWorkWTime(String search){
        return searchWorkDao.selectArtWorkWTime(search);
    }*/
}
