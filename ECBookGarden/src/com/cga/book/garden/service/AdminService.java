package com.cga.book.garden.service;

import com.cga.book.garden.pojo.Admin;

import java.util.List;

public interface AdminService {

    //管理员登陆
    Admin login(String uname,String pwd);

    //记录登陆时间
    void loginTime(String adminTime);

    //插入一条管理员数据
    void loginData(Admin adminData);

    //获取管理员所有时间段信息
    List<Admin> getAdminListByDate(String loginTime,String quitTime);

    //根据id删除指定admin信息
    void delAdminItemById(Integer adminId);

    //获取表中的最大id
    Integer getMaxId();

    //插入退出时间
    void insertQuit(Admin admin);

    Admin getAdminById(Integer id);

    //插入管理员持续时间
    void insertContinue(Admin admin);

}
