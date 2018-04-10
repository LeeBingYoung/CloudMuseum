package com.YunMuseum.controller;

import com.YunMuseum.model.*;
import com.YunMuseum.service.SearchColService;
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
 * Created by lby on 2017/5/19.
 */
@Controller
public class SearchColController {
    @Resource
    SearchColService searchColService;
    @RequestMapping("/SearchCol")
    public String search(Model model, HttpServletRequest request){
        String textword = request.getParameter("searchtext");
        String text = "%"+textword+"%";
        String url = "http://www.baidu.com/s?pn=0&wd=" + textword;
        String baidusearch = "";
        int i = 1;
        //展示艺术专栏标题相似
        List<ArtCol> artColCTitleList = searchColService.getArtColCTitle(text);
        model.addAttribute("ArtColCTitle",artColCTitleList);
        //展示艺术专栏年代相似
        List<ArtCol> artColCYearsList = searchColService.getArtColCYears(text);
        model.addAttribute("ArtColCYears",artColCYearsList);
        //展示艺术专栏类型相似
        List<ArtCol> artColCTypeList = searchColService.getArtColCType(text);
        model.addAttribute("ArtColCType",artColCTypeList);
        //展示艺术专栏地点相似
        List<ArtCol> artColCPlaceList = searchColService.getArtColCPlace(text);
        model.addAttribute("ArtColCPlace",artColCPlaceList);
        //展示艺术专栏摘要相似
        List<ArtCol> artColCAbstractList = searchColService.getArtColCAbstract(text);
        model.addAttribute("ArtColCAbstract",artColCAbstractList);
        //展示艺术专栏全文相似
        List<ArtCol> artColCTextList = searchColService.getArtColCText(text);
        model.addAttribute("ArtColCText",artColCTextList);
        //展示艺术专栏作者相似
        List<ArtCol> artColUserNameList = searchColService.getArtColUserName(text);
        model.addAttribute("ArtColUserName",artColUserNameList);
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
        return "SearchCol";
    }
}