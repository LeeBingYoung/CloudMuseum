package com.YunMuseum.controller;

import com.YunMuseum.model.User;
import com.YunMuseum.service.ClubService;
import com.YunMuseum.service.MessageService;
import com.YunMuseum.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import java.util.List;
/**
 * Created by zx G on 2017/5/10.
 */
@Controller
public class InterestMemberController {
    @Resource
    UserService userService;
    @Resource
    MessageService messageService;
    @Resource
    ClubService clubService;
    @RequestMapping("/InterestMember")
    public String interestMember(Model model, @CookieValue("interestidstring") String interestidstring, @CookieValue("username") String username){
        int interestid = Integer.parseInt(interestidstring);
        int userid = clubService.selectClubUserID(username);
        //展示兴趣圈用户信息
        List<User> userList = userService.getInterestMember(interestid);
        model.addAttribute("InterestMember",userList);
        //展示消息推送通知
        int CountCommentWork = messageService.getCountCommentWork(userid);
        int CountCommentCol = messageService.getCountCommentCol(userid);
        int CountPraiseWork = messageService.getCountPraiseWork(userid);
        int CountPraiseCol = messageService.getCountPraiseCol(userid);
        int CountFollow = messageService.getCountFollow(userid);
        int CountShare = messageService.getCountShare(userid);
        int Count = CountCommentWork+CountCommentCol+CountPraiseWork+CountPraiseCol+CountFollow+CountShare;
        model.addAttribute("Count",Count);
        return "InterestMember";
    }
}
