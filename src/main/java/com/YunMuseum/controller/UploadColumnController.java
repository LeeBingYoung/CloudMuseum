package com.YunMuseum.controller;

import com.YunMuseum.model.ArtCol;
import com.YunMuseum.model.ArtWork;
import com.YunMuseum.model.Follow;
import com.YunMuseum.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import static org.aspectj.weaver.tools.cache.SimpleCacheFactory.path;
/**
 * Created by Test Guo on 2017/5/10.
 */
@Controller
public class UploadColumnController {
    @Resource
    ArtColService artColService;
    @Resource
    ClubService clubService;
    @Resource
    MessageService messageService;
    @Resource
    ArtWorkService artWorkService;
    @Resource
    UserService userService;
    @Resource
    PraiseService praiseService;
    @RequestMapping("/UploadCol")
    public String uploadCol(Model model, @CookieValue("username") String username){
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
        return "UploadColumn";
    }
    @RequestMapping("/UploadColumn")
    public String upload(HttpServletRequest request, @CookieValue("username") String username, Model model,
                         @RequestParam("file1") MultipartFile file1, @RequestParam("file2") MultipartFile file2,
                         @RequestParam("file3") MultipartFile file3, @RequestParam("file4") MultipartFile file4){
        int userid = clubService.selectClubUserID(username);
        String name = request.getParameter("name");
        String place = request.getParameter("place");
        String type = request.getParameter("type");
        String year = request.getParameter("year");
        String zhengwen = request.getParameter("zhengwen");
        //判断file数组不能为空并且长度大于0
        artColService.insertCol(userid,username,name,type,place,year,path,zhengwen);
        saveFile1(file1);
        saveFile2(file2);
        saveFile3(file3);
        saveFile4(file4);
        //展示消息推送通知
        int CountCommentWork = messageService.getCountCommentWork(userid);
        int CountCommentCol = messageService.getCountCommentCol(userid);
        int CountPraiseWork = messageService.getCountPraiseWork(userid);
        int CountPraiseCol = messageService.getCountPraiseCol(userid);
        int CountFollow = messageService.getCountFollow(userid);
        int CountShare = messageService.getCountShare(userid);
        int Count = CountCommentWork+CountCommentCol+CountPraiseWork+CountPraiseCol+CountFollow+CountShare;
        model.addAttribute("Count",Count);
        //插入点赞
        int usermax = userService.getMaxUser();
        int colid = praiseService.getNewColID(name);
        for(int i=1;i<=usermax;i++){
            praiseService.insertColPraise(i,colid);
        }
        return "UploadColumn";
    }
    private boolean saveFile1(MultipartFile file) {
        Map<String,String> map = System.getenv();
        String userName = map.get("USERNAME");// 获取用户名
        int colmax = artColService.getMaxCol();//获取艺术专栏数量
        // 判断文件是否为空
        if (!file.isEmpty()) {
            try {
                // 文件保存路径
                String filePath = "/images/" + file.getOriginalFilename();
                path=filePath;
                String fileSavePath = "C:\\Users\\" + userName +"\\IdeaProjects\\YunMuseum\\target\\YunMuseum-1.0.0-SNAPSHOT\\WEB-INF\\classes\\static\\images\\";
                //String fileSavePathlocal = "C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\webapps\\YunMuseum\\WEB-INF\\classes\\static\\images\\";
                // 转存文件
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
                artColService.insertCImage(colmax,1,path);
                artColService.updateArtColImage(path,colmax);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    private boolean saveFile2(MultipartFile file) {
        Map<String,String> map = System.getenv();
        String userName = map.get("USERNAME");// 获取用户名
        int colmax = artColService.getMaxCol();//获取艺术专栏数量
        // 判断文件是否为空
        if (!file.isEmpty()) {
            try {
                // 文件保存路径
                String filePath = "/images/" + file.getOriginalFilename();
                path=filePath;
                String fileSavePath = "C:\\Users\\" + userName +"\\IdeaProjects\\YunMuseum\\target\\YunMuseum-1.0.0-SNAPSHOT\\WEB-INF\\classes\\static\\images\\";
                //String fileSavePathlocal = "C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\webapps\\YunMuseum\\WEB-INF\\classes\\static\\images\\";
                // 转存文件
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
                artColService.insertCImage(colmax,2,path);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    private boolean saveFile3(MultipartFile file) {
        Map<String,String> map = System.getenv();
        String userName = map.get("USERNAME");// 获取用户名
        int colmax = artColService.getMaxCol();//获取艺术专栏数量
        // 判断文件是否为空
        if (!file.isEmpty()) {
            try {
                // 文件保存路径
                String filePath = "/images/" + file.getOriginalFilename();
                path=filePath;
                String fileSavePath = "C:\\Users\\" + userName +"\\IdeaProjects\\YunMuseum\\target\\YunMuseum-1.0.0-SNAPSHOT\\WEB-INF\\classes\\static\\images\\";
                //String fileSavePathlocal = "C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\webapps\\YunMuseum\\WEB-INF\\classes\\static\\images\\";
                // 转存文件
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
                artColService.insertCImage(colmax,3,path);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    private boolean saveFile4(MultipartFile file) {
        Map<String,String> map = System.getenv();
        String userName = map.get("USERNAME");// 获取用户名
        int colmax = artColService.getMaxCol();//获取艺术专栏数量
        // 判断文件是否为空
        if (!file.isEmpty()) {
            try {
                // 文件保存路径
                String filePath = "/images/" + file.getOriginalFilename();
                path=filePath;
                String fileSavePath = "C:\\Users\\" + userName +"\\IdeaProjects\\YunMuseum\\target\\YunMuseum-1.0.0-SNAPSHOT\\WEB-INF\\classes\\static\\images\\";
                //String fileSavePathlocal = "C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\webapps\\YunMuseum\\WEB-INF\\classes\\static\\images\\";
                // 转存文件
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
                artColService.insertCImage(colmax,4,path);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    @RequestMapping("/UploadModel")
    public String upload_model(@CookieValue("username") String username, Model model, HttpServletRequest request, @RequestParam("file") MultipartFile file){
        int userid = clubService.selectClubUserID(username);
        String wtitle = request.getParameter("wtitle");
        String wyears = request.getParameter("wyears");
        String wtype = request.getParameter("wtype");
        String wtext = request.getParameter("wtext");
        saveFileWork(file);
        artWorkService.uploadWork(userid,wtitle,wyears,wtype,wtext,path);
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
        //插入点赞
        int usermax = userService.getMaxUser();
        int workid = praiseService.getNewWorkID(wtitle);
        for(int i=1;i<=usermax;i++){
            praiseService.insertWorkPraise(i,workid);
        }
        return "MyArt";
    }
    private boolean saveFileWork(MultipartFile file) {
        Map<String,String> map = System.getenv();
        String userName = map.get("USERNAME");// 获取用户名
        // 判断文件是否为空
        if (!file.isEmpty()) {
            try {
                // 文件保存路径
                String filePath = "/images/" + file.getOriginalFilename();
                path=filePath;
                String fileSavePath = "C:\\Users\\" + userName +"\\IdeaProjects\\YunMuseum\\target\\YunMuseum-1.0.0-SNAPSHOT\\WEB-INF\\classes\\static\\images\\";
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
