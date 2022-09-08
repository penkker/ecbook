package com.cga.book.garden.service.impl;

import com.cga.book.garden.dao.AdminDAO;
import com.cga.book.garden.pojo.Admin;
import com.cga.book.garden.service.AdminService;

import java.util.List;

public class AdminServiceImpl implements AdminService {

    private AdminDAO adminDAO;

    @Override
    public Admin login(String uname, String pwd) {
        return adminDAO.getAdminer(uname,pwd);
    }

    @Override
    public void loginTime(String adminTime) {
        adminDAO.loginTime(adminTime);
    }

    @Override
    public void loginData(Admin adminData) {
        adminDAO.loginData(adminData);
    }

    @Override
    public List<Admin> getAdminListByDate(String loginTime,String quitTime) {
        return adminDAO.getAdminListByDate(loginTime,quitTime);
    }

    @Override
    public void delAdminItemById(Integer adminId) {
        adminDAO.delAdminItemById(adminId);
    }

    @Override
    public Integer getMaxId() {
        return adminDAO.getMaxId();
    }

    @Override
    public void insertQuit(Admin admin) {
        adminDAO.insertQuit(admin);
    }

    @Override
    public Admin getAdminById(Integer id) {
        return adminDAO.getAdminById(id);
    }

    @Override
    public void insertContinue(Admin admin) {
        adminDAO.insertContinue(admin);
    }
}
