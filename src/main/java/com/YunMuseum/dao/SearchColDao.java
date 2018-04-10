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
public interface SearchColDao {
    //查询艺术专栏标题相似
    @Select({"select * from artcol where ctitle like #{search}"})
    List<ArtCol> selectArtColCTitle(@Param("search") String search);
    //查询艺术专栏年代相似
    @Select({"select * from artcol where cyears like #{search}"})
    List<ArtCol> selectArtColCYears(@Param("search") String search);
    //查询艺术专栏类型相似
    @Select({"select * from artcol where ctype like #{search}"})
    List<ArtCol> selectArtColCType(@Param("search") String search);
    //查询艺术专栏地点相似
    @Select({"select * from artcol where cplace like #{search}"})
    List<ArtCol> selectArtColCPlace(@Param("search") String search);
    //查询艺术专栏摘要相似
    @Select({"select * from artcol where cabstract like #{search}"})
    List<ArtCol> selectArtColCAbstract(@Param("search") String search);
    //查询艺术专栏全文相似
    @Select({"select * from artcol where ctext like #{search}"})
    List<ArtCol> selectArtColCText(@Param("search") String search);
    //查询艺术专栏作者相似
    @Select({"select * from artcol where username like #{search}"})
    List<ArtCol> selectArtColUserName(@Param("search") String search);
}
