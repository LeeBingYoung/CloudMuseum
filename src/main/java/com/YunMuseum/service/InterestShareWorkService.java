package com.YunMuseum.service;

import com.YunMuseum.dao.InterestShareWorkDao;
import com.YunMuseum.model.InterestShareWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * Created by zx G on 2017/5/6.
 */
@Service
public class InterestShareWorkService {
    @Autowired
    InterestShareWorkDao interestShareWorkDao;
    //获取兴趣圈成员的分享
    public List<InterestShareWork> getInterestShareWork(int interestid){
        return interestShareWorkDao.selectInterestShareWork(interestid);
    }
}
