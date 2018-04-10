package com.YunMuseum.controller;

import com.YunMuseum.model.ArtColImage;
import com.YunMuseum.service.ArtColImageService;
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
public class ArtColLargeController {
    @Resource
    ArtColImageService artColImageService;
    @RequestMapping("/ArtColLarge")
    public  String artColLarge(Model model, @CookieValue("colid") String colidstring){
        int colid = Integer.parseInt(colidstring);
        //展示艺术专栏放大图片
        List<ArtColImage> artColLargeList = artColImageService.getArtColLarge(colid);
        model.addAttribute("ArtColLarge",artColLargeList);
        return "ColumnDetailsLarge";
    }
}
