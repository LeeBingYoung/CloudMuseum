package com.YunMuseum.dao;

import com.YunMuseum.model.ArtWork;
import org.apache.ibatis.annotations.*;

import java.util.List;
/**
 * Created by zx G on 2017/4/4.
 */
@Mapper
public interface ArtWorkDao {
    String SELECT_FIELDS="artwork.WorkID,WTitle,WYears,WArtist,WCollector,WType,WPlace,WTime,WClick,WPraise,WImage,WText";
    //查询艺术品详情
    @Select({"select userid,wtitle,wyears,wartist,wcollector,wtype,wplace,wtext,wlength,wwidth,wheight from artwork where workid=#{workid} and status=1"})
    List<ArtWork> selectArtWork(@Param("workid") int workid);
    //查询全部艺术品
    @Select({"select userid,workid,wtitle,wimage,wyears,wtype,left(wtext,20) as wtext from artwork where status=1 order by (((wtime-20170000000000)/10000)/10*0.6+wpraise*0.35/100+wclick*0.05/100) desc"})
    List<ArtWork> selectArtWorkAll();
    //查询个人发布的艺术品
    @Select({"select userid,workid,wtitle,wtime,wtype,left(wtext,20) as wtext,wimage from artwork where userid=#{userid} and status=1"})
    List<ArtWork> selectArtWorkPerson(int userid);
    //查询艺术品放大图片
    @Select({"select wimage from artwork where workid=#{workid}"})
    List<ArtWork> selectArtWorkLarge(@Param("workid") int workid);
    //查询艺术品发布者ID
    @Select({"select userid from artwork where workid=#{workid}"})
    int selectArtWorkUserID(@Param("workid") int workid);
    //查询发布的艺术品详情方比删除
    @Select({"select workid,wtitle,wyears,wartist,wcollector,wtype,wplace,wtime,wclick,wpraise from artwork where userid=#{userid} and status=1"})
    List<ArtWork> selectArtWorkDetails(@Param("userid") int userid);
    //删除发布的艺术品
    @Update({"update artwork set status=0 where workid=#{workid} and userid=#{userid}"})
    int updateArtWorkDetails(@Param("workid") int workid,@Param("userid") int userid);
    //查询我关注的艺术品发布
    @Select({"select userid,workid,wtitle,wtime,wtype,left(wtext,20) as wtext,wimage from artwork where userid in (select publisherid from follow where userid=#{userid} and status=1)"})
    List<ArtWork> selectArtWorkFollow(@Param("userid") int userid);
    //查询我喜欢的艺术品发布
    @Select({"select userid,workid,wtitle,wtime,wtype,left(wtext,20) as wtext,wimage from artwork where workid in (select workid from praise where userid=#{userid} and status=1)"})
    List<ArtWork> selectArtWorkPraise(@Param("userid") int userid);
    //查询我上传的模型
    @Select({"select distinct "+SELECT_FIELDS+" from artwork where WTitle=#{title}"})
    List<ArtWork> selectModelInfo(@Param("title") String title);
    //更新个人发布的艺术品
    @Insert({"insert into artwork(UserID,WTitle,WYears,WType,WText,WTime,WImage) values(#{userid},#{wtitle},#{wyears},#{wtype},#{wtext},now(),#{wimage})"})
    int uploadWork(ArtWork artWork);
    //查询艺术品数量
    @Select({"select max(workid) from artwork"})
    int selectMaxWork();
    //查询艺术品年代推荐
    @Select({"select wtitle,wimage,workid from artwork where wyears=#{wyears} order by wpraise desc limit 0,1"})
    List<ArtWork> selectArtWorkCommendYears(@Param("wyears") String wyears);
    //查询艺术品类别推荐
    @Select({"select wtitle,wimage,workid from artwork where wtype=#{wtype} order by wpraise desc limit 0,1"})
    List<ArtWork> selectArtWorkCommendType(@Param("wtype") String wtype);
    //查询首页艺术品类别
    @Select({"select userid,workid,wtitle,wimage,wyears,wtype,left(wtext,20) as wtext from artwork where status=1 and wtype=#{wtype}"})
    List<ArtWork> selectArtWorkType(@Param("wtype") String wtype);
    //查询首页艺术品年代
    @Select({"select userid,workid,wtitle,wimage,wyears,wtype,left(wtext,20) as wtext from artwork where status=1 and wyears=#{wyears}"})
    List<ArtWork> selectArtWorkYears(@Param("wyears") String wyears);
}
