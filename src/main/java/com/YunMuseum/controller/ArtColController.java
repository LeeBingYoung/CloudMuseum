package com.YunMuseum.controller;

import com.YunMuseum.model.*;
import com.YunMuseum.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
/**
 * Created by zx G on 2017/4/5.
 */
@Controller
public class ArtColController {
    @Resource
    ArtColService artColService;
    @Resource
    ArtColImageService artColImageService;
    @Resource
    UserService userService;
    @Resource
    CommentService commentService;
    @Resource
    ClubService clubService;
    @Resource
    FollowService followService;
    @Resource
    PraiseService praiseService;
    @Resource
    ShareService shareService;
    @Resource
    MessageService messageService;
    @RequestMapping("/ArtColCom")
    public String artColDetailComment(HttpServletRequest request, Model model, @CookieValue("username") String username, @CookieValue("colid") String colidstring){
        int colid = Integer.parseInt(colidstring);
        int userid = clubService.selectClubUserID(username);
        //发表艺术专栏评论
        String word=request.getParameter("word");
        commentService.insertArtColComment(userid,word,colid);
        commentService.updateComment(userid);
        //展示艺术专栏详情
        List<ArtCol> artColList = artColService.getArtCol(colid);
        model.addAttribute("ArtCol",artColList);
        //展示艺术专栏文章内容
        List<ArtCol> artColListText = artColService.getArtColText(colid);
        model.addAttribute("ArtColText",artColListText);
        //展示艺术专栏图片
        List<ArtColImage> artColImageList = artColImageService.getArtColImage(colid);
        model.addAttribute("ArtColImage",artColImageList);
        //展示艺术专栏作者
        List<User> userList = userService.getArtColUser(colid);
        model.addAttribute("ArtColUser",userList);
        //展示艺术专栏作者头像
        List<User> userListImage = userService.getArtColUserImage(colid);
        model.addAttribute("ArtColUserImage",userListImage);
        //展示艺术专栏评论
        List<Comment> artColCommentList = commentService.getArtColComment(colid);
        model.addAttribute("ArtColComment",artColCommentList);
        //判断是否点赞
        List<Praise> artColPraiseList = praiseService.getArtColPraise(userid,colid);
        model.addAttribute("ArtColPraise",artColPraiseList);
        //判断是否关注用户
        List<Follow> artColFollowList = followService.getArtColFollow(userid,colid);
        model.addAttribute("ArtColFollow",artColFollowList);
        //展示消息推送通知
        int CountCommentWork = messageService.getCountCommentWork(userid);
        int CountCommentCol = messageService.getCountCommentCol(userid);
        int CountPraiseWork = messageService.getCountPraiseWork(userid);
        int CountPraiseCol = messageService.getCountPraiseCol(userid);
        int CountFollow = messageService.getCountFollow(userid);
        int CountShare = messageService.getCountShare(userid);
        int Count = CountCommentWork+CountCommentCol+CountPraiseWork+CountPraiseCol+CountFollow+CountShare;
        model.addAttribute("Count",Count);
        return "ColumnDetails";
    }
    @RequestMapping("/ArtColShare")
    public String artColShare(HttpServletRequest request, Model model, @CookieValue("username") String username, @CookieValue("colid") String colidstring){
        int colid = Integer.parseInt(colidstring);
        int userid = clubService.selectClubUserID(username);
        int answerid = artColService.getArtColUserID(colid);
        String word=request.getParameter("word");
        //发表艺术专栏评论
        commentService.insertArtColComment(userid,word,colid);
        commentService.updateComment(userid);
        //艺术专栏分享
        shareService.insertShareCol(userid,word,answerid,colid);
        //展示艺术专栏详情
        List<ArtCol> artColList = artColService.getArtCol(colid);
        model.addAttribute("ArtCol",artColList);
        //展示艺术专栏文章内容
        List<ArtCol> artColListText = artColService.getArtColText(colid);
        model.addAttribute("ArtColText",artColListText);
        //展示艺术专栏图片
        List<ArtColImage> artColImageList = artColImageService.getArtColImage(colid);
        model.addAttribute("ArtColImage",artColImageList);
        //展示艺术专栏作者
        List<User> userList = userService.getArtColUser(colid);
        model.addAttribute("ArtColUser",userList);
        //展示艺术专栏作者头像
        List<User> userListImage = userService.getArtColUserImage(colid);
        model.addAttribute("ArtColUserImage",userListImage);
        //展示艺术专栏评论
        List<Comment> artColCommentList = commentService.getArtColComment(colid);
        model.addAttribute("ArtColComment",artColCommentList);
        //判断是否点赞
        List<Praise> artColPraiseList = praiseService.getArtColPraise(userid,colid);
        model.addAttribute("ArtColPraise",artColPraiseList);
        //判断是否关注用户
        List<Follow> artColFollowList = followService.getArtColFollow(userid,colid);
        model.addAttribute("ArtColFollow",artColFollowList);
        //展示消息推送通知
        int CountCommentWork = messageService.getCountCommentWork(userid);
        int CountCommentCol = messageService.getCountCommentCol(userid);
        int CountPraiseWork = messageService.getCountPraiseWork(userid);
        int CountPraiseCol = messageService.getCountPraiseCol(userid);
        int CountFollow = messageService.getCountFollow(userid);
        int CountShare = messageService.getCountShare(userid);
        int Count = CountCommentWork+CountCommentCol+CountPraiseWork+CountPraiseCol+CountFollow+CountShare;
        model.addAttribute("Count",Count);
        return "ColumnDetails";
    }
    @RequestMapping("/ArtColFollow")
    public String artColFollow(HttpServletRequest request, @CookieValue("username") String username, @CookieValue("colid") String colidstring){
        int colid = Integer.parseInt(colidstring);
        int userid = clubService.selectClubUserID(username);
        //更新艺术专栏关注
        String followclass = request.getParameter("followclass");
        if(followclass.equals("glyphicon glyphicon-plus-sign"))
        {
            String classname = "glyphicon glyphicon-minus-sign";
            followService.updateFollowColYes(classname,userid,colid);
        }
        else
        {
            String classname = "glyphicon glyphicon-plus-sign";
            followService.updateFollowColNo(classname,userid,colid);
        }
        return "ColumnDetails";
    }
    @RequestMapping("/ArtColPraise")
    public String artColPraise(HttpServletRequest request, @CookieValue("username") String username, @CookieValue("colid") String colidstring){
        int colid = Integer.parseInt(colidstring);
        int userid = clubService.selectClubUserID(username);
        //更新艺术专栏点赞
        String praiseclass = request.getParameter("praiseclass");
        if(praiseclass.equals("glyphicon glyphicon-heart-empty"))
        {
            String classname = "glyphicon glyphicon-heart";
            praiseService.updateColPraiseYes(classname,userid,colid);
        }
        else
        {
            String classname = "glyphicon glyphicon-heart-empty";
            praiseService.updateColPraiseNo(classname,userid,colid);
        }
        return "ColumnDetails";
    }
    @RequestMapping("/ArtCol")
    public String artColDetail(Model model, HttpServletRequest request, HttpServletResponse response, @CookieValue(value = "username",required = false) String username){
        if (username!=null && username!=""){
            String colidstring = request.getParameter("artcol");
            Cookie cookie = new Cookie("colid",colidstring);
            response.addCookie(cookie);
            cookie.setMaxAge(60*24*60);
            int colid = Integer.parseInt(colidstring);
            int userid = clubService.selectClubUserID(username);
            //展示艺术专栏详情
            List<ArtCol> artColList = artColService.getArtCol(colid);
            model.addAttribute("ArtCol",artColList);
            //展示艺术专栏文章内容
            List<ArtCol> artColListText = artColService.getArtColText(colid);
            model.addAttribute("ArtColText",artColListText);
            //展示艺术专栏图片
            List<ArtColImage> artColImageList = artColImageService.getArtColImage(colid);
            model.addAttribute("ArtColImage",artColImageList);
            //展示艺术专栏作者
            List<User> userList = userService.getArtColUser(colid);
            model.addAttribute("ArtColUser",userList);
            //展示艺术专栏作者头像
            List<User> userListImage = userService.getArtColUserImage(colid);
            model.addAttribute("ArtColUserImage",userListImage);
            //展示艺术专栏评论
            List<Comment> artColCommentList = commentService.getArtColComment(colid);
            model.addAttribute("ArtColComment",artColCommentList);
            //判断是否点赞
            List<Praise> artColPraiseList = praiseService.getArtColPraise(userid,colid);
            model.addAttribute("ArtColPraise",artColPraiseList);
            //判断是否关注用户
            List<Follow> artColFollowList = followService.getArtColFollow(userid,colid);
            model.addAttribute("ArtColFollow",artColFollowList);
            //展示消息推送通知
            int CountCommentWork = messageService.getCountCommentWork(userid);
            int CountCommentCol = messageService.getCountCommentCol(userid);
            int CountPraiseWork = messageService.getCountPraiseWork(userid);
            int CountPraiseCol = messageService.getCountPraiseCol(userid);
            int CountFollow = messageService.getCountFollow(userid);
            int CountShare = messageService.getCountShare(userid);
            int Count = CountCommentWork+CountCommentCol+CountPraiseWork+CountPraiseCol+CountFollow+CountShare;
            model.addAttribute("Count",Count);
            return "ColumnDetails";
        }
        else {
            return "LoginError";
        }
    }
}
