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
 * Created by Test Guo on 2017/4/12.
 */
@Controller
public class ArtStoryController {
    @Resource
    ArtStoryService artStoryService;
    @Resource
    ArtStoryPageService artStoryPageService;
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
    @RequestMapping("/ArtStoryCom")
    public String artStoryComment(HttpServletRequest request, Model model, @CookieValue("username") String username,@CookieValue("stoid") String stoidstring){
        int stoid = Integer.parseInt(stoidstring);
        int userid = clubService.selectClubUserID(username);
        //发表艺术故事评论
        String word=request.getParameter("word");
        commentService.insertArtStoryComment(userid,word,stoid);
        commentService.updateComment(userid);
        //展示艺术故事详情
        List<ArtStory> artStoryList = artStoryService.getArtStory(stoid);
        model.addAttribute("ArtStory",artStoryList);
        //展示艺术故事第一张轮播图
        List<ArtStoryPage> artStoryFirstPageList = artStoryPageService.getArtStoryFirstPage(stoid);
        model.addAttribute("ArtStoryFirstPage",artStoryFirstPageList);
        //展示艺术故事其余轮播图
        List<ArtStoryPage> artStoryPageList = artStoryPageService.getArtStoryPage(stoid);
        model.addAttribute("ArtStoryPage",artStoryPageList);
        //展示艺术故事评论
        List<Comment> artStoryCommentList = commentService.getArtStoryComment(stoid);
        model.addAttribute("ArtStoryComment",artStoryCommentList);
        //判断是否点赞
        List<Praise> artStoPraiseList = praiseService.getArtStoPraise(userid,stoid);
        model.addAttribute("ArtStoPraise",artStoPraiseList);
        //判断是否关注用户
        List<Follow> artStoFollowList = followService.getArtStoFollow(userid,stoid);
        model.addAttribute("ArtStoFollow",artStoFollowList);
        //展示消息推送通知
        int CountCommentWork = messageService.getCountCommentWork(userid);
        int CountCommentCol = messageService.getCountCommentCol(userid);
        int CountPraiseWork = messageService.getCountPraiseWork(userid);
        int CountPraiseCol = messageService.getCountPraiseCol(userid);
        int CountFollow = messageService.getCountFollow(userid);
        int CountShare = messageService.getCountShare(userid);
        int Count = CountCommentWork+CountCommentCol+CountPraiseWork+CountPraiseCol+CountFollow+CountShare;
        model.addAttribute("Count",Count);
        return "StoryDetails";
    }
    @RequestMapping("/ArtStoryShare")
    public String artStoryShare(HttpServletRequest request, Model model, @CookieValue("username") String username,@CookieValue("stoid") String stoidstring){
        int stoid = Integer.parseInt(stoidstring);
        int userid = clubService.selectClubUserID(username);
        String word=request.getParameter("word");
        //发表艺术故事评论
        commentService.insertArtStoryComment(userid,word,stoid);
        commentService.updateComment(userid);
        //艺术故事分享
        shareService.insertShareSto(userid,word,stoid);
        //展示艺术故事详情
        List<ArtStory> artStoryList = artStoryService.getArtStory(stoid);
        model.addAttribute("ArtStory",artStoryList);
        //展示艺术故事第一张轮播图
        List<ArtStoryPage> artStoryFirstPageList = artStoryPageService.getArtStoryFirstPage(stoid);
        model.addAttribute("ArtStoryFirstPage",artStoryFirstPageList);
        //展示艺术故事其余轮播图
        List<ArtStoryPage> artStoryPageList = artStoryPageService.getArtStoryPage(stoid);
        model.addAttribute("ArtStoryPage",artStoryPageList);
        //展示艺术故事评论
        List<Comment> artStoryCommentList = commentService.getArtStoryComment(stoid);
        model.addAttribute("ArtStoryComment",artStoryCommentList);
        //判断是否点赞
        List<Praise> artStoPraiseList = praiseService.getArtStoPraise(userid,stoid);
        model.addAttribute("ArtStoPraise",artStoPraiseList);
        //判断是否关注用户
        List<Follow> artStoFollowList = followService.getArtStoFollow(userid,stoid);
        model.addAttribute("ArtStoFollow",artStoFollowList);
        //展示消息推送通知
        int CountCommentWork = messageService.getCountCommentWork(userid);
        int CountCommentCol = messageService.getCountCommentCol(userid);
        int CountPraiseWork = messageService.getCountPraiseWork(userid);
        int CountPraiseCol = messageService.getCountPraiseCol(userid);
        int CountFollow = messageService.getCountFollow(userid);
        int CountShare = messageService.getCountShare(userid);
        int Count = CountCommentWork+CountCommentCol+CountPraiseWork+CountPraiseCol+CountFollow+CountShare;
        model.addAttribute("Count",Count);
        return "StoryDetails";
    }
    @RequestMapping("/ArtStoryFollow")
    public String artStoryFollow(Model model, HttpServletRequest request, @CookieValue("username") String username, @CookieValue("stoid") String stoidstring){
        int stoid = Integer.parseInt(stoidstring);
        int userid = clubService.selectClubUserID(username);
        //更新艺术故事关注
        String followclass = request.getParameter("followclass");
        if(followclass.equals("glyphicon glyphicon-plus-sign"))
        {
            String classname = "glyphicon glyphicon-minus-sign";
            followService.updateFollowStoYes(classname,userid,stoid);
        }
        else
        {
            String classname = "glyphicon glyphicon-plus-sign";
            followService.updateFollowStoNo(classname,userid,stoid);
        }
        return "StoryDetails";
    }
    @RequestMapping("/ArtStoryPraise")
    public String artStoryPraise(Model model, HttpServletRequest request, @CookieValue("username") String username, @CookieValue("stoid") String stoidstring){
        int stoid = Integer.parseInt(stoidstring);
        int userid = clubService.selectClubUserID(username);
        //更新艺术故事点赞
        String praiseclass = request.getParameter("praiseclass");
        if(praiseclass.equals("glyphicon glyphicon-heart-empty"))
        {
            String classname = "glyphicon glyphicon-heart";
            praiseService.updateStoPraiseYes(classname,userid,stoid);
        }
        else
        {
            String classname = "glyphicon glyphicon-heart-empty";
            praiseService.updateStoPraiseNo(classname,userid,stoid);
        }
        return "StoryDetails";
    }
    @RequestMapping("/ArtStory")
    public String artStory(Model model, HttpServletRequest request, HttpServletResponse response, @CookieValue(value = "username",required = false) String username){
        if (username!=null && username!=""){
            String stoidstring = request.getParameter("artsto");
            Cookie cookie = new Cookie("stoid",stoidstring);
            response.addCookie(cookie);
            cookie.setMaxAge(60*24*60);
            int stoid = Integer.parseInt(stoidstring);
            int userid = clubService.selectClubUserID(username);
            //展示艺术故事详情
            List<ArtStory> artStoryList = artStoryService.getArtStory(stoid);
            model.addAttribute("ArtStory",artStoryList);
            //展示艺术故事第一张轮播图
            List<ArtStoryPage> artStoryFirstPageList = artStoryPageService.getArtStoryFirstPage(stoid);
            model.addAttribute("ArtStoryFirstPage",artStoryFirstPageList);
            //展示艺术故事其余轮播图
            List<ArtStoryPage> artStoryPageList = artStoryPageService.getArtStoryPage(stoid);
            model.addAttribute("ArtStoryPage",artStoryPageList);
            //展示艺术故事评论
            List<Comment> artStoryCommentList = commentService.getArtStoryComment(stoid);
            model.addAttribute("ArtStoryComment",artStoryCommentList);
            //判断是否点赞
            List<Praise> artStoPraiseList = praiseService.getArtStoPraise(userid,stoid);
            model.addAttribute("ArtStoPraise",artStoPraiseList);
            //判断是否关注用户
            List<Follow> artStoFollowList = followService.getArtStoFollow(userid,stoid);
            model.addAttribute("ArtStoFollow",artStoFollowList);
            //展示消息推送通知
            int CountCommentWork = messageService.getCountCommentWork(userid);
            int CountCommentCol = messageService.getCountCommentCol(userid);
            int CountPraiseWork = messageService.getCountPraiseWork(userid);
            int CountPraiseCol = messageService.getCountPraiseCol(userid);
            int CountFollow = messageService.getCountFollow(userid);
            int CountShare = messageService.getCountShare(userid);
            int Count = CountCommentWork+CountCommentCol+CountPraiseWork+CountPraiseCol+CountFollow+CountShare;
            model.addAttribute("Count",Count);
            return "StoryDetails";
        }
        else {
            return "LoginError";
        }
    }
}
