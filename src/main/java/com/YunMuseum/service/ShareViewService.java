package com.YunMuseum.service;

import com.YunMuseum.dao.ShareViewDao;
import com.YunMuseum.model.ShareColView;
import com.YunMuseum.model.ShareWorkView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * Created by Test Guo on 2017/5/4.
 */
@Service
public class ShareViewService {
    @Autowired
    ShareViewDao shareViewDao;
    //获取发布者看到的艺术品新增转发
    public List<ShareWorkView> getArtWorkSharePublisher(int userid){
        return shareViewDao.selectArtWorkSharePublisher(userid);
    }
    //获取发布者看到的艺术专栏新增转发
    public List<ShareColView> getArtColSharePublisher(int userid){
        return shareViewDao.selectArtColSharePublisher(userid);
    }
}
