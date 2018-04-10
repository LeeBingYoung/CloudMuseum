package com.YunMuseum.controller;

import com.YunMuseum.service.*;
import com.YunMuseum.utils.FileUploadingUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import static org.aspectj.weaver.tools.cache.SimpleCacheFactory.path;

/**
 * Created by zx G on 2017/4/16.
 */
@Controller
public class RealNameSetupController {
    @Resource
    SetupService setupService;
    @Resource
    ClubService clubService;
    @Resource
    MessageService messageService;
    @RequestMapping("/RealNameSetup")
    public String realNameSetup(Model model, @CookieValue("username") String username){
        int userid = clubService.selectClubUserID(username);
        //展示消息推送通知
        int CountCommentWork = messageService.getCountCommentWork(userid);
        int CountCommentCol = messageService.getCountCommentCol(userid);
        int CountPraiseWork = messageService.getCountPraiseWork(userid);
        int CountPraiseCol = messageService.getCountPraiseCol(userid);
        int CountFollow = messageService.getCountFollow(userid);
        int CountShare = messageService.getCountShare(userid);
        int Count = CountCommentWork+CountCommentCol+CountPraiseWork+CountPraiseCol+CountFollow+CountShare;
        model.addAttribute("Count",Count);
        return "RealNameSetup";
    }
    @RequestMapping("/RealNameChange")
    public String realNameChange(@RequestParam("true_name") String name, @RequestParam("id_key") String id_num, @RequestParam("jumpMenu") String id_type, @CookieValue("username") String ticket, Model model, HttpServletRequest request, @RequestParam("file") MultipartFile file){
        int userid = clubService.selectClubUserID(ticket);
        saveFileWork(file);
        //展示消息推送通知
        int CountCommentWork = messageService.getCountCommentWork(userid);
        int CountCommentCol = messageService.getCountCommentCol(userid);
        int CountPraiseWork = messageService.getCountPraiseWork(userid);
        int CountPraiseCol = messageService.getCountPraiseCol(userid);
        int CountFollow = messageService.getCountFollow(userid);
        int CountShare = messageService.getCountShare(userid);
        int Count = CountCommentWork+CountCommentCol+CountPraiseWork+CountPraiseCol+CountFollow+CountShare;
        model.addAttribute("Count",Count);
        //更新实名认证
        setupService.RealNameChange(name,path,id_num,id_type,ticket);
        return "RealNameSetup";
    }
    private boolean saveFileWork(MultipartFile file) {
        // 判断文件是否为空
        if (!file.isEmpty()) {
            try {
                // 文件保存路径
                String filePath = "/images/" + file.getOriginalFilename();
                path=filePath;
                String fileSavePath = "//usr//local//tomcat//webapps//images//";
                //String fileSavePathlocal = "C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\webapps\\YunMuseum\\WEB-INF\\classes\\static\\images\\";
                File dest = new File(fileSavePath + file.getOriginalFilename());
                if (!dest.getParentFile().exists()) {
                    dest.getParentFile().mkdirs();
                }
                try {
                    file.transferTo(dest);
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
