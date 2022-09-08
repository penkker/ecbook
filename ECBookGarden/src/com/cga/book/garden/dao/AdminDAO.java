package com.cga.book.garden.dao;

import com.cga.book.garden.pojo.Admin;

import java.util.List;

public interface AdminDAO {

    //获取管理员信息
    Admin getAdminer(String uname,String pwd);

    //存储管理员登陆时间
    void loginTime(String adminTime);

    //插入一条管理员数据
    void loginData(Admin adminData);

    //获取管理员所有时间段信息
    List<Admin> getAdminListByDate(String loginTime,String quitTime);

    //根据id删除指定admin信息
    void delAdminItemById(Integer adminId);

    //获取表中最大id
    Integer getMaxId();

    //插入退出登录时间
    void insertQuit(Admin admin);

    //根基id获取管理员信息
    Admin getAdminById(Integer id);

    //插入持续时间
    void  insertContinue(Admin admin);
}
