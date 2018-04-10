package com.YunMuseum.controller;

import com.YunMuseum.model.ArtCol;
import com.YunMuseum.model.ArtWork;
import com.YunMuseum.service.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by zx G on 2017/4/14.
 */
@Controller
public class SetupController {
    @Resource
    SetupService setupService;
    @Resource
    ClubService clubService;
    @Resource
    MessageService messageService;
    @Resource
    ArtWorkService artWorkService;
    @Resource
    ArtColService artColService;
    @RequestMapping("/Setup")
    public String setup(Model model, @CookieValue("username") String username){
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
        return "Setup";
    }
    @RequestMapping("/PersonalInfoChange")
    public String personalInfoSetup(@RequestParam("name") String name,
                                    @RequestParam("mail") String mail,
                                    @RequestParam("city") String city,
                                    @RequestParam("pro") String pro,
                                    @CookieValue("username") String ticket,
                                    Model model){
        int userid = clubService.selectClubUserID(ticket);
        //更新个人信息
        setupService.PersonalInfoSetup(ticket,name,mail,city,pro);
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
