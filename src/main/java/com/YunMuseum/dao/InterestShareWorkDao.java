package com.YunMuseum.dao;

import com.YunMuseum.model.InterestShareWork;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;
/**
 * Created by zx G on 2017/5/6.
 */
@Mapper
public interface InterestShareWorkDao {
    //查询兴趣圈成员的分享
    @Select({"select text,workid,name,image,wtitle,wimage,wtime from interestsharework where userid in (select userid from interestmember where interestid=#{interestid})"})
    List<InterestShareWork> selectInterestShareWork(@Param("interestid") int interestid);
}
