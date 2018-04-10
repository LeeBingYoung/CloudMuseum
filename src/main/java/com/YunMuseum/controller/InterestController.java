package com.YunMuseum.controller;

import com.YunMuseum.model.Interest;
import com.YunMuseum.model.InterestShareWork;
import com.YunMuseum.service.ClubService;
import com.YunMuseum.service.InterestService;
import com.YunMuseum.service.InterestShareWorkService;
import com.YunMuseum.service.MessageService;
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
public class InterestController {
    @Resource
    InterestService interestService;
    @Resource
    ClubService clubService;
    @Resource
    MessageService messageService;
    @Resource
    InterestShareWorkService interestShareWorkService;
    @RequestMapping("/Interest")
    public String interest(Model model, @CookieValue(value = "username", required = false) String username){
        if (username != null && username != ""){
            int userid = clubService.selectClubUserID(username);
            //展示用户加入的兴趣圈信息
            List<Interest> interestYesList = interestService.getInterestInfoYes(userid);
            model.addAttribute("InterestYes",interestYesList);
            //展示消息推送通知
            int CountCommentWork = messageService.getCountCommentWork(userid);
            int CountCommentCol = messageService.getCountCommentCol(userid);
            int CountPraiseWork = messageService.getCountPraiseWork(userid);
            int CountPraiseCol = messageService.getCountPraiseCol(userid);
            int CountFollow = messageService.getCountFollow(userid);
            int CountShare = messageService.getCountShare(userid);
            int Count = CountCommentWork+CountCommentCol+CountPraiseWork+CountPraiseCol+CountFollow+CountShare;
            model.addAttribute("Count",Count);
            return "Interest";
        }
        else {
            return "LoginError";
        }
    }
    @RequestMapping("/InterestAll")
    public String interestAll(Model model, @CookieValue(value = "username", required = false) String username){
        if (username != null && username != ""){
            int userid = clubService.selectClubUserID(username);
            //展示用户未加入的兴趣圈信息
            List<Interest> interestNoList = interestService.getInterestInfoNo(userid);
            model.addAttribute("InterestNo",interestNoList);
            //展示消息推送通知
            int CountCommentWork = messageService.getCountCommentWork(userid);
            int CountCommentCol = messageService.getCountCommentCol(userid);
            int CountPraiseWork = messageService.getCountPraiseWork(userid);
            int CountPraiseCol = messageService.getCountPraiseCol(userid);
            int CountFollow = messageService.getCountFollow(userid);
            int CountShare = messageService.getCountShare(userid);
            int Count = CountCommentWork+CountCommentCol+CountPraiseWork+CountPraiseCol+CountFollow+CountShare;
            model.addAttribute("Count",Count);
            return "Interest";
        }
        else {
            return "LoginError";
        }
    }
    @RequestMapping("/InterestAdd")
    public String interestAdd(Model model, @CookieValue("username") String username, HttpServletRequest request, HttpServletResponse response){
        String interestidstring = request.getParameter("interestid");
        int interestid = Integer.parseInt(interestidstring);
        int userid = clubService.selectClubUserID(username);
        Cookie cookie = new Cookie("interestidstring",interestidstring);
        response.addCookie(cookie);
        cookie.setMaxAge(60*24*60);
        //用户加入兴趣圈
        interestService.insertInterest(interestid,userid);
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
    @RequestMapping("/InterestOut")
    public String interestOut(Model model, @CookieValue("username") String username, HttpServletRequest request){
        String interestidstring = request.getParameter("interestid");
        int interestid = Integer.parseInt(interestidstring);
        int userid = clubService.selectClubUserID(username);
        //用户退出兴趣圈
        interestService.deleteInterest(interestid,userid);
        //展示用户加入的兴趣圈信息
        List<Interest> interestYesList = interestService.getInterestInfoYes(userid);
        model.addAttribute("InterestYes",interestYesList);
        //展示消息推送通知
        int CountCommentWork = messageService.getCountCommentWork(userid);
        int CountCommentCol = messageService.getCountCommentCol(userid);
        int CountPraiseWork = messageService.getCountPraiseWork(userid);
        int CountPraiseCol = messageService.getCountPraiseCol(userid);
        int CountFollow = messageService.getCountFollow(userid);
        int CountShare = messageService.getCountShare(userid);
        int Count = CountCommentWork+CountCommentCol+CountPraiseWork+CountPraiseCol+CountFollow+CountShare;
        model.addAttribute("Count",Count);
        return "Interest";
    }
}
