package com.YunMuseum.controller;

import com.YunMuseum.model.ArtWork;
import com.YunMuseum.service.ArtWorkService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import java.util.List;
/**
 * Created by zx G on 2017/4/7.
 */
@Controller
public class ArtWorkLargeController {
    @Resource
    ArtWorkService artWorkService;
    @RequestMapping("/ArtWorkLarge")
    public String artWorkLarge(Model model, @CookieValue("workid") String workidstring){
        int workid = Integer.parseInt(workidstring);
        //展示艺术品放大的图片
        List<ArtWork> artWorkLargeList = artWorkService.getArtWorkLarge(workid);
        model.addAttribute("ArtWorkLarge",artWorkLargeList);
        return "WorkDetailsLarge";
    }
}
