package com.cga.book.garden.dao;

import com.cga.book.garden.pojo.User;

import java.util.List;

public interface UserDAO {
    //根据用户名密码查询用户信息
    User getUser(String uname,String pwd);

    //查询用户表所有数据
    List<User> getUserList();

    //为用户表添加一个用户
    void insertUser(User user);

    //
    List<User> getUserListByDate(String loginTime, String quitTime);

    //根据关键字查询用户信息
    List<User> getUserListByKeyName(String uname);

    //根据用户编号查询用户信息
    List<User> getUserByUserNum(String userNum);

    //根据用户id更新用户登陆时间
    void updateUserLoginTime(User userData);

    //删除一条用户信息
    void delUserItem(Integer userId);

    //设置一条用户信息
   void setUserById(User user,String birthDate);

   //根据id修改用户密码
    void modifyPwdById(Integer id,String pwd);

    //根据id查询用户信息
    User getUserById(Integer id);

    //根据id插入用户退出时间
    void setUserQuitTimeById(Integer id,String quitTime);

    //根据id设置用户浏览时间
    void setUserStayTimeById(Integer id,String stayTime);
}
