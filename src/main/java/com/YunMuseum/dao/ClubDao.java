package com.YunMuseum.dao;

import com.YunMuseum.model.Club;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;
/**
 * Created by Test Guo on 2017/4/10.
 */
@Mapper
public interface ClubDao {
    //查询个人加入的兴趣圈类别
    @Select({"select clubid,clubname,clubimage,cluba,clubw,clubcy,clubhd,clubt from club where clubid in(select clubid from clubmember where userid=(select userid from userpass where username=#{username})) and clubid<8"})
    List<Club> selectClubPersonType(@Param("username") String username);
    //查询个人未加入的兴趣圈类别
    @Select({"select clubid,clubname,clubimage,cluba,clubw,clubcy,clubhd,clubt from club where clubid not in(select clubid from clubmember where userid=(select userid from userpass where username=#{username})) and clubid<8"})
    List<Club> selectClubPersonNotType(@Param("username") String username);
    //查询个人加入的兴趣圈年代
    @Select({"select clubid,clubname,clubimage,cluba,clubw,clubcy,clubhd,clubt from club where clubid in(select clubid from clubmember where userid=(select userid from userpass where username=#{username})) and clubid>7 and clubid<21"})
    List<Club> selectClubPersonYears(@Param("username") String username);
    //查询个人未加入的兴趣圈年代
    @Select({"select clubid,clubname,clubimage,cluba,clubw,clubcy,clubhd,clubt from club where clubid not in(select clubid from clubmember where userid=(select userid from userpass where username=#{username})) and clubid>7 and clubid<21"})
    List<Club> selectClubPersonNotYears(@Param("username") String username);
    //查询个人加入的兴趣圈地点
    @Select({"select clubid,clubname,clubimage,cluba,clubw,clubcy,clubhd,clubt from club where clubid in(select clubid from clubmember where userid=(select userid from userpass where username=#{username})) and clubid>21"})
    List<Club> selectClubPersonPlace(@Param("username") String username);
    //查询个人未加入的兴趣圈地点
    @Select({"select clubid,clubname,clubimage,cluba,clubw,clubcy,clubhd,clubt from club where clubid not in(select clubid from clubmember where userid=(select userid from userpass where username=#{username})) and clubid>21"})
    List<Club> selectClubPersonNotPlace(@Param("username") String username);
    //查询兴趣圈名字
    @Select({"select clubname from club where clubname=#{clubname}"})
    List<Club> selectClubName(@Param("clubname") String clubname);
}