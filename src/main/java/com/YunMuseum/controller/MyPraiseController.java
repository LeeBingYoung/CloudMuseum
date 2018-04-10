package com.YunMuseum.controller;

import com.YunMuseum.model.ArtCol;
import com.YunMuseum.model.ArtWork;
import com.YunMuseum.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import java.util.List;
/**
 * Created by Test Guo on 2017/5/9.
 */
@Controller
public class MyPraiseController {
    @Resource
    ClubService clubService;
    @Resource
    ArtWorkService artWorkService;
    @Resource
    ArtColService artColService;
    @Resource
    MessageService messageService;
    @Resource
    InterestYearsService interestYearsService;
    @Resource
    InterestTypeService interestTypeService;
    @RequestMapping("/MyPraise")
    public String myPraise(Model model, @CookieValue("username") String username){
        int userid = clubService.selectClubUserID(username);
        //展示我喜欢的艺术品
        List<ArtWork> artWorkList = artWorkService.getArtWorkPraise(userid);
        model.addAttribute("ArtWork",artWorkList);
        //展示我喜欢的艺术专栏
        List<ArtCol> artColList = artColService.getArtColPraise(userid);
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
        //展示艺术品年代推荐
        int year1num = interestYearsService.getInterestYearsInfo1(userid);
        int year2num = interestYearsService.getInterestYearsInfo2(userid);
        String year1 = "";
        String year2 = "";
        switch (year1num){
            case 1:
                year1 = "先秦";
                break;
            case 2:
                year1 = "秦汉";
                break;
            case 3:
                year1 = "隋唐宋元";
                break;
            case 4:
                year1 = "明清";
                break;
            case 5:
                year1 = "近现代";
                break;
        }
        switch (year2num){
            case 1:
                year2 = "先秦";
                break;
            case 2:
                year2 = "秦汉";
                break;
            case 3:
                year2 = "隋唐宋元";
                break;
            case 4:
                year2 = "明清";
                break;
            case 5:
                year2 = "近现代";
                break;
        }
        List<ArtWork> artWorkListYear1 = artWorkService.getArtWorkCommendYears(year1);
        model.addAttribute("Years1",artWorkListYear1);
        List<ArtWork> artWorkListYear2 = artWorkService.getArtWorkCommendYears(year2);
        model.addAttribute("Years2",artWorkListYear2);
        //展示艺术品类别推荐
        int typenum1 = interestTypeService.getInterestTypeInfo1(userid);
        int typenum2 = interestTypeService.getInterestTypeInfo2(userid);
        String type1 = "";
        String type2 = "";
        switch (typenum1){
            case 1:
                type1 = "陶瓷";
                break;
            case 2:
                type1 = "字画";
                break;
            case 3:
                type1 = "玉器";
                break;
            case 4:
                type1 = "杂项";
                break;
        }
        switch (typenum2){
            case 1:
                type2 = "陶瓷";
                break;
            case 2:
                type2 = "字画";
                break;
            case 3:
                type2 = "玉器";
                break;
            case 4:
                type2 = "杂项";
                break;
        }
        List<ArtWork> artWorkListType1 = artWorkService.getArtWorkCommendType(type1);
        model.addAttribute("Type1",artWorkListType1);
        List<ArtWork> artWorkListType2 = artWorkService.getArtWorkCommendType(type2);
        model.addAttribute("Type2",artWorkListType2);
        //展示艺术专栏推荐
        List<ArtCol> artColCommendList = artColService.getArtColCommend();
        model.addAttribute("ColCommend",artColCommendList);
        return "MyPraise";
    }
}
