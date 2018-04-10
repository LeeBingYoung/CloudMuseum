package com.YunMuseum.service;

import com.YunMuseum.dao.InterestDao;
import com.YunMuseum.model.Interest;
import com.YunMuseum.model.InterestMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * Created by zx G on 2017/5/6.
 */
@Service
public class InterestService {
    @Autowired
    InterestDao interestDao;
    //获取用户加入的兴趣圈信息
    public List<Interest> getInterestInfoYes(int userid){
        return interestDao.selectInterestInfoYes(userid);
    }
    //获取用户未加入的兴趣圈信息
    public List<Interest> getInterestInfoNo(int userid){
        return interestDao.selectInternetInfoNo(userid);
    }
    //用户加入兴趣圈
    public void insertInterest(int interestid,int userid){
        InterestMember interestMember = new InterestMember();
        interestMember.setInterestid(interestid);
        interestMember.setUserid(userid);
        interestDao.insertInterest(interestMember);
    }
    //用户退出兴趣圈
    public void deleteInterest(int interestid,int userid){
        InterestMember interestMember = new InterestMember();
        interestMember.setInterestid(interestid);
        interestMember.setUserid(userid);
        interestDao.deleteInterest(interestMember);
    }
    //获取兴趣圈详情
    public List<Interest> getInterest(int interestid){
        return interestDao.selectInterest(interestid);
    }
    //获取兴趣圈关注人数
    public int getCountInterestMember(int interestid){
        return interestDao.selectCountInterestMember(interestid);
    }
}
