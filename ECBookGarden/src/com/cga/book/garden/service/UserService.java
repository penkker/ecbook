package com.cga.book.garden.service;

import com.cga.book.garden.pojo.User;
import com.sun.javafx.image.IntPixelGetter;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public interface UserService {
    //登录验证
    User login(String uname,String pwd);

    //查询用户表所有用户
    List<User> getUserList();

    //注册成功
    String registSuccess(User user,String deterPwd);

    //获取用户信息
    List<User> getUser(String userNum, String middleArg, String uname);

    //根据登录退出日期查询用户信息
    List<User> getUserListByDate(String loginTime, String quitTime);

    //
    List<User> getIsOrNotUserList(String userNum, String uname);

    //根据关键字查询用户信息
    List<User> getUserListByKeyName(String uname);

    //根据用户编号查询用户信息
    List<User> getUserByUserNum(String userNum);

    //根据id更新user的登录时间信息
    void updateUserLoginTime(User userData);

    //删除一条用户信息
    void delUserItem(Integer userId);

    //设置用户信息
    void setUserById(User user,String birthDate);

    //根据id修改用户密码
    void modifyPwdById(Integer id,String pwd);

    //根据id查询用户信息
    User getUserById(Integer id);

    //根据id插入用户退出时间
    void setUserQuitTimeById(Integer id,String quitTime);

    //根据id设置用户浏览时间
    void setUserStayTimeById(Integer id,String stayTime);

    //插入一条用户信息
    void insertUser(User user);
}
