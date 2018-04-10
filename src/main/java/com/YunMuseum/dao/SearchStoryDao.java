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
public interface SearchStoryDao {
    //查询艺术故事标题相似
    @Select({"select * from artstory where stitle like #{search}"})
    List<ArtStory> selectArtStorySTitle(@Param("search") String search);
    //查询艺术故事年代相似
    @Select({"select * from artstory where syears like #{search}"})
    List<ArtStory> selectArtStorySYears(@Param("search") String search);
    //查询艺术故事类型相似
    @Select({"select * from artstory where stype like #{search}"})
    List<ArtStory> selectArtStorySType(@Param("search") String search);
    //查询艺术故事地点相似
    @Select({"select * from artstory where splace like #{search}"})
    List<ArtStory> selectArtStorySPlace(@Param("search") String search);
    //查询艺术故事摘要相似
    @Select({"select * from artstory where sabstract like #{search}"})
    List<ArtStory> selectArtStorySAbstract(@Param("search") String search);
    //查询艺术故事期号相似
    @Select({"select * from artstory where no like #{search}"})
    List<ArtStory> selectArtStoryNo(@Param("search") String search);
    //查询艺术故事系列相似
    @Select({"select * from artstory where series like #{search}"})
    List<ArtStory> selectArtStorySeries(@Param("search") String search);
}
