package com.YunMuseum.dao;

import com.YunMuseum.model.ArtColImage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;
/**
 * Created by zx G on 2017/4/5.
 */
@Mapper
public interface ArtColImageDao {
    //查询艺术专栏图片
    @Select({"select image from artcolimage where colid=#{colid}"})
    List<ArtColImage> selectArtColImage(@Param("colid") int colid);
    //查询艺术专栏放大图片
    @Select({"select image from artcolimage where colid=#{colid}"})
    List<ArtColImage> selectArtColImageLarge(@Param("colid") int colid);
}
