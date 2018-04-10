package com.YunMuseum.service;

import com.YunMuseum.dao.ShareHomeDao;
import com.YunMuseum.model.ShareHomeCol;
import com.YunMuseum.model.ShareHomeWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Test Guo on 2017/5/10.
 */
@Service
public class ShareHomeService {
    @Autowired
    ShareHomeDao shareHomeDao;
    //获取个人分享的艺术品详情
    public List<ShareHomeWork> getShareHomeWork(int userid){
        return shareHomeDao.selectShareHomeWork(userid);
    }
    //获取个人分享的艺术专栏详情
    public List<ShareHomeCol> getShareHomeCol(int userid){
        return shareHomeDao.selectShareHomeCol(userid);
    }
}
