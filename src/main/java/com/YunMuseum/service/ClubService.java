package com.YunMuseum.service;

import com.YunMuseum.dao.ClubDao;
import com.YunMuseum.dao.UserDao;
import com.YunMuseum.model.Club;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * Created by Test Guo on 2017/4/10.
 */
@Service
public class ClubService {
    @Autowired
    ClubDao clubDao;
    @Autowired
    UserDao userDao;
    //获取个人加入的兴趣圈类别
    public List<Club> getClubPersonType(String username){
        return clubDao.selectClubPersonType(username);
    }
    //获取个人未加入的兴趣圈类别
    public List<Club> getClubPersonNotType(String username){
        return clubDao.selectClubPersonNotType(username);
    }
    //获取个人加入的兴趣圈年代
    public List<Club> getClubPersonYears(String username){
        return clubDao.selectClubPersonYears(username);
    }
    //获取个人未加入的兴趣圈年代
    public List<Club> getClubPersonNotYears(String username){
        return clubDao.selectClubPersonNotYears(username);
    }
    //获取个人加入的兴趣圈地点
    public List<Club> getClubPersonPlace(String username){
        return clubDao.selectClubPersonPlace(username);
    }
    //获取个人未加入的兴趣圈地点
    public List<Club> getClubPersonNotPlace(String username){
        return clubDao.selectClubPersonNotPlace(username);
    }
    //获取用户ID
    public int selectClubUserID(String username){
        return userDao.selectClubUserID(username);
    }
}