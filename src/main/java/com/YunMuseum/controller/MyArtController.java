package com.YunMuseum.controller;

import com.YunMuseum.model.ArtCol;
import com.YunMuseum.model.ArtWork;
import com.YunMuseum.service.ArtColService;
import com.YunMuseum.service.ArtWorkService;
import com.YunMuseum.service.ClubService;
import com.YunMuseum.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import java.util.List;
/**
 * Created by zx G on 2017/4/13.
 */
@Controller
public class MyArtController {
    @Resource
    ClubService clubService;
    @Resource
    ArtWorkService artWorkService;
    @Resource
    ArtColService artColService;
    @Resource
    MessageService messageService;
    @RequestMapping("/MyArt")
    public String myArt(Model model, @CookieValue("username") String username){
        int userid = clubService.selectClubUserID(username);
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
