package com.YunMuseum.controller;

import com.YunMuseum.model.ArtWork;
import com.YunMuseum.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ArtWorkClassifyController {
    @Resource
    ArtWorkService artWorkService;
    @RequestMapping("/HomeArtTC")
    public String homeArtTC(Model model){
        //展示全部艺术品
        List<ArtWork> homeArtWorkList = artWorkService.getArtWorkType("陶瓷");
        model.addAttribute("ArtWorkAll",homeArtWorkList);
        return "HomeArtWork";
    }
    @RequestMapping("/HomeArtZH")
    public String homeArtZH(Model model){
        //展示全部艺术品
        List<ArtWork> homeArtWorkList = artWorkService.getArtWorkType("字画");
        model.addAttribute("ArtWorkAll",homeArtWorkList);
        return "HomeArtWork";
    }
    @RequestMapping("/HomeArtYQ")
    public String homeArtYQ(Model model){
        //展示全部艺术品
        List<ArtWork> homeArtWorkList = artWorkService.getArtWorkType("玉器");
        model.addAttribute("ArtWorkAll",homeArtWorkList);
        return "HomeArtWork";
    }
    @RequestMapping("/HomeArtZX")
    public String homeArtZX(Model model){
        //展示全部艺术品
        List<ArtWork> homeArtWorkList = artWorkService.getArtWorkType("杂项");
        model.addAttribute("ArtWorkAll",homeArtWorkList);
        return "HomeArtWork";
    }
    @RequestMapping("/HomeArtXQ")
    public String homeArtXQ(Model model){
        //展示全部艺术品
        List<ArtWork> homeArtWorkList = artWorkService.getArtWorkYears("先秦");
        model.addAttribute("ArtWorkAll",homeArtWorkList);
        return "HomeArtWork";
    }

    @RequestMapping("/HomeArtQH")
    public String homeArtQH(Model model){
        //展示全部艺术品
        List<ArtWork> homeArtWorkList = artWorkService.getArtWorkYears("秦汉");
        model.addAttribute("ArtWorkAll",homeArtWorkList);
        return "HomeArtWork";
    }
    @RequestMapping("/HomeArtSTSY")
    public String homeArtSTSY(Model model){
        //展示全部艺术品
        List<ArtWork> homeArtWorkList = artWorkService.getArtWorkYears("隋唐宋元");
        model.addAttribute("ArtWorkAll",homeArtWorkList);
        return "HomeArtWork";
    }
    @RequestMapping("/HomeArtMQ")
    public String homeArtMQ(Model model){
        //展示全部艺术品
        List<ArtWork> homeArtWorkList = artWorkService.getArtWorkYears("明清");
        model.addAttribute("ArtWorkAll",homeArtWorkList);
        return "HomeArtWork";
    }
    @RequestMapping("/HomeArtJXD")
    public String homeArtJXD(Model model){
        //展示全部艺术品
        List<ArtWork> homeArtWorkList = artWorkService.getArtWorkYears("近现代");
        model.addAttribute("ArtWorkAll",homeArtWorkList);
        return "HomeArtWork";
    }
}
