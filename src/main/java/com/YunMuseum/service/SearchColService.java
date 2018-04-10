package com.YunMuseum.service;

import com.YunMuseum.dao.SearchColDao;
import com.YunMuseum.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * Created by lby on 2017/5/14.
 */
@Service
public class SearchColService {
    @Autowired
    SearchColDao  searchColDao;
    //获取艺术专栏标题相似
    public List<ArtCol> getArtColCTitle(String search){
        return searchColDao.selectArtColCTitle(search);
    }
    //获取艺术专栏年代相似
    public List<ArtCol> getArtColCYears(String search){
        return searchColDao.selectArtColCYears(search);
    }
    //获取艺术专栏类型相似
    public List<ArtCol> getArtColCType(String search){
        return searchColDao.selectArtColCType(search);
    }
    //获取艺术专栏地点相似
    public List<ArtCol> getArtColCPlace(String search){
        return searchColDao.selectArtColCPlace(search);
    }
    //获取艺术专栏摘要相似
    public List<ArtCol> getArtColCAbstract(String search){
        return searchColDao.selectArtColCAbstract(search);
    }
    //获取艺术专栏全文相似
    public List<ArtCol> getArtColCText(String search){
        return searchColDao.selectArtColCText(search);
    }
    //获取艺术专栏作者相似
    public List<ArtCol> getArtColUserName(String search){
        return searchColDao.selectArtColUserName(search);
    }
}
