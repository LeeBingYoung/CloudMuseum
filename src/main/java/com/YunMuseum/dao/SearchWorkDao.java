package com.YunMuseum.dao;

import com.YunMuseum.model.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;
/**
 * Created by lby on 2017/5/19.
 */
@Mapper
public interface SearchWorkDao {
    //查询艺术品上传者相似
    @Select({"select workid,wtitle,wimage,wyears,WArtist,WCollector,wtype,WPlace,left(wtext,20) as wtext from artwork where userid in (select userid from user where name like #{search})"})
    List<ArtWork> selectArtWorkWName(@Param("search") String search);
    //查询艺术品标题相似
    @Select({"select workid,wtitle,wimage,wyears,WArtist,WCollector,wtype,WPlace,left(wtext,20) as wtext from artwork where wtitle like #{search}"})
    List<ArtWork> selectArtWorkWTitle(@Param("search") String search);
    //查询艺术品年代相似
    @Select({"select workid,wtitle,wimage,wyears,WArtist,WCollector,wtype,WPlace,left(wtext,20) as wtext from artwork where wyears like #{search}"})
    List<ArtWork> selectArtWorkWYears(@Param("search") String search);
    //查询艺术品原作者相似
    @Select({"select workid,wtitle,wimage,wyears,WArtist,WCollector,wtype,WPlace,left(wtext,20) as wtext from artwork where wartist like #{search}"})
    List<ArtWork> selectArtWorkWArtist(@Param("search") String search);
    //查询艺术品所有者相似
    @Select({"select workid,wtitle,wimage,wyears,WArtist,WCollector,wtype,WPlace,left(wtext,20) as wtext from artwork where wcollector like #{search}"})
    List<ArtWork> selectArtWorkWCollector(@Param("search") String search);
    //查询艺术品类型相似
    @Select({"select workid,wtitle,wimage,wyears,WArtist,WCollector,wtype,WPlace,left(wtext,20) as wtext from artwork where wtype like #{search}"})
    List<ArtWork> selectArtWorkWType(@Param("search") String search);
    //查询艺术品地点相似
    @Select({"select workid,wtitle,wimage,wyears,WArtist,WCollector,wtype,WPlace,left(wtext,20) as wtext from artwork where wplace like #{search}"})
    List<ArtWork> selectArtWorkWPlace(@Param("search") String search);
    //查询艺术品简介相似
    @Select({"select workid,wtitle,wimage,wyears,WArtist,WCollector,wtype,WPlace,left(wtext,20) as wtext from artwork where wtext like #{search}"})
    List<ArtWork> selectArtWorkWText(@Param("search") String search);
    /*//查询艺术品上传时间相似
    @Select({"select workid,wtitle,wimage,wyears,WArtist,WCollector,wtype,WPlace,left(wtext,20) as wtext " +
            "from artwork where wtime like #{search}"})
    List<ArtWork> selectArtWorkWTime(@Param("search") String search);*/
}
