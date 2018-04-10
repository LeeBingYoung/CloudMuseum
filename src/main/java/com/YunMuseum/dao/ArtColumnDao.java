package com.YunMuseum.dao;

import com.YunMuseum.model.ArtCol;
import com.YunMuseum.model.ArtColImage;
import org.apache.ibatis.annotations.*;

import java.util.List;
/**
 * Created by zx G on 2017/4/4.
 */
@Mapper
public interface ArtColumnDao {
    //查询艺术专栏详情
    @Select({"select ctitle,cyears,ctype,cplace,tag1,tag2,tag3,cabstract from artcol where colid=#{colid} and status=1"})
    List<ArtCol> selectArtCol(@Param("colid") int colid);
    //查询艺术专栏文章内容
    @Select({"select ctext from artcol where colid=#{colid}"})
    List<ArtCol> selectArtColText(@Param("colid") int colid);
    //查询全部艺术专栏
    @Select({"select colid,ctitle,cyears,cabstract,cimage,username from artcol where status=1 order by cctime desc"})
    List<ArtCol> selectArtColAll();
    //查询艺术专栏发布者ID
    @Select({"select userid from artcol where colid=#{colid}"})
    int selectArtColUserID(@Param("colid") int colid);
    //查询我关注的艺术专栏
    @Select({"select userid,colid,ctitle,cctime,ctype,cabstract,cimage from artcol where userid in (select publisherid from follow where userid=#{userid} and status=1)"})
    List<ArtCol> selectArtColFollow(@Param("userid") int userid);
    //查询我喜欢的艺术专栏
    @Select({"select userid,colid,ctitle,cctime,ctype,cabstract,cimage from artcol where colid in (select colid from praise where userid=#{userid} and status=1)"})
    List<ArtCol> selectArtColPraise(@Param("userid") int userid);
    //上传艺术专栏
    @Insert({"insert into artcol(UserID,Username,CTitle,CYears,CType,CPlace,CImage,CCTime,CText,TotalImage) values(#{userid},#{username},#{ctitle},#{cyears},#{ctype},#{cplace},#{cimage},now(),#{ctext},4)"})
    int InsertColumn(ArtCol artCol);
    //上传艺术专栏图片
    @Insert({"insert into artcolimage(ColID,ImagePage,Image) values(#{colid},#{imagepage},#{image})"})
    int InsertColImg(ArtColImage artColImage);
    //查询个人发布的艺术专栏
    @Select({"select colid,ctitle,cctime,ctype,cabstract,cimage from artcol where userid=#{userid}"})
    List<ArtCol> selectArtColPerson(@Param("userid") int userid);
    //查询艺术专栏的数量
    @Select({"select max(colid) from artcol"})
    int selectMaxCol();
    //查询艺术专栏推荐
    @Select({"select ctitle,colid from artcol order by cpraise desc limit 0,3"})
    List<ArtCol> selectArtColCommend();
    //更新艺术专栏图片
    @Update({"update artcol set cimage=#{cimage} where colid=#{colid}"})
    int updateArtColImage(@Param("cimage") String cimage, @Param("colid") int colid);
}