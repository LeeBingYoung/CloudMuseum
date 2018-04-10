package com.YunMuseum.controller;

import com.YunMuseum.model.*;
import com.YunMuseum.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import java.util.List;
/**
 * Created by Test Guo on 2017/5/2.
 */
@Controller
public class MessageController {
    @Resource
    CommentService commentService;
    @Resource
    UserService userService;
    @Resource
    ArtWorkPraiseService artWorkPraiseService;
    @Resource
    ArtColPraiseService artColPraiseService;
    @Resource
    ShareViewService shareViewService;
    @Resource
    ClubService clubService;
    @Resource
    FollowService followService;
    @Resource
    PraiseService praiseService;
    @Resource
    ShareService shareService;
    @Resource
    ArtWorkCommentService artWorkCommentService;
    @Resource
    ArtColCommentService artColCommentService;
    @Resource
    MessageService messageService;
    @RequestMapping("/Message")
    public String message(Model model, @CookieValue("username") String username){
        int userid = clubService.selectClubUserID(username);
        //展示艺术品未读评论
        List<ArtWorkComment> artWorkCommentReadList = artWorkCommentService.getArtWorkCommentRead(userid);
        model.addAttribute("ArtWorkComment",artWorkCommentReadList);
        //展示艺术专栏未读评论
        List<ArtColComment> artColCommentReadList = artColCommentService.getArtColCommentRead(userid);
        model.addAttribute("ArtColComment",artColCommentReadList);
        //展示艺术品新增点赞
        List<ArtWorkPraise> artWorkPraiseList = artWorkPraiseService.getArtWorkPraise(userid);
        model.addAttribute("ArtWorkPraise",artWorkPraiseList);
        //展示艺术专栏新增点赞
        List<ArtColPraise> artColPraiseList = artColPraiseService.getArtColPraise(userid);
        model.addAttribute("ArtColPraise",artColPraiseList);
        //展示新增关注
        List<User> followList = userService.getFollow(userid);
        model.addAttribute("Follow",followList);
        //展示发布者看到的新增艺术品转发
        List<ShareWorkView> artWorkSharePublisherList = shareViewService.getArtWorkSharePublisher(userid);
        model.addAttribute("ShareWorkPublisher",artWorkSharePublisherList);
        //展示发布者看到的新增艺术专栏转发
        List<ShareColView> artColSharePublisherList = shareViewService.getArtColSharePublisher(userid);
        model.addAttribute("ShareColPublisher",artColSharePublisherList);
        //展示消息推送通知
        int CountCommentWork = messageService.getCountCommentWork(userid);
        int CountCommentCol = messageService.getCountCommentCol(userid);
        int CountPraiseWork = messageService.getCountPraiseWork(userid);
        int CountPraiseCol = messageService.getCountPraiseCol(userid);
        int CountFollow = messageService.getCountFollow(userid);
        int CountShare = messageService.getCountShare(userid);
        int Count = CountCommentWork+CountCommentCol+CountPraiseWork+CountPraiseCol+CountFollow+CountShare;
        model.addAttribute("Count",Count);
        return "Message";
    }
    @RequestMapping("/MessageFollow")
    public String messageFollow(Model model, @CookieValue("username") String username){
        int userid = clubService.selectClubUserID(username);
        //更新新增关注为已读
        followService.updateFollow(userid);
        //展示艺术品未读评论
        List<ArtWorkComment> artWorkCommentReadList = artWorkCommentService.getArtWorkCommentRead(userid);
        model.addAttribute("ArtWorkComment",artWorkCommentReadList);
        //展示艺术专栏未读评论
        List<ArtColComment> artColCommentReadList = artColCommentService.getArtColCommentRead(userid);
        model.addAttribute("ArtColComment",artColCommentReadList);
        //展示艺术品新增点赞
        List<ArtWorkPraise> artWorkPraiseList = artWorkPraiseService.getArtWorkPraise(userid);
        model.addAttribute("ArtWorkPraise",artWorkPraiseList);
        //展示艺术专栏新增点赞
        List<ArtColPraise> artColPraiseList = artColPraiseService.getArtColPraise(userid);
        model.addAttribute("ArtColPraise",artColPraiseList);
        //展示新增关注
        List<User> followList = userService.getFollow(userid);
        model.addAttribute("Follow",followList);
        //展示发布者看到的新增艺术品转发
        List<ShareWorkView> artWorkSharePublisherList = shareViewService.getArtWorkSharePublisher(userid);
        model.addAttribute("ShareWorkPublisher",artWorkSharePublisherList);
        //展示发布者看到的新增艺术专栏转发
        List<ShareColView> artColSharePublisherList = shareViewService.getArtColSharePublisher(userid);
        model.addAttribute("ShareColPublisher",artColSharePublisherList);
        //展示消息推送通知
        int CountCommentWork = messageService.getCountCommentWork(userid);
        int CountCommentCol = messageService.getCountCommentCol(userid);
        int CountPraiseWork = messageService.getCountPraiseWork(userid);
        int CountPraiseCol = messageService.getCountPraiseCol(userid);
        int CountFollow = messageService.getCountFollow(userid);
        int CountShare = messageService.getCountShare(userid);
        int Count = CountCommentWork+CountCommentCol+CountPraiseWork+CountPraiseCol+CountFollow+CountShare;
        model.addAttribute("Count",Count);
        return "Message";
    }
    @RequestMapping("/MessagePraise")
    public String messagePraise(Model model, @CookieValue("username") String username){
        int userid = clubService.selectClubUserID(username);
        //更新新增点赞为已读
        praiseService.updateWorkPraise(userid);
        praiseService.updateColPraise(userid);
        //展示艺术品未读评论
        List<ArtWorkComment> artWorkCommentReadList = artWorkCommentService.getArtWorkCommentRead(userid);
        model.addAttribute("ArtWorkComment",artWorkCommentReadList);
        //展示艺术专栏未读评论
        List<ArtColComment> artColCommentReadList = artColCommentService.getArtColCommentRead(userid);
        model.addAttribute("ArtColComment",artColCommentReadList);
        //展示艺术品新增点赞
        List<ArtWorkPraise> artWorkPraiseList = artWorkPraiseService.getArtWorkPraise(userid);
        model.addAttribute("ArtWorkPraise",artWorkPraiseList);
        //展示艺术专栏新增点赞
        List<ArtColPraise> artColPraiseList = artColPraiseService.getArtColPraise(userid);
        model.addAttribute("ArtColPraise",artColPraiseList);
        //展示新增关注
        List<User> followList = userService.getFollow(userid);
        model.addAttribute("Follow",followList);
        //展示发布者看到的新增艺术品转发
        List<ShareWorkView> artWorkSharePublisherList = shareViewService.getArtWorkSharePublisher(userid);
        model.addAttribute("ShareWorkPublisher",artWorkSharePublisherList);
        //展示发布者看到的新增艺术专栏转发
        List<ShareColView> artColSharePublisherList = shareViewService.getArtColSharePublisher(userid);
        model.addAttribute("ShareColPublisher",artColSharePublisherList);
        //展示消息推送通知
        int CountCommentWork = messageService.getCountCommentWork(userid);
        int CountCommentCol = messageService.getCountCommentCol(userid);
        int CountPraiseWork = messageService.getCountPraiseWork(userid);
        int CountPraiseCol = messageService.getCountPraiseCol(userid);
        int CountFollow = messageService.getCountFollow(userid);
        int CountShare = messageService.getCountShare(userid);
        int Count = CountCommentWork+CountCommentCol+CountPraiseWork+CountPraiseCol+CountFollow+CountShare;
        model.addAttribute("Count",Count);
        return "Message";
    }
    @RequestMapping("/MessageShare")
    public String messageShare(Model model, @CookieValue("username") String username){
        int userid = clubService.selectClubUserID(username);
        //更新新增分享为已读
        shareService.updateShare(userid);
        //展示艺术品未读评论
        List<ArtWorkComment> artWorkCommentReadList = artWorkCommentService.getArtWorkCommentRead(userid);
        model.addAttribute("ArtWorkComment",artWorkCommentReadList);
        //展示艺术专栏未读评论
        List<ArtColComment> artColCommentReadList = artColCommentService.getArtColCommentRead(userid);
        model.addAttribute("ArtColComment",artColCommentReadList);
        //展示艺术品新增点赞
        List<ArtWorkPraise> artWorkPraiseList = artWorkPraiseService.getArtWorkPraise(userid);
        model.addAttribute("ArtWorkPraise",artWorkPraiseList);
        //展示艺术专栏新增点赞
        List<ArtColPraise> artColPraiseList = artColPraiseService.getArtColPraise(userid);
        model.addAttribute("ArtColPraise",artColPraiseList);
        //展示新增关注
        List<User> followList = userService.getFollow(userid);
        model.addAttribute("Follow",followList);
        //展示发布者看到的新增艺术品转发
        List<ShareWorkView> artWorkSharePublisherList = shareViewService.getArtWorkSharePublisher(userid);
        model.addAttribute("ShareWorkPublisher",artWorkSharePublisherList);
        //展示发布者看到的新增艺术专栏转发
        List<ShareColView> artColSharePublisherList = shareViewService.getArtColSharePublisher(userid);
        model.addAttribute("ShareColPublisher",artColSharePublisherList);
        //展示消息推送通知
        int CountCommentWork = messageService.getCountCommentWork(userid);
        int CountCommentCol = messageService.getCountCommentCol(userid);
        int CountPraiseWork = messageService.getCountPraiseWork(userid);
        int CountPraiseCol = messageService.getCountPraiseCol(userid);
        int CountFollow = messageService.getCountFollow(userid);
        int CountShare = messageService.getCountShare(userid);
        int Count = CountCommentWork+CountCommentCol+CountPraiseWork+CountPraiseCol+CountFollow+CountShare;
        model.addAttribute("Count",Count);
        return "Message";
    }
    @RequestMapping("/MessageComment")
    public String messageComment(Model model, @CookieValue("username") String username){
        int userid = clubService.selectClubUserID(username);
        //更新新增新增为已读
        commentService.updateArtWorkComment(userid);
        commentService.updateArtColComment(userid);
        //展示艺术品未读评论
        List<ArtWorkComment> artWorkCommentReadList = artWorkCommentService.getArtWorkCommentRead(userid);
        model.addAttribute("ArtWorkComment",artWorkCommentReadList);
        //展示艺术专栏未读评论
        List<ArtColComment> artColCommentReadList = artColCommentService.getArtColCommentRead(userid);
        model.addAttribute("ArtColComment",artColCommentReadList);
        //展示艺术品新增点赞
        List<ArtWorkPraise> artWorkPraiseList = artWorkPraiseService.getArtWorkPraise(userid);
        model.addAttribute("ArtWorkPraise",artWorkPraiseList);
        //展示艺术专栏新增点赞
        List<ArtColPraise> artColPraiseList = artColPraiseService.getArtColPraise(userid);
        model.addAttribute("ArtColPraise",artColPraiseList);
        //展示新增关注
        List<User> followList = userService.getFollow(userid);
        model.addAttribute("Follow",followList);
        //展示发布者看到的新增艺术品转发
        List<ShareWorkView> artWorkSharePublisherList = shareViewService.getArtWorkSharePublisher(userid);
        model.addAttribute("ShareWorkPublisher",artWorkSharePublisherList);
        //展示发布者看到的新增艺术专栏转发
        List<ShareColView> artColSharePublisherList = shareViewService.getArtColSharePublisher(userid);
        model.addAttribute("ShareColPublisher",artColSharePublisherList);
        //展示消息推送通知
        int CountCommentWork = messageService.getCountCommentWork(userid);
        int CountCommentCol = messageService.getCountCommentCol(userid);
        int CountPraiseWork = messageService.getCountPraiseWork(userid);
        int CountPraiseCol = messageService.getCountPraiseCol(userid);
        int CountFollow = messageService.getCountFollow(userid);
        int CountShare = messageService.getCountShare(userid);
        int Count = CountCommentWork+CountCommentCol+CountPraiseWork+CountPraiseCol+CountFollow+CountShare;
        model.addAttribute("Count",Count);
        return "Message";
    }
}
