package com.YunMuseum.dao;

import com.YunMuseum.model.Follow;
import org.apache.ibatis.annotations.*;

import java.util.List;
/**
 * Created by Test Guo on 2017/4/30.
 */
@Mapper
public interface FollowDao {
    //查询艺术品用户是否关注
    @Select({"select classname from follow where userid=#{userid} and publisherid=(select userid from artwork where workid=#{workid})"})
    List<Follow> selectArtWorkFollow(@Param("userid") int userid,@Param("workid") int workid);
    //查询艺术故事是否关注
    @Select({"select classname from follow where userid=#{userid} and stoid=#{stoid}"})
    List<Follow> selectArtStoFollow(@Param("userid") int userid,@Param("stoid") int stoid);
    //查询艺术专栏用户是否关注
    @Select({"select classname from follow where userid=#{userid} and publisherid=(select userid from artcol where colid=#{colid})"})
    List<Follow> selectArtColFollow(@Param("userid") int userid,@Param("colid") int colid);
    //更新艺术品用户为关注
    @Update({"update follow set classname=#{classname},status=1 where userid=#{userid} and publisherid=(select userid from artwork where workid=#{workid})"})
    int updateFollowWorkYes(@Param("classname") String classname,@Param("userid") int userid,@Param("workid") int workid);
    //更新艺术品用户为不关注
    @Update({"update follow set classname=#{classname},status=0 where userid=#{userid} and publisherid=(select userid from artwork where workid=#{workid})"})
    int updateFollowWorkNo(@Param("classname") String classname,@Param("userid") int userid,@Param("workid") int workid);
    //更新艺术故事为关注
    @Update({"update follow set classname=#{classname},status=1 where userid=#{userid} and stoid=#{stoid}"})
    int updateFollowStoYes(@Param("classname") String classname,@Param("userid") int userid,@Param("stoid") int stoid);
    //更新艺术故事为不关注
    @Update({"update follow set classname=#{classname},status=0 where userid=#{userid} and stoid=#{stoid}"})
    int updateFollowStoNo(@Param("classname") String classname,@Param("userid") int userid,@Param("stoid") int stoid);
    //更新艺术专栏为关注
    @Update({"update follow set classname=#{classname},status=1 where userid=#{userid} and publisherid=(select userid from artcol where colid=#{colid})"})
    int updateFollowColYes(@Param("classname") String classname,@Param("userid") int userid,@Param("colid") int colid);
    //更新艺术专栏为不关注
    @Update({"update follow set classname=#{classname},status=0 where userid=#{userid} and publisherid=(select userid from artcol where colid=#{colid})"})
    int updateFollowColNo(@Param("classname") String classname,@Param("userid") int userid,@Param("colid") int colid);
    //更新新增关注为已读
    @Update({"update follow set `read`=1 where publisherid=#{publisherid} and status=1"})
    int updateFollow(@Param("publisherid") int publisherid);
    //新注册用户插入作者关注
    @Insert({"insert into follow(userid,publisherid,classname) values (#{userid},#{publisherid},'glyphicon glyphicon-plus-sign')"})
    int insertUserFollow(@Param("userid") int userid, @Param("publisherid") int publisherid);
    //新注册用户插入艺术故事关注
    @Insert({"insert into follow(userid,stoid,classname) values (#{userid},#{stoid},'glyphicon glyphicon-plus-sign')"})
    int insertStoFollow(@Param("userid") int userid, @Param("stoid") int stoid);
}
