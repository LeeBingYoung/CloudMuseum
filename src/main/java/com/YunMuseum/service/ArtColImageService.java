package com.YunMuseum.service;

import com.YunMuseum.dao.ArtColImageDao;
import com.YunMuseum.model.ArtColImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * Created by zx G on 2017/4/5.
 */
@Service
public class ArtColImageService {
    @Autowired
    ArtColImageDao artColImageDao;
    //获取艺术专栏图片
    public List<ArtColImage> getArtColImage(int colid){
        return artColImageDao.selectArtColImage(colid);
    }
    //获取艺术专栏放大图片
    public List<ArtColImage> getArtColLarge(int colid){
        return artColImageDao.selectArtColImageLarge(colid);
    }
}
