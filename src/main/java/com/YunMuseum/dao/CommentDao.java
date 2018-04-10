package com.YunMuseum.dao;

import com.YunMuseum.model.Comment;
import org.apache.ibatis.annotations.*;
import java.util.List;
/**
 * Created by zx G on 2017/4/9.
 */
@Mapper
public interface CommentDao {
    //查询艺术品评论
    @Select({"select name,text from comment where type=1 and id=#{workid} and status=1"})
    List<Comment> selectArtWorkComment(@Param("workid") int workid);
    //查询艺术故事评论
    @Select({"select name,text from comment where type=2 and id=#{stoid} and status=1"})
    List<Comment> selectArtStoComment(@Param("stoid") int stoid);
    //查询艺术专栏评论
    @Select({"select name,text from comment where type=3 and id=#{colid} and status=1"})
    List<Comment> selectArtColComment(@Param("colid") int colid);
    //发表艺术品评论
    @Insert({"insert into comment(UserID,Text,Type,ID,Time) values (#{userid},#{text},1,#{id},now())"})
    int insertArtWorkComment(Comment comment);
    //发表艺术故事评论
    @Insert({"insert into comment(UserID,Text,Type,ID,Time) values (#{userid},#{text},2,#{id},now())"})
    int insertArtStoryComment(Comment comment);
    //发表艺术专栏评论
    @Insert({"insert into comment(UserID,Text,Type,ID,Time) values (#{userid},#{text},3,#{id},now())"})
    int insertArtColComment(Comment comment);
    //更新评论用户名称
    @Update({"update comment set name=(select name from user where userid=#{userid}) where userid=#{userid}"})
    int updateComment(@Param("userid") int userid);
    //更新艺术品评论为已读
    @Update({"update comment set cread=1 where type=1 and id in (select workid from artwork where userid=#{userid})"})
    int updateArtWorkComment(@Param("userid") int userid);
    //更新艺术专栏评论为已读
    @Update({"update comment set cread=1 where type=3 and id in (select colid from artcol where userid=#{userid})"})
    int updateArtColComment(@Param("userid") int userid);
    //查询兴趣圈分享作品评论
    @Select({"select name,text from comment where id=#{id} and type=1"})
    List<Comment> selectInterestWorkComment(@Param("id") int id);
}