package com.YunMuseum.dao;

import com.YunMuseum.model.ArtStoryPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;
/**
 * Created by Test Guo on 2017/4/12.
 */
@Mapper
public interface ArtStoryPageDao {
    //查询艺术故事首张轮播图
    @Select({"select image,text from artstorypage where stoid=#{stoid} and page=1"})
    List<ArtStoryPage> selectFirstArtStoPage(@Param("stoid") int stoid);
    //查询艺术故事其余轮播图
    @Select({"select image,text from artstorypage where stoid=#{stoid} and page!=1"})
    List<ArtStoryPage> selectArtStoPage(@Param("stoid") int stoid);
    //查询艺术故事放大图片
    @Select({"select image from artstorypage where stoid=#{stoid}"})
    List<ArtStoryPage> selectArtStoryLarge(@Param("stoid") int stoid);
}
