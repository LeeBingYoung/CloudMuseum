package com.YunMuseum.controller;

import com.YunMuseum.model.ArtCol;
import com.YunMuseum.model.ArtWork;
import com.YunMuseum.model.User;
import com.YunMuseum.service.ArtColService;
import com.YunMuseum.service.ArtWorkService;
import com.YunMuseum.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
/**
 * Created by Test Guo on 2017/5/18.
 */
@Controller
public class OtherUserController {
    @Resource
    UserService userService;
    @Resource
    ArtWorkService artWorkService;
    @Resource
    ArtColService artColService;
    @RequestMapping("/OtherUser")
    public String otherUser(Model model, HttpServletRequest request){
        String useridstring = request.getParameter("userid");
        int userid = Integer.parseInt(useridstring);
        //展示其他用户ID和姓名
        List<User> userList = userService.getOtherUser(userid);
        model.addAttribute("User",userList);
        //展示个人发布的艺术品
        List<ArtWork> artWorkList = artWorkService.getArtWorkPerson(userid);
        model.addAttribute("ArtWork",artWorkList);
        //展示个人发布的艺术专栏
        List<ArtCol> artColList = artColService.getArtColPerson(userid);
        model.addAttribute("ArtCol",artColList);
        return "OtherUser";
    }
}
