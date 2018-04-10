package com.YunMuseum.dao;

import com.YunMuseum.model.ArtStory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;
/**
 * Created by zx G on 2017/4/4.
 */
@Mapper
public interface ArtStoryDao {
    //查询艺术故事详情
    @Select({"select stitle,syears,stype,splace,sabstract from artstory where status=1 and stoid=#{stoid}"})
    List<ArtStory> selectArtStory(@Param("stoid") int stoid);
    //查询全部艺术故事
    @Select({"select stoid,stitle,image,syears,sabstract from artstory where status=1 order by stime desc"})
    List<ArtStory> selectArtStoryAll();
    //查询艺术故事数量
    @Select({"select max(stoid) from artstory"})
    int selectMaxStory();
}
