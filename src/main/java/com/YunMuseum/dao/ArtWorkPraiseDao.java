package com.YunMuseum.dao;

import com.YunMuseum.model.ArtWorkPraise;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;
/**
 * Created by Test Guo on 2017/5/4.
 */
@Mapper
public interface ArtWorkPraiseDao {
    //查询艺术品新增点赞
    @Select({"select name,wtitle from artworkpraise where workid in (select workid from artwork where userid=#{userid})"})
    List<ArtWorkPraise> selectArtWorkPraise(@Param("userid") int userid);
}
