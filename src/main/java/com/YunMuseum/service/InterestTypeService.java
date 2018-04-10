package com.YunMuseum.service;

import com.YunMuseum.dao.InterestTypeDao;
import com.YunMuseum.model.InterestType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InterestTypeService {
    @Autowired
    InterestTypeDao interestTypeDao;
    //插入兴趣类别表
    public void insertInterestType(int userid,int type){
        InterestType interestType = new InterestType();
        interestType.setUserid(userid);
        interestType.setType(type);
        interestTypeDao.insertInterestType(interestType);
    }
    //更新兴趣类别表
    public void updateInterestType(int userid,int type){
        interestTypeDao.updateInterestType(userid,type);
    }
    //获取用户兴趣类别表1
    public int getInterestTypeInfo1(int userid){
        return interestTypeDao.selectInterestTypeInfo1(userid);
    }
    //获取用户兴趣类别表2
    public int getInterestTypeInfo2(int userid){
        return interestTypeDao.selectInterestTypeInfo2(userid);
    }
}
