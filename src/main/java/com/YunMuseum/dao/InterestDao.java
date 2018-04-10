package com.YunMuseum.dao;

import com.YunMuseum.model.Interest;
import com.YunMuseum.model.InterestMember;
import org.apache.ibatis.annotations.*;

import java.util.List;
/**
 * Created by zx G on 2017/5/6.
 */
@Mapper
public interface InterestDao {
    //查询用户加入的兴趣圈信息
    @Select({"select interestid,typename,yearsname,placename,image from interest where interestid in (select interestid from interestmember where userid=#{userid})"})
    List<Interest> selectInterestInfoYes(@Param("userid") int userid);
    //查询用户未加入的兴趣圈信息
    @Select({"select interestid,typename,yearsname,placename,image from interest where interestid not in (select interestid from interestmember where userid=#{userid})"})
    List<Interest> selectInternetInfoNo(@Param("userid") int userid);
    //用户加入兴趣圈
    @Insert({"insert into interestmember(InterestID,UserID) values (#{interestid},#{userid})"})
    int insertInterest(InterestMember interestMember);
    //用户退出兴趣圈
    @Delete({"delete from interestmember where interestid=#{interestid} and userid=#{userid}"})
    int deleteInterest(InterestMember interestMember);
    //查询兴趣圈详情
    @Select({"select typename,yearsname,placename from interest where interestid=#{interestid}"})
    List<Interest> selectInterest(@Param("interestid") int interestid);
    //查询兴趣圈关注人数
    @Select({"select count(userid) as userid from interestmember where interestid=#{interestid}"})
    int selectCountInterestMember(@Param("interestid") int interestid);
}
