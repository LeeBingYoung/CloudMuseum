package com.YunMuseum.controller;

import com.YunMuseum.service.ClubService;
import com.YunMuseum.service.MessageService;
import com.YunMuseum.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import java.util.Map;
/**
 * Created by Test Guo on 2017/5/18.
 */
@Controller
public class NoIdentityController {
    @Resource
    UserService userService;
    @Resource
    MessageService messageService;
    @Resource
    ClubService clubService;
    @RequestMapping("/Identity")
    public String noIdentity(@CookieValue("username") String username, Model model){
        userService.getIdentity(username);
        Map<String, Object> map = userService.status(username);
        String msg = map.get("msg_status").toString();
        if (msg.equals("实名认证")) {
            int userid = clubService.selectClubUserID(username);
            //展示消息推送通知
            int CountCommentWork = messageService.getCountCommentWork(userid);
            int CountCommentCol = messageService.getCountCommentCol(userid);
            int CountPraiseWork = messageService.getCountPraiseWork(userid);
            int CountPraiseCol = messageService.getCountPraiseCol(userid);
            int CountFollow = messageService.getCountFollow(userid);
            int CountShare = messageService.getCountShare(userid);
            int Count = CountCommentWork+CountCommentCol+CountPraiseWork+CountPraiseCol+CountFollow+CountShare;
            model.addAttribute("Count",Count);
            return "UploadColumn";
        }
        else{
            int userid = clubService.selectClubUserID(username);
            //展示消息推送通知
            int CountCommentWork = messageService.getCountCommentWork(userid);
            int CountCommentCol = messageService.getCountCommentCol(userid);
            int CountPraiseWork = messageService.getCountPraiseWork(userid);
            int CountPraiseCol = messageService.getCountPraiseCol(userid);
            int CountFollow = messageService.getCountFollow(userid);
            int CountShare = messageService.getCountShare(userid);
            int Count = CountCommentWork+CountCommentCol+CountPraiseWork+CountPraiseCol+CountFollow+CountShare;
            model.addAttribute("Count",Count);
            return "NoIdentified";
        }
    }
}
