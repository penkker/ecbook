package com.cga.book.garden.dao.Impl;

import com.cga.book.garden.dao.UserDAO;
import com.cga.book.garden.pojo.User;
import com.cga.book.myssm.basedao.BaseDAO;

import java.util.List;

public class UserDAOImpl extends BaseDAO<User> implements UserDAO {

    @Override
    public User getUser(String uname, String pwd) {
        return super.load("select * from e_user where uname = ? and pwd = ?",uname,pwd);
    }

    @Override
    public List<User> getUserList() {
        return super.executeQuery("select * from e_user");
    }

    @Override
    public void insertUser(User user) {
        executeUpdate("insert into e_user(id,uname,pwd,nickName,email) values(?,?,?,?,?)",0,user.getUname(),user.getPwd(),user.getNickName(),user.getEmail());
    }

    @Override
    public List<User> getUserListByDate(String loginTime, String quitTime) {
        return super.executeQuery("select * from e_user where loginTime between ? and ? and quitTime between ? and ?",loginTime,quitTime,loginTime,quitTime);
    }

    @Override
    public List<User> getUserListByKeyName(String uname) {
        return super.executeQuery("select * from e_user where uname like ?","%"+ uname + "%");
    }

    @Override
    public List<User> getUserByUserNum(String userNum) {
        return super.executeQuery("select * from e_user where userNum = ?",userNum);
    }

    @Override
    public void updateUserLoginTime(User userData) {
        super.executeUpdate("update e_user set loginTime = ? where id = ?",userData.getLoginTime(),userData.getId());
    }

    @Override
    public void delUserItem(Integer userId) {
        super.executeUpdate("delete from e_user where id = ?",userId);
    }

    @Override
    public void setUserById(User user,String birthDate) {
        super.executeUpdate("update e_user " +
                "set nickName = ?,sex = ?, age = ? , birthDate = ? , constellation = ? , email = ? , perSign = ? " +
                "where id = ?",user.getNickName(),user.getSex(),user.getAge(),birthDate,user.getConstellation(),user.getEmail(),user.getPerSign(),user.getId());

    }

    @Override
    public void modifyPwdById(Integer id, String pwd) {
        super.executeUpdate("update e_user set pwd = ? where id = ?",pwd,id);

    }

    @Override
    public User getUserById(Integer id) {
        return super.load("select * from e_user where id = ?",id);
    }

    @Override
    public void setUserQuitTimeById(Integer id, String quitTime) {
        super.executeUpdate("update e_user set quitTime = ? where id = ?",quitTime,id);
    }

    @Override
    public void setUserStayTimeById(Integer id, String stayTime) {
        super.executeUpdate("update e_user set stayTime = ? where id = ?",stayTime,id);
    }

}
