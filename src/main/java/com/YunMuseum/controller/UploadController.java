package com.YunMuseum.controller;

import com.YunMuseum.model.ArtWork;
import com.YunMuseum.service.ArtWorkService;
import com.YunMuseum.service.ClubService;
import com.YunMuseum.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
/**
 * Created by zx G on 2017/4/16.
 */
@Controller
public class UploadController {
    @Resource
    ClubService clubService;
    @Resource
    ArtWorkService artWorkService;
    @Resource
    MessageService messageService;
    @RequestMapping("/Upload")
    public String upload(Model model, @CookieValue("username") String username){
        int userid = clubService.selectClubUserID(username);
        //展示发布的艺术品详情
        List<ArtWork> artWorkList = artWorkService.getArtWorkDeatils(userid);
        model.addAttribute("ArtWork",artWorkList);
        //展示消息推送通知
        int CountCommentWork = messageService.getCountCommentWork(userid);
        int CountCommentCol = messageService.getCountCommentCol(userid);
        int CountPraiseWork = messageService.getCountPraiseWork(userid);
        int CountPraiseCol = messageService.getCountPraiseCol(userid);
        int CountFollow = messageService.getCountFollow(userid);
        int CountShare = messageService.getCountShare(userid);
        int Count = CountCommentWork+CountCommentCol+CountPraiseWork+CountPraiseCol+CountFollow+CountShare;
        model.addAttribute("Count",Count);
        return "Upload";
    }
    @RequestMapping("/UploadDelete")
    public String uploadDelete(Model model,HttpServletRequest request,@CookieValue("username") String username){
        String workidstring = request.getParameter("workid");
        int workid = Integer.parseInt(workidstring);
        int userid = clubService.selectClubUserID(username);
        //展示发布的艺术品详情
        artWorkService.updateArtWorkDetails(workid,userid);
        List<ArtWork> artWorkList = artWorkService.getArtWorkDeatils(userid);
        model.addAttribute("ArtWork",artWorkList);
        //展示消息推送通知
        int CountCommentWork = messageService.getCountCommentWork(userid);
        int CountCommentCol = messageService.getCountCommentCol(userid);
        int CountPraiseWork = messageService.getCountPraiseWork(userid);
        int CountPraiseCol = messageService.getCountPraiseCol(userid);
        int CountFollow = messageService.getCountFollow(userid);
        int CountShare = messageService.getCountShare(userid);
        int Count = CountCommentWork+CountCommentCol+CountPraiseWork+CountPraiseCol+CountFollow+CountShare;
        model.addAttribute("Count",Count);
        return "Upload";
    }
}
