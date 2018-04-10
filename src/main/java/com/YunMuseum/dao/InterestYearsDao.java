package com.YunMuseum.dao;

import com.YunMuseum.model.InterestYears;
import org.apache.ibatis.annotations.*;

@Mapper
public interface InterestYearsDao {
    //用户插入兴趣年代表
    @Insert({"insert into interestyears(userid,years) values (#{userid},#{years})"})
    int insertInterestYears(InterestYears interestYears);
    //累加兴趣年代表
    @Update({"update interestyears set sum=sum+1 where userid=#{userid} and years=#{years}"})
    int updateInterestYears(@Param("userid") int userid,@Param("years") int years);
    //查询用户兴趣年代表1
    @Select({"select years from interestyears where userid=#{userid} order by sum desc limit 0,1"})
    int selectInterestYearsInfo1(@Param("userid") int userid);
    //查询用户兴趣年代表2
    @Select({"select years from interestyears where userid=#{userid} order by sum desc limit 1,1"})
    int selectInterestYearsInfo2(@Param("userid") int userid);
}
