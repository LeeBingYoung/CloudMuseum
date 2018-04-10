package com.YunMuseum.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
/**
 * Created by zx G on 2017/5/11.
 */
@Mapper
public interface MessageDao {
    //查询艺术品未读评论总数
    @Select({"select count(commentid) as Count from comment where cread=0 and status=1 and type=1 and id in (select workid from artwork where userid=#{userid})"})
    int selectCountCommentWork(@Param("userid") int userid);
    //查询艺术专栏未读评论总数
    @Select({"select count(commentid) as Count from comment where cread=0 and status=1 and type=3 and id in (select colid from artcol where userid=#{userid})"})
    int selectCountCommentCol(@Param("userid") int userid);
    //查询艺术品未读点赞总数
    @Select({"select count(workid) as Count from praise where `read`=0 and status=1 and workid in (select workid from artwork where userid=#{userid})"})
    int selectCountPraiseWork(@Param("userid") int userid);
    //查询艺术专栏未读点赞总数
    @Select({"select count(colid) as Count from praise where `read`=0 and status=1 and colid in (select colid from artcol where userid=#{userid})"})
    int selectCountPraiseCol(@Param("userid") int userid);
    //查询未读关注总数
    @Select({"select count(userid) as Count from follow where `read`=0 and status=1 and publisherid=#{publisherid}"})
    int selectCountFollow(@Param("publisherid") int publisherid);
    //查询未读分享总数
    @Select({"select count(shareid) as Count from share where `read`=0 and status=1 and answerid=#{answerid}"})
    int selectCountShare(@Param("answerid") int answerid);
}
