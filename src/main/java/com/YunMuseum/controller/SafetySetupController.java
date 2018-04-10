package com.YunMuseum.controller;

import com.YunMuseum.model.ArtCol;
import com.YunMuseum.model.ArtWork;
import com.YunMuseum.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
/**
 * Created by zx G on 2017/4/16.
 */
@Controller
public class SafetySetupController {
    @Resource
    SetupService setupService;
    @Resource
    UserService userService;
    @Resource
    ClubService clubService;
    @Resource
    MessageService messageService;
    @Resource
    ArtWorkService artWorkService;
    @Resource
    ArtColService artColService;
    @RequestMapping("/SafetySetup")
    public String safetySetup(Model model, @CookieValue("username") String username){
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
        return "SafetySetup";
    }
    @RequestMapping("/PasswordChange")
    public String passwordChange(@RequestParam("password_old") String password_old,
                                 @RequestParam("password_new") String password_new,
                                 @CookieValue("username") String ticket,
                                 Model model){
        int userid = clubService.selectClubUserID(ticket);
        userService.selectPasswordByID(ticket);
        //更新密码
        Map<String,Object> map = setupService.CheckPassword(ticket,password_old);
        String msg = map.get("msg").toString();
        if(msg.equals("密码正确")){
            setupService.ChangePassword(ticket,password_new);
        }
        //展示个人发布的艺术品
        List<ArtWork> artWorkList = artWorkService.getArtWorkPerson(userid);
        model.addAttribute("ArtWork",artWorkList);
        //展示个人发布的艺术专栏
        List<ArtCol> artColList = artColService.getArtColPerson(userid);
        model.addAttribute("ArtCol",artColList);
        //展示消息推送通知
        int CountCommentWork = messageService.getCountCommentWork(userid);
        int CountCommentCol = messageService.getCountCommentCol(userid);
        int CountPraiseWork = messageService.getCountPraiseWork(userid);
        int CountPraiseCol = messageService.getCountPraiseCol(userid);
        int CountFollow = messageService.getCountFollow(userid);
        int CountShare = messageService.getCountShare(userid);
        int Count = CountCommentWork+CountCommentCol+CountPraiseWork+CountPraiseCol+CountFollow+CountShare;
        model.addAttribute("Count",Count);
        return "MyArt";
    }
}
