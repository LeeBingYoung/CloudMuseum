package com.YunMuseum.dao;

import com.YunMuseum.model.ArtColComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;
/**
 * Created by Test Guo on 2017/5/4.
 */
@Mapper
public interface ArtColCommentDao {
    //查询艺术专栏评论是否已读
    @Select({"select name,text,ctitle,time from artcolcomment where id in (select colid from artcol where userid=#{userid})"})
    List<ArtColComment> selectArtColCommentRead(@Param("userid") int userid);
}
