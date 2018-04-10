package com.YunMuseum.controller;

import com.YunMuseum.model.*;
import com.YunMuseum.service.SearchStoryService;
import com.YunMuseum.utils.JSoupBaiduSearcher;
import com.YunMuseum.utils.Searcher;
import com.YunMuseum.utils.Webpage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
/**
 * Created by lby on 2017/5/14.
 */
@Controller
public class SearchStoryController {
    @Resource
    SearchStoryService searchStoryService;
    @RequestMapping("/SearchStory")
    public String search(Model model, HttpServletRequest request){
        String textword = request.getParameter("searchtext");
        String text = "%"+textword+"%";
        String url = "http://www.baidu.com/s?pn=0&wd=" + textword;
        String baidusearch = "";
        int i = 1;
        //展示艺术故事标题相似
        List<ArtStory> artStorySTitleList = searchStoryService.getArtStorySTitle(text);
        model.addAttribute("ArtStorySTitle",artStorySTitleList);
        //展示艺术故事年代相似
        List<ArtStory> artStorySYearsList = searchStoryService.getArtStorySYears(text);
        model.addAttribute("ArtStorySYears",artStorySYearsList);
        //展示艺术故事类型相似
        List<ArtStory> artStorySTypeList = searchStoryService.getArtStorySType(text);
        model.addAttribute("ArtStorySType",artStorySTypeList);
        //展示艺术故事地点相似
        List<ArtStory> artStorySPlaceList = searchStoryService.getArtStorySPlace(text);
        model.addAttribute("ArtStorySPlace",artStorySPlaceList);
        //展示艺术故事摘要相似
        List<ArtStory> artStorySAbstractList = searchStoryService.getArtStorySAbstract(text);
        model.addAttribute("ArtStorySAbstract",artStorySAbstractList);
        //展示艺术故事期号相似
        List<ArtStory> artStoryNoList = searchStoryService.getArtStoryNo(text);
        model.addAttribute("ArtStoryNo",artStoryNoList);
        //展示艺术故事系列相似
        List<ArtStory> artStorySeriesList = searchStoryService.getArtStorySeries(text);
        model.addAttribute("ArtStorySeries",artStorySeriesList);
        //百度搜索爬虫
        Searcher searcher = new JSoupBaiduSearcher();
        List<Webpage> webpages = searcher.search(url);
        for(Webpage webpage : webpages){
            baidusearch = baidusearch + "搜索结果" + (i++) + "：" + "<br/>";
            baidusearch = baidusearch + "标题：" + webpage.getTitle() + "<br/>";
            baidusearch = baidusearch + "URL：" + webpage.getUrl() + "<br/>";
            baidusearch = baidusearch + "摘要：" + webpage.getSummary() + "<br/>";
        }
        model.addAttribute("baidusearch",baidusearch);
        return "SearchStory";
    }
}