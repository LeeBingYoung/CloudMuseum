package com.YunMuseum.dao;

import com.YunMuseum.model.ArtColPraise;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;
/**
 * Created by Test Guo on 2017/5/4.
 */
@Mapper
public interface ArtColPraiseDao {
    //查询艺术专栏新增点赞
    @Select({"select name,ctitle from artcolpraise where colid in (select colid from artcol where userid=#{userid})"})
    List<ArtColPraise> selectArtColPraise(@Param("userid") int userid);
}
