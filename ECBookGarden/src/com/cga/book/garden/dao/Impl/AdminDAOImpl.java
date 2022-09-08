package com.cga.book.garden.dao.Impl;

import com.cga.book.garden.dao.AdminDAO;
import com.cga.book.garden.pojo.Admin;
import com.cga.book.myssm.basedao.BaseDAO;

import java.util.List;

public class AdminDAOImpl extends BaseDAO<Admin> implements AdminDAO {


    @Override
    public Admin getAdminer(String uname, String pwd) {
        return super.load("select * from e_admin where uname = ? and pwd = ? and id = ?",uname,pwd,32);
    }

    @Override
    public void loginTime(String adminTime) {
        super.executeUpdate("update e_admin set loginTime = ? where id = ?",adminTime,1);
    }

    //插入管理员的用户名,密码,登陆时间
    @Override
    public void loginData(Admin adminData) {
        super.executeUpdate("insert into e_admin(id,loginTime,uname,pwd) values(?,?,?,?)",0,adminData.getLoginTime(),adminData.getUname(),adminData.getPwd());
    }

    @Override
    public List<Admin> getAdminListByDate(String loginTime,String quitTime) {
        return super.executeQuery("select * from e_admin where loginTime between ? and ? and quitTime between ? and ?",loginTime,quitTime,loginTime,quitTime);
    }

    @Override
    public void delAdminItemById(Integer adminId) {
        super.executeUpdate("delete from e_admin where id = ?",adminId);
    }

    @Override
    public Integer getMaxId() {
        return (Integer) super.executeComplexQuery("select MAX(id) from e_admin")[0];
    }

    @Override
    public void insertQuit(Admin admin) {
        super.executeUpdate("update e_admin set quitTime = ? where id = ?",admin.getQuitTime(),admin.getId());
    }

    @Override
    public Admin getAdminById(Integer id) {
        return super.load("select * from e_admin where id = ?",id);
    }

    @Override
    public void insertContinue(Admin admin) {
        super.executeUpdate("update e_admin set continueTime = ? where id = ?",admin.getContinueTime(),admin.getId());
    }

}
