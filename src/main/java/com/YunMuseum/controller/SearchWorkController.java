package com.YunMuseum.controller;

import com.YunMuseum.model.*;
import com.YunMuseum.service.SearchWorkService;
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
public class SearchWorkController {
    @Resource
    SearchWorkService searchWorkService;
    @RequestMapping("/SearchWork")
    public String search(Model model, HttpServletRequest request){
        String textword = request.getParameter("searchtext");
        String text = "%"+textword+"%";
        String url = "http://www.baidu.com/s?pn=0&wd=" + textword;
        String baidusearch = "";
        int i = 1;
        //展示艺术品上传者相似
        List<ArtWork> artWorkWNameList = searchWorkService.getArtWorkWName(text);
        model.addAttribute("ArtWorkWName",artWorkWNameList);
        //展示艺术品标题相似
        List<ArtWork> artWorkWTitleList = searchWorkService.getArtWorkWTitle(text);
        model.addAttribute("ArtWorkWTitle",artWorkWTitleList);
        //展示艺术品年代相似
        List<ArtWork> artWorkWYearsList = searchWorkService.getArtWorkWYears(text);
        model.addAttribute("ArtWorkWYears",artWorkWYearsList);
        //展示艺术品原作者相似
        List<ArtWork> artWorkWArtistList = searchWorkService.getArtWorkWArtist(text);
        model.addAttribute("ArtWorkWArtist",artWorkWArtistList);
        //展示艺术品所有者相似
        List<ArtWork> artWorkWCollectorList = searchWorkService.getArtWorkWCollector(text);
        model.addAttribute("ArtWorkWCollector",artWorkWCollectorList);
        //展示艺术品类型相似
        List<ArtWork> artWorkWTypeList = searchWorkService.getArtWorkWType(text);
        model.addAttribute("ArtWorkWType",artWorkWTypeList);
        //展示艺术品地点相似
        List<ArtWork> artWorkWPlaceList = searchWorkService.getArtWorkWPlace(text);
        model.addAttribute("ArtWorkWPlace",artWorkWPlaceList);
        //展示艺术品简介相似
        List<ArtWork> artWorkWTextList = searchWorkService.getArtWorkWText(text);
        model.addAttribute("ArtWorkWText",artWorkWTextList);
        /* //展示艺术品上传时间相似
        List<ArtWork> artWorkWTimeList = searchWorkService.getArtWorkWTime(text);
        model.addAttribute("ArtWorkWTime",artWorkWTimeList);*/
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
        return "SearchWork";
    }
}