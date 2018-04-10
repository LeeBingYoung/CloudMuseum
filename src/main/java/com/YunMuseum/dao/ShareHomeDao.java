package com.YunMuseum.dao;

import com.YunMuseum.model.ShareHomeCol;
import com.YunMuseum.model.ShareHomeWork;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Test Guo on 2017/5/10.
 */
@Mapper
public interface ShareHomeDao {
    //查询个人分享的艺术品详情
    @Select({"select userid,workid,text,wtitle,wtype,wimage,wtime from sharehomework where userid=#{userid}"})
    List<ShareHomeWork> selectShareHomeWork(@Param("userid") int userid);
    //查询个人分享的艺术专栏详情
    @Select({"select userid,colid,text,ctitle,ctype,cimage,cctime from sharehomecol where userid=#{userid}"})
    List<ShareHomeCol> selectShareHomeCol(@Param("userid") int userid);
}
