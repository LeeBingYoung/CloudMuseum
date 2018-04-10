package com.YunMuseum.controller;

import com.YunMuseum.model.ArtStoryPage;
import com.YunMuseum.service.ArtStoryPageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import java.util.List;
/**
 * Created by Test Guo on 2017/4/12.
 */
@Controller
public class ArtStoryLargeController {
    @Resource
    ArtStoryPageService artStoryPageService;
    @RequestMapping("/ArtStoryLarge")
    public String artStoryLarge(Model model, @CookieValue("stoid") String stoidstring){
        int stoid = Integer.parseInt(stoidstring);
        //展示艺术故事放大图片
        List<ArtStoryPage> artStoryLargeList = artStoryPageService.getArtStoryLarge(stoid);
        model.addAttribute("ArtStoryLarge",artStoryLargeList);
        return "StoryDetailsLarge";
    }
}
