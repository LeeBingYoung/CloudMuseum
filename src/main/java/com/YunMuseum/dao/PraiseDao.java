package com.YunMuseum.dao;

import com.YunMuseum.model.Praise;
import org.apache.ibatis.annotations.*;

import java.util.List;
/**
 * Created by Test Guo on 2017/4/29.
 */
@Mapper
public interface PraiseDao {
    //查询艺术品是否点赞
    @Select({"select classname from praise where userid=#{userid} and workid=#{workid}"})
    List<Praise> selectArtWorkPraise(@Param("userid") int userid, @Param("workid") int workid);
    //查询艺术故事是否点赞
    @Select({"select classname from praise where userid=#{userid} and stoid=#{stoid}"})
    List<Praise> selectArtStoPraise(@Param("userid") int userid,@Param("stoid") int stoid);
    //查询艺术专栏是否点赞
    @Select({"select classname from praise where userid=#{userid} and colid=#{colid}"})
    List<Praise> selectArtColPraise(@Param("userid") int userid,@Param("colid") int colid);
    //更新艺术品为点赞
    @Update({"update praise set classname=#{classname},status=1 where userid=#{userid} and workid=#{workid}"})
    int updatePraiseWorkYes(@Param("classname") String classname,@Param("userid") int userid,@Param("workid") int workid);
    //更新艺术品为不点赞
    @Update({"update praise set classname=#{classname},status=0 where userid=#{userid} and workid=#{workid}"})
    int updatePraiseWorkNo(@Param("classname") String classname,@Param("userid") int userid,@Param("workid") int workid);
    //更新艺术故事为点赞
    @Update({"update praise set classname=#{classname},status=1 where userid=#{userid} and stoid=#{stoid}"})
    int updatePraiseStoYes(@Param("classname") String classname,@Param("userid") int userid,@Param("stoid") int stoid);
    //更新艺术故事为不点赞
    @Update({"update praise set classname=#{classname},status=0 where userid=#{userid} and stoid=#{stoid}"})
    int updatePraiseStoNo(@Param("classname") String classname,@Param("userid") int userid,@Param("stoid") int stoid);
    //更新艺术专栏为点赞
    @Update({"update praise set classname=#{classname},status=1 where userid=#{userid} and colid=#{colid}"})
    int updatePraiseColYes(@Param("classname") String classname,@Param("userid") int userid,@Param("colid") int colid);
    //更新艺术专栏为不点赞
    @Update({"update praise set classname=#{classname},status=0 where userid=#{userid} and colid=#{colid}"})
    int updatePraiseColNo(@Param("classname") String classname,@Param("userid") int userid,@Param("colid") int colid);
    //更新新增艺术品点赞为已读
    @Update({"update praise set `read`=1 where status=1 and workid in (select workid from artwork where userid=#{userid})"})
    int updateWorkPraise(@Param("userid") int userid);
    //更新新增艺术专栏点赞为已读
    @Update({"update praise set `read`=1 where status=1 and colid in (select colid from artcol where userid=#{userid})"})
    int updateColPraise(@Param("userid") int userid);
    //新注册用户插入艺术品点赞
    @Insert({"insert into praise(userid,workid,classname) values (#{userid},#{workid},'glyphicon glyphicon-heart-empty')"})
    int insertWorkPraise(@Param("userid") int userid, @Param("workid") int workid);
    //新注册用户插入艺术故事点赞
    @Insert({"insert into praise(userid,stoid,classname) values (#{userid},#{stoid},'glyphicon glyphicon-heart-empty')"})
    int insertStoPraise(@Param("userid") int userid, @Param("stoid") int stoid);
    //新注册用户插入艺术专栏点赞
    @Insert({"insert into praise(userid,colid,classname) values (#{userid},#{colid},'glyphicon glyphicon-heart-empty')"})
    int insertColPraise(@Param("userid") int userid, @Param("colid") int colid);
    //查询新插入艺术专栏的ID
    @Select({"select colid from artcol where ctitle=#{ctitle}"})
    int selectNewColID(@Param("ctitle") String ctitle);
    //查询新插入艺术品的ID
    @Select({"select workid from artwork where wtitle=#{wtitle}"})
    int selectNewWorkID(@Param("wtitle") String wtitle);
}
