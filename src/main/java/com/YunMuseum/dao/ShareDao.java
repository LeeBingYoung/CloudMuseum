package com.YunMuseum.dao;

import com.YunMuseum.model.Share;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
/**
 * Created by Test Guo on 2017/4/30.
 */
@Mapper
public interface ShareDao {
    //插入艺术品分享
    @Insert({"insert into share(UserID,Text,AnswerID,WorkID) values (#{userid},#{text},#{answerid},#{workid})"})
    int insertShaerWork(Share share);
    //插入艺术故事分享
    @Insert({"insert into share(UserID,Text,StoID) values (#{userid},#{text},#{stoid})"})
    int insertShaerSto(Share share);
    //插入艺术专栏分享
    @Insert({"insert into share(UserID,Text,AnswerID,ColID) values (#{userid},#{text},#{answerid},#{colid})"})
    int insertShaerCol(Share share);
    //更新新增分享为已读
    @Update({"update share set `read`=1 where answerid=#{answerid}"})
    int updateShare(@Param("answerid") int answerid);
}
