package com.YunMuseum.service;

import com.YunMuseum.dao.UserDao;
import com.YunMuseum.model.User;
import com.YunMuseum.model.UserPass;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CookieValue;

import java.util.Date;
import java.util.Map;
/**
 * Created by Test Guo on 2017/4/18.
 */
@Service
public class SetupService {
    @Autowired
    UserDao userDao;
    //更新密码
    public void ChangePassword(String username,String password){
        UserPass userPass = new UserPass();
        userPass.setUsername(username);
        userPass.setPassword(password);
        userDao.ChangePassword(userPass);
    }
    //更新实名认证
    public void RealNameChange(String name,String image,String idnum,String doctype,String username){
        User user = new User();
        user.setName(name);
        user.setImage(image);
        user.setIdnum(idnum);
        user.setDoctype(doctype);
        user.setUsername(username);
        userDao.RealNameChange(user);
    }
    //更新个人信息
    public void PersonalInfoSetup(String ticket, String username, String mail, String city, String pro){
        User user = new User();
        user.setTicket(ticket);
        user.setUsername(username);
        user.setMail(mail);
        user.setCity(city);
        user.setPro(pro);
        userDao.PersonalInfoSetup(user);
    }
    //检查密码是否匹配
    public Map<String,Object> CheckPassword(String username, String password){
        UserPass user=userDao.selectPasswordByID(username);
        Map<String,Object>map=new HashedMap();
        if(password.equals(user.getPassword())){
            map.put("msg", "密码正确");
            return map;
        }
        else{
            map.put("msg","密码错误");
            return map;
        }
    }
    //更新用户头像
    public void storgeimg(String path, @CookieValue("username") String name){
        System.out.print("path:"+path);
        userDao.setImagePath(name,path);
    }
}
