package com.YunMuseum.dao;

import com.YunMuseum.model.User;
import com.YunMuseum.model.UserPass;
import org.apache.ibatis.annotations.*;
import java.util.List;
/**
 * Created by zx G on 2017/4/4.
 */
@Mapper
public interface UserDao {
    //查询艺术品发布者名字
    @Select({"select name from user where userid=(select userid from artwork where workid=#{workid})"})
    List<User> selectArtWorkUser(@Param("workid") int workid);
    //查询艺术品发布者头像
    @Select({"select image from user where userid=(select userid from artwork where workid=#{workid})"})
    List<User> selectArtWorkUserIamge(@Param("workid") int workid);
    //查询艺术专栏发布者名字
    @Select({"select name from user where userid=(select userid from artcol where colid=#{colid})"})
    List<User> selectArtColUser(@Param("colid") int colid);
    //查询艺术专栏发布者头像
    @Select({"select image from user where userid=(select userid from artcol where colid=#{colid})"})
    List<User> selectArtColUserImage(@Param("colid") int colid);
    //查询需要认证的信息
    @Select({"select password from userpass where username=#{username}"})
    UserPass selectPasswordByID(String username);
    //插入注册信息到UserPass
    @Insert({"insert into userpass(username,password,salt) values (#{username},#{password},'1')"})
    int insertRegisterUserPass(UserPass userPass);
    //插入注册信息到User
    @Insert({"insert into user(username,mail) values (#{username},#{mail})"})
    int insertRegisterUser(User user);
    //查询兴趣圈成员
    @Select({"select name,image from user where userid in(select userid from clubmember where clubid=(select clubid from club where clubname=#{clubname}))"})
    List<User> selectClubMember(@Param("clubname") String clubname);
    //查询兴趣圈聚会成员
    @Select({"select name,image from user where userid in (select userid from clubpartymember where partyid=#{partyid})"})
    List<User> selectClubPartyMember(@Param("partyid") int partyid);
    //查询兴趣圈聚会发起人
    @Select({"select name from user where userid=(select userid from clubparty where partyid=#{partyid})"})
    List<User> selectClubPartyUser(@Param("partyid") int partyid);
    //查询用户ID
    @Select({"select userid from userpass where username=#{username}"})
    int selectClubUserID(@Param("username") String username);
    //更新密码
    @Update({"update userpass set password=#{password} where username=#{username}"})
    int ChangePassword(UserPass userpass);
    //实名认证
    @Update({"update user set name=#{name},image=#{image},idnum=#{idnum},doctype=#{doctype} where username=#{username}"})
    void RealNameChange(User user);
    //插入个人信息
    @Update({"update user set username=#{username},mail=#{mail},city=#{city},pro=#{pro} where username=#{ticket}"})
    void PersonalInfoSetup(User user);
    //查询新增关注
    @Select({"select name from user where userid in (select userid from follow where `read`=0 and publisherid=#{publisherid} and status=1)"})
    List<User> selectFollow(@Param("publisherid") int publisherid);
    //查询兴趣圈成员信息
    @Select({"select userid,username,mail,birth,city,pro,type1,years1 from user where userid in (select userid from interestmember where interestid=#{interestid}) order by username"})
    List<User> selectInterestMember(@Param("interestid") int interestid);
    //查询其他用户ID和姓名
    @Select({"select userid,username,name from user where userid=#{userid}"})
    List<User> selectOtherUser(@Param("userid") int userid);
    //设置用户头像路径
    @Update({"update user set Image=#{path} where UserName=#{username}"})
    void setImagePath(@Param("username") String username,@Param("path") String path);
    //查询用户是否认证
    @Select({"select Identified from user where UserName=#{username}"})
    User getIdentity(@Param("username") String username);
    //查找用户信息
    @Select({"select password from userpass where username=#{username}"})
    List<UserPass> getJudge(@Param("username") String username);
    //查询用户数量
    @Select({"select max(userid) from user"})
    int selectMaxUser();
}
