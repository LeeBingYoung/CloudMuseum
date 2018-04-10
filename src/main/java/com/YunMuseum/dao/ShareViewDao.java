package com.YunMuseum.dao;

import com.YunMuseum.model.ShareColView;
import com.YunMuseum.model.ShareWorkView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;
/**
 * Created by Test Guo on 2017/5/4.
 */
@Mapper
public interface ShareViewDao {
    //查询发布者看到的艺术品新增转发
    @Select({"select name,text,wtitle from shareworkview where workid in (select workid from artwork where userid=#{userid})"})
    List<ShareWorkView> selectArtWorkSharePublisher(@Param("userid") int userid);
    //查询发布者看到的艺术专栏新增转发
    @Select({"select name,text,ctitle from sharecolview where colid in (select colid from artcol where userid=#{userid})"})
    List<ShareColView> selectArtColSharePublisher(@Param("userid") int userid);
}
