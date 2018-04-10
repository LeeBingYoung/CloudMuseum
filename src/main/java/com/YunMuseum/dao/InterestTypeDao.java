package com.YunMuseum.dao;

import com.YunMuseum.model.InterestType;
import org.apache.ibatis.annotations.*;

@Mapper
public interface InterestTypeDao {
    //用户插入兴趣类别表
    @Insert({"insert into interesttype(userid,type) values (#{userid},#{type})"})
    int insertInterestType(InterestType interestType);
    //累加兴趣类别表
    @Update({"update interesttype set sum=sum+1 where userid=#{userid} and type=#{type}"})
    int updateInterestType(@Param("userid") int userid,@Param("type") int type);
    //查询用户兴趣类别表1
    @Select({"select type from interesttype where userid=#{userid} order by sum desc limit 0,1"})
    int selectInterestTypeInfo1(@Param("userid") int userid);
    //查询用户兴趣类别表2
    @Select({"select type from interesttype where userid=#{userid} order by sum desc limit 1,1"})
    int selectInterestTypeInfo2(@Param("userid") int userid);
}
