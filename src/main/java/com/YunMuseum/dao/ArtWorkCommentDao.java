package com.YunMuseum.dao;

import com.YunMuseum.model.ArtWorkComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;
/**
 * Created by Test Guo on 2017/5/4.
 */
@Mapper
public interface ArtWorkCommentDao {
    //获取艺术品评论是否已读
    @Select({"select name,text,wtitle,time from artworkcomment where id in (select workid from artwork where userid=#{userid})"})
    List<ArtWorkComment> selectArtWorkCommentRead(@Param("userid") int userid);
}
