package com.YunMuseum.controller;

import com.YunMuseum.model.ArtCol;
import com.YunMuseum.model.ArtWork;
import com.YunMuseum.model.UserPass;
import com.YunMuseum.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
/**
 * Created by zx G on 2017/4/14.
 */
@Controller
public class HomeColController {
    @Resource
    ArtColService artColService;
    @Resource
    UserService userService;
    @Resource
    MessageService messageService;
    @Resource
    ArtWorkService artWorkService;
    @Resource
    ClubService clubService;
    @Resource
    ArtStoryService artStoryService;
    @Resource
    FollowService followService;
    @Resource
    PraiseService praiseService;
    @Resource
    InterestYearsService interestYearsService;
    @RequestMapping("/HomeColLogin")
    public String homeColLogin(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request, HttpServletResponse response,Model model){
        userService.selectPasswordByID(username);
        //登录
        Map<String,Object> map=userService.login(username,password);
        String msg = map.get("msg").toString();
        if(msg.equals("密码正确"))
        {
            Cookie cookie = new Cookie("username",userService.ticket(username));
            cookie.setPath(request.getContextPath());
            response.addCookie(cookie);
            cookie.setMaxAge(60*24*60);
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
        else if(msg.equals("无该用户"))
        {
            model.addAttribute("msg",map.get("msg"));
            return "HomeArt";
        }
        else
        {
            model.addAttribute("msg",map.get("msg"));
            return "HomeArt";
        }
    }
    @RequestMapping("/HomeColRegister")
    public String homeColRegister(@RequestParam("username") String username,@RequestParam("password") String password,@RequestParam("mail") String mail,Model model,HttpServletRequest request,HttpServletResponse response){
        userService.selectPasswordByID(username);
        //注册
        Map<String,Object>map = userService.regUserPass(username,password);
        String msg = map.get("msg").toString();
        if(msg.equals("无此用户"))
        {
            userService.insertRegisterUser(username,mail);
            Cookie cookie = new Cookie("username",userService.ticket(username));
            cookie.setPath(request.getContextPath());
            response.addCookie(cookie);
            cookie.setMaxAge(60*24*60);
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
            //获取各类作品数量
            int workmax = artWorkService.getMaxWork();
            int stomax = artStoryService.getMaxStory();
            int colmax = artColService.getMaxCol();
            //插入点赞
            for(int i=1;i<=workmax;i++){
                praiseService.insertWorkPraise(userid,i);
            }
            for(int i=1;i<=stomax;i++){
                praiseService.insertStoPraise(userid,i);
            }
            for(int i=1;i<=colmax;i++){
                praiseService.insertColPraise(userid,i);
            }
            //获取用户数量
            int usermax = userService.getMaxUser();
            //插入关注
            for(int i=1;i<=usermax;i++){
                followService.insertUserFollow(userid,i);
            }
            for(int i=1;i<=stomax;i++){
                followService.insertStoFollow(userid,i);
            }
            //插入兴趣年代表
            for(int i=1;i<=5;i++){
                interestYearsService.insertInterestYears(userid,i);
            }
            return "MyArt";
        }
        else
        {
            model.addAttribute("msg",map.get("msg"));
            return "HomeArt";
        }
    }
    @RequestMapping("/HomeCol")
    public String homeColAll(Model model, HttpServletRequest request){
        //展示全部艺术专栏
        List<ArtCol> homeColAllList = artColService.getArtColAll();
        model.addAttribute("ArtColAll",homeColAllList);
        return "HomeCol";
    }
}
