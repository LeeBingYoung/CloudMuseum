package com.YunMuseum.controller;

import com.YunMuseum.model.Comment;
import com.YunMuseum.model.Interest;
import com.YunMuseum.model.InterestShareWork;
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
 * Created by zx G on 2017/5/6.
 */
@Controller
public class InterestHomeController {
    @Resource
    InterestShareWorkService interestShareWorkService;
    @Resource
    CommentService commentService;
    @Resource
    ClubService clubService;
    @Resource
    ArtWorkService artWorkService;
    @Resource
    ShareService shareService;
    @Resource
    InterestService interestService;
    @Resource
    MessageService messageService;
    @RequestMapping("/InterestCommentSend")
    public String interestCommentSend(Model model, HttpServletRequest request, @CookieValue("interestworkidstring") String interestworkidstring, @CookieValue("username") String username){
        int workid = Integer.parseInt(interestworkidstring);
        int userid = clubService.selectClubUserID(username);
        String word = request.getParameter("interestcomment");
        //发表艺术品评论
        commentService.insertArtWorkComment(userid,word,workid);
        commentService.updateComment(userid);
        //展示分享的兴趣圈评论
        List<Comment> commentList = commentService.getInterestWorkComment(workid);
        model.addAttribute("Comment",commentList);
        //展示消息推送通知
        int CountCommentWork = messageService.getCountCommentWork(userid);
        int CountCommentCol = messageService.getCountCommentCol(userid);
        int CountPraiseWork = messageService.getCountPraiseWork(userid);
        int CountPraiseCol = messageService.getCountPraiseCol(userid);
        int CountFollow = messageService.getCountFollow(userid);
        int CountShare = messageService.getCountShare(userid);
        int Count = CountCommentWork+CountCommentCol+CountPraiseWork+CountPraiseCol+CountFollow+CountShare;
        model.addAttribute("Count",Count);
        return "InterestComment";
    }
    @RequestMapping("/InterestComment")
    public String interestComment(Model model, HttpServletRequest request, HttpServletResponse response, @CookieValue("username") String username){
        int userid = clubService.selectClubUserID(username);
        String workidstring = request.getParameter("interestworkid");
        int workid = Integer.parseInt(workidstring);
        Cookie cookie = new Cookie("interestworkidstring",workidstring);
        response.addCookie(cookie);
        cookie.setMaxAge(60*24*60);
        //展示分享的兴趣圈评论
        List<Comment> commentList = commentService.getInterestWorkComment(workid);
        model.addAttribute("Comment",commentList);
        //展示消息推送通知
        int CountCommentWork = messageService.getCountCommentWork(userid);
        int CountCommentCol = messageService.getCountCommentCol(userid);
        int CountPraiseWork = messageService.getCountPraiseWork(userid);
        int CountPraiseCol = messageService.getCountPraiseCol(userid);
        int CountFollow = messageService.getCountFollow(userid);
        int CountShare = messageService.getCountShare(userid);
        int Count = CountCommentWork+CountCommentCol+CountPraiseWork+CountPraiseCol+CountFollow+CountShare;
        model.addAttribute("Count",Count);
        return "InterestComment";
    }
    @RequestMapping("/InterestHome")
    public String interestShareWork(Model model, HttpServletRequest request, HttpServletResponse response, @CookieValue("username") String username){
        int userid = clubService.selectClubUserID(username);
        String interestidstring = request.getParameter("interestid");
        int interestid = Integer.parseInt(interestidstring);
        Cookie cookie = new Cookie("interestidstring",interestidstring);
        response.addCookie(cookie);
        cookie.setMaxAge(60*24*60);
        //展示所有的兴趣圈信息
        List<InterestShareWork> interestShareWorkList = interestShareWorkService.getInterestShareWork(interestid);
        model.addAttribute("InterestShareWork",interestShareWorkList);
        //展示兴趣圈详情
        List<Interest> interestList = interestService.getInterest(interestid);
        model.addAttribute("Interest",interestList);
        //展示已加入按钮
        String but = "已加入";
        model.addAttribute("but",but);
        //展示消息推送通知
        int CountCommentWork = messageService.getCountCommentWork(userid);
        int CountCommentCol = messageService.getCountCommentCol(userid);
        int CountPraiseWork = messageService.getCountPraiseWork(userid);
        int CountPraiseCol = messageService.getCountPraiseCol(userid);
        int CountFollow = messageService.getCountFollow(userid);
        int CountShare = messageService.getCountShare(userid);
        int Count = CountCommentWork+CountCommentCol+CountPraiseWork+CountPraiseCol+CountFollow+CountShare;
        model.addAttribute("Count",Count);
        //展示兴趣圈关注人数
        int CountInterestMember = interestService.getCountInterestMember(interestid);
        model.addAttribute("CountInterestMember",CountInterestMember);
        return "InterestHome";
    }
    @RequestMapping("/InterestHomeNo")
    public String interestShareWorkNo(Model model, HttpServletRequest request, HttpServletResponse response, @CookieValue("username") String username){
        int userid = clubService.selectClubUserID(username);
        String interestidstring = request.getParameter("interestid");
        int interestid = Integer.parseInt(interestidstring);
        Cookie cookie = new Cookie("interestidstring",interestidstring);
        response.addCookie(cookie);
        cookie.setMaxAge(60*24*60);
        //展示所有的兴趣圈信息
        List<InterestShareWork> interestShareWorkList = interestShareWorkService.getInterestShareWork(interestid);
        model.addAttribute("InterestShareWork",interestShareWorkList);
        //展示兴趣圈详情
        List<Interest> interestList = interestService.getInterest(interestid);
        model.addAttribute("Interest",interestList);
        //展示已加入按钮
        String but = "加入";
        model.addAttribute("but",but);
        //展示消息推送通知
        int CountCommentWork = messageService.getCountCommentWork(userid);
        int CountCommentCol = messageService.getCountCommentCol(userid);
        int CountPraiseWork = messageService.getCountPraiseWork(userid);
        int CountPraiseCol = messageService.getCountPraiseCol(userid);
        int CountFollow = messageService.getCountFollow(userid);
        int CountShare = messageService.getCountShare(userid);
        int Count = CountCommentWork+CountCommentCol+CountPraiseWork+CountPraiseCol+CountFollow+CountShare;
        model.addAttribute("Count",Count);
        //展示兴趣圈关注人数
        int CountInterestMember = interestService.getCountInterestMember(interestid);
        model.addAttribute("CountInterestMember",CountInterestMember);
        return "InterestHome";
    }
    @RequestMapping("/InterestHomeShare")
    public String interestHomeShare(Model model, HttpServletRequest request, @CookieValue("username") String username, @CookieValue("interestidstring") String interestidstring){
        int interestid = Integer.parseInt(interestidstring);
        String workidstring = request.getParameter("interestworkid");
        int workid = Integer.parseInt(workidstring);
        int userid = clubService.selectClubUserID(username);
        int answerid = artWorkService.getArtWorkUserID(workid);
        String word = "转发";
        //兴趣圈分享
        shareService.insertShareWork(userid,word,answerid,workid);
        //展示所有的兴趣圈信息
        List<InterestShareWork> interestShareWorkList = interestShareWorkService.getInterestShareWork(interestid);
        model.addAttribute("InterestShareWork",interestShareWorkList);
        //展示兴趣圈详情
        List<Interest> interestList = interestService.getInterest(interestid);
        model.addAttribute("Interest",interestList);
        //展示已加入按钮
        String but = "加入";
        model.addAttribute("but",but);
        //展示消息推送通知
        int CountCommentWork = messageService.getCountCommentWork(userid);
        int CountCommentCol = messageService.getCountCommentCol(userid);
        int CountPraiseWork = messageService.getCountPraiseWork(userid);
        int CountPraiseCol = messageService.getCountPraiseCol(userid);
        int CountFollow = messageService.getCountFollow(userid);
        int CountShare = messageService.getCountShare(userid);
        int Count = CountCommentWork+CountCommentCol+CountPraiseWork+CountPraiseCol+CountFollow+CountShare;
        model.addAttribute("Count",Count);
        //展示兴趣圈关注人数
        int CountInterestMember = interestService.getCountInterestMember(interestid);
        model.addAttribute("CountInterestMember",CountInterestMember);
        return "InterestHome";
    }
    @RequestMapping("/InterestHomeAdd")
    public String interestHomeAdd(@CookieValue("username") String username, @CookieValue("interestidstring") String interestidstring){
        int interestid = Integer.parseInt(interestidstring);
        int userid = clubService.selectClubUserID(username);
        //用户加入兴趣圈
        interestService.insertInterest(interestid,userid);
        return "InterestHome";
    }
}
