package com.YunMuseum.service;

import com.YunMuseum.dao.InterestYearsDao;
import com.YunMuseum.model.InterestYears;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InterestYearsService {
    @Autowired
    InterestYearsDao interestYearsDao;
    //插入兴趣年代表
    public void insertInterestYears(int userid,int years){
        InterestYears interestYears = new InterestYears();
        interestYears.setUserid(userid);
        interestYears.setYears(years);
        interestYearsDao.insertInterestYears(interestYears);
    }
    //更新兴趣年代表
    public void updateInterestYears(int userid,int years){
        interestYearsDao.updateInterestYears(userid,years);
    }
    //获取用户兴趣年代表1
    public int getInterestYearsInfo1(int userid){
        return interestYearsDao.selectInterestYearsInfo1(userid);
    }
    //获取用户兴趣年代表2
    public int getInterestYearsInfo2(int userid){
        return interestYearsDao.selectInterestYearsInfo2(userid);
    }
}
