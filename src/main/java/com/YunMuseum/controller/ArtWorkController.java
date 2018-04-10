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
 * Created by zx G on 2017/4/4.
 */
@Controller
public class ArtWorkController {
    @Resource
    ArtWorkService artWorkService;
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
    @RequestMapping("/ArtWorkCom")
    public String artWorkDetailComment(HttpServletRequest request, Model model, @CookieValue("username") String username, @CookieValue("workid") String workidstring){
        int workid = Integer.parseInt(workidstring);
        int userid = clubService.selectClubUserID(username);
        //发表艺术品评论
        String word = request.getParameter("word");
        commentService.insertArtWorkComment(userid,word,workid);
        commentService.updateComment(userid);
        //展示艺术品详情
        List<ArtWork> artWorkList = artWorkService.getArtWork(workid);
        model.addAttribute("ArtWork",artWorkList);
        //展示艺术品发布者名称
        List<User> userList = userService.getArtWorkUser(workid);
        model.addAttribute("ArtWorkUser",userList);
        //展示艺术品发布者头像
        List<User> userListImage = userService.getArtWorkUserImage(workid);
        model.addAttribute("ArtWorkUserImage",userListImage);
        //展示艺术品评论
        List<Comment> artWorkCommentList = commentService.getArtWorkComment(workid);
        model.addAttribute("ArtWorkComment",artWorkCommentList);
        //判断是否点赞
        List<Praise> artWorkPraiseList = praiseService.getArtWorkPraise(userid,workid);
        model.addAttribute("ArtWorkPraise",artWorkPraiseList);
        //判断是否关注用户
        List<Follow> artWorkFollowList = followService.getArtWorkFollow(userid,workid);
        model.addAttribute("ArtWorkFollow",artWorkFollowList);
        //展示消息推送通知
        int CountCommentWork = messageService.getCountCommentWork(userid);
        int CountCommentCol = messageService.getCountCommentCol(userid);
        int CountPraiseWork = messageService.getCountPraiseWork(userid);
        int CountPraiseCol = messageService.getCountPraiseCol(userid);
        int CountFollow = messageService.getCountFollow(userid);
        int CountShare = messageService.getCountShare(userid);
        int Count = CountCommentWork+CountCommentCol+CountPraiseWork+CountPraiseCol+CountFollow+CountShare;
        model.addAttribute("Count",Count);
        return "WorkDetails";
    }
    @RequestMapping("/ArtWorkShare")
    public String artWorkShare(HttpServletRequest request, Model model, @CookieValue("username") String username,@CookieValue("workid") String workidstring){
        int workid = Integer.parseInt(workidstring);
        int userid = clubService.selectClubUserID(username);
        int answerid = artWorkService.getArtWorkUserID(workid);
        String word = request.getParameter("word");
        //发表艺术品评论
        commentService.insertArtWorkComment(userid,word,workid);
        commentService.updateComment(userid);
        //艺术品分享
        shareService.insertShareWork(userid,word,answerid,workid);
        //展示艺术品详情
        List<ArtWork> artWorkList = artWorkService.getArtWork(workid);
        model.addAttribute("ArtWork",artWorkList);
        //展示艺术品发布者名称
        List<User> userList = userService.getArtWorkUser(workid);
        model.addAttribute("ArtWorkUser",userList);
        //展示艺术品发布者头像
        List<User> userListImage = userService.getArtWorkUserImage(workid);
        model.addAttribute("ArtWorkUserImage",userListImage);
        //展示艺术品评论
        List<Comment> artWorkCommentList = commentService.getArtWorkComment(workid);
        model.addAttribute("ArtWorkComment",artWorkCommentList);
        //判断是否点赞
        List<Praise> artWorkPraiseList = praiseService.getArtWorkPraise(userid,workid);
        model.addAttribute("ArtWorkPraise",artWorkPraiseList);
        //判断是否关注用户
        List<Follow> artWorkFollowList = followService.getArtWorkFollow(userid,workid);
        model.addAttribute("ArtWorkFollow",artWorkFollowList);
        //展示消息推送通知
        int CountCommentWork = messageService.getCountCommentWork(userid);
        int CountCommentCol = messageService.getCountCommentCol(userid);
        int CountPraiseWork = messageService.getCountPraiseWork(userid);
        int CountPraiseCol = messageService.getCountPraiseCol(userid);
        int CountFollow = messageService.getCountFollow(userid);
        int CountShare = messageService.getCountShare(userid);
        int Count = CountCommentWork+CountCommentCol+CountPraiseWork+CountPraiseCol+CountFollow+CountShare;
        model.addAttribute("Count",Count);
        return "WorkDetails";
    }
    @RequestMapping("/ArtWorkFollow")
    public String artWorkFollow(HttpServletRequest request, @CookieValue("username") String username, @CookieValue("workid") String workidstring){
        int userid = clubService.selectClubUserID(username);
        int workid = Integer.parseInt(workidstring);
        //更新艺术品用户关注
        String followclass = request.getParameter("followclass");
        if(followclass.equals("glyphicon glyphicon-plus-sign"))
        {
            String classname = "glyphicon glyphicon-minus-sign";
            followService.updateFollowWorkYes(classname,userid,workid);
        }
        else
        {
            String classname = "glyphicon glyphicon-plus-sign";
            followService.updateFollowWorkNo(classname,userid,workid);
        }
        return "WorkDetails";
    }
    @RequestMapping("/ArtWorkPraise")
    public String artWorkPraise(HttpServletRequest request, @CookieValue("username") String username, @CookieValue("workid") String workidstring){
        int userid = clubService.selectClubUserID(username);
        int workid = Integer.parseInt(workidstring);
        //更新艺术品点赞
        String praiseclass = request.getParameter("praiseclass");
        if(praiseclass.equals("glyphicon glyphicon-heart-empty"))
        {
            String classname = "glyphicon glyphicon-heart";
            praiseService.updateWorkPraiseYes(classname,userid,workid);
        }
        else
        {
            String classname = "glyphicon glyphicon-heart-empty";
            praiseService.updateWorkPraiseNo(classname,userid,workid);
        }
        return "WorkDetails";
    }
    @RequestMapping("/ArtWork")
    public String artWorkDetail(Model model, HttpServletRequest request, HttpServletResponse response,@CookieValue(value = "username",required = false) String username){
        if (username!=null && username!=""){
            int userid = clubService.selectClubUserID(username);
            String workidstring = request.getParameter("artwork");
            Cookie cookie = new Cookie("workid",workidstring);
            response.addCookie(cookie);
            cookie.setMaxAge(60*24*60);
            int workid = Integer.parseInt(workidstring);
            //展示艺术品详情
            List<ArtWork> artWorkList = artWorkService.getArtWork(workid);
            model.addAttribute("ArtWork",artWorkList);
            //展示艺术品发布者名称
            List<User> userList = userService.getArtWorkUser(workid);
            model.addAttribute("ArtWorkUser",userList);
            //展示艺术品发布者头像
            List<User> userListImage = userService.getArtWorkUserImage(workid);
            model.addAttribute("ArtWorkUserImage",userListImage);
            //展示艺术品评论
            List<Comment> artWorkCommentList = commentService.getArtWorkComment(workid);
            model.addAttribute("ArtWorkComment",artWorkCommentList);
            //判断是否点赞
            List<Praise> artWorkPraiseList = praiseService.getArtWorkPraise(userid,workid);
            model.addAttribute("ArtWorkPraise",artWorkPraiseList);
            //判断是否关注用户
            List<Follow> artWorkFollowList = followService.getArtWorkFollow(userid,workid);
            model.addAttribute("ArtWorkFollow",artWorkFollowList);
            //展示消息推送通知
            int CountCommentWork = messageService.getCountCommentWork(userid);
            int CountCommentCol = messageService.getCountCommentCol(userid);
            int CountPraiseWork = messageService.getCountPraiseWork(userid);
            int CountPraiseCol = messageService.getCountPraiseCol(userid);
            int CountFollow = messageService.getCountFollow(userid);
            int CountShare = messageService.getCountShare(userid);
            int Count = CountCommentWork+CountCommentCol+CountPraiseWork+CountPraiseCol+CountFollow+CountShare;
            model.addAttribute("Count",Count);
            return "WorkDetails";
        }
        else{
            return "LoginError";
        }
    }
}