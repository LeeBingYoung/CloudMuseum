package com.YunMuseum.service;

import com.YunMuseum.model.User;
import com.YunMuseum.dao.UserDao;
import com.YunMuseum.model.UserPass;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
/**
 * Created by zx G on 2017/4/4.
 */
@Service
public class UserService {
    @Autowired
    UserDao userDao;
    //获取艺术品发布者名称
    public List<User> getArtWorkUser(int workid){
        return userDao.selectArtWorkUser(workid);
    }
    //获取艺术品发布者头像
    public List<User> getArtWorkUserImage(int workid){
        return userDao.selectArtWorkUserIamge(workid);
    }
    //获取艺术专栏发布者名称
    public List<User> getArtColUser(int colid){
        return userDao.selectArtColUser(colid);
    }
    //获取艺术专栏发布者头像
    public List<User> getArtColUserImage(int colid){
        return userDao.selectArtColUserImage(colid);
    }
    //获取用户密码
    public UserPass selectPasswordByID(String username){
        return userDao.selectPasswordByID(username);
    }
    //获取用户信息
    public List<UserPass> getname(String name) {
        return userDao.getJudge(name);
    }
    //登录判断
    public Map<String,Object> login(String username,String password){
        UserPass userPass = userDao.selectPasswordByID(username);
        Map<String,Object>map = new HashedMap();
        if(userPass==null)
        {
            map.put("msg","无该用户");
        }
        else
        {
            if(password.equals(userPass.getPassword()))
            {
                map.put("msg","密码正确");
                return map;
            }
            else
            {
                map.put("msg","密码错误");
                return map;
            }
        }
        return map;
    }
    //获取用户名放入Ticket
    public String ticket(String username){
        return username;
    }
    //新注册用户密码插入UserPass
    public Map<String,Object> regUserPass(String username,String password){
        UserPass userPass = userDao.selectPasswordByID(username);
        Map<String,Object>map = new HashedMap();
        if(userPass==null)
        {
            map.put("msg","无此用户");
            userPass = new UserPass();
            userPass.setUsername(username);
            userPass.setPassword(password);
            userDao.insertRegisterUserPass(userPass);
            return map;
        }
        else
        {
            map.put("msg","用户存在");
            return map;
        }
    }
    //新注册用户信息插入User
    public void insertRegisterUser(String username,String mail){
        User user = new User();
        user.setUsername(username);
        user.setMail(mail);
        userDao.insertRegisterUser(user);
    }
    //获取新增关注
    public List<User> getFollow(int publisherid){
        return userDao.selectFollow(publisherid);
    }
    //获取兴趣圈成员信息
    public List<User> getInterestMember(int interestid){
        return userDao.selectInterestMember(interestid);
    }
    //获取其他用户ID和姓名
    public List<User> getOtherUser(int userid){
        return userDao.selectOtherUser(userid);
    }
    //获取实名认证信息
    public User getIdentity(String name){
        return userDao.getIdentity(name);
    }
    //实名判断
    public Map<String,Object> status(String username){
        User user=userDao.getIdentity(username);
        Map<String,Object>map=new HashedMap();//将结果集存入map集合
        if(user.getIdentified().equals("1")){
            map.put("msg_status","实名认证");
        }
        else{
            map.put("msg_status","未实名认证");
        }
        return map;
    }
    //获取用户数量
    public int getMaxUser(){
        return userDao.selectMaxUser();
    }
}
