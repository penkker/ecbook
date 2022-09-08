package com.cga.book.garden.service.impl;

import com.cga.book.garden.dao.UserDAO;
import com.cga.book.garden.pojo.User;
import com.cga.book.garden.service.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    @Override
    public User login(String uname, String pwd) {
        return userDAO.getUser(uname,pwd);
    }

    @Override
    public List<User> getUserList() {
        return userDAO.getUserList();
    }

    public void registUser(User user){
        userDAO.insertUser(user);
    }

    public String registSuccess(User user,String deterPwd){

        if(deterPwd.equals(user.getPwd())){
            List<User> userList = getUserList();
            for(User userItem : userList){
                String userPreUname = userItem.getUname();
                String userNowUname = user.getUname();
                //如果数据库存在该用户,则返回注册界面
                if(userPreUname.equals(userNowUname)){
                    return "error";
                }
            }

            //如果数据库不存在该用户则进行注册并且返回注册页面
            registUser(user);
            return "true";
        }

        return "codeNotSame";

    }

    @Override
    public List<User> getUserListByDate(String loginTime, String quitTime) {
        List<User> userListByDate = userDAO.getUserListByDate(loginTime, quitTime);

        return userListByDate;
    }

    @Override
    public List<User> getIsOrNotUserList(String userNum, String uname) {
        List<User> userList = new ArrayList<>();

        if(uname != null || !"".equals(userNum)){

            if(uname != null){

                userList = getUserListByKeyName(uname);
            } else if (!"".equals(userNum)){

                userList = getUserByUserNum(userNum);
            }else if (uname != null && !"".equals(userNum)){

                return null;
            }

        }
        return userList;
    }

    @Override
    public List<User> getUserListByKeyName(String uname) {

        List<User> userListByKeyName = userDAO.getUserListByKeyName(uname);

        return userListByKeyName;
    }

    @Override
    public List<User> getUserByUserNum(String userNum) {
        List<User> userByUserNum = userDAO.getUserByUserNum(userNum);

        return userByUserNum;
    }

    @Override
    public void updateUserLoginTime(User userData) {
        userDAO.updateUserLoginTime(userData);
    }

    @Override
    public void delUserItem(Integer userId) {
        userDAO.delUserItem(userId);
    }

    @Override
    public void setUserById(User user,String birthDate) {
        userDAO.setUserById(user,birthDate);
    }

    @Override
    public void modifyPwdById(Integer id,String pwd) {
        userDAO.modifyPwdById(id,pwd);
    }

    @Override
    public User getUserById(Integer id) {
        return userDAO.getUserById(id);
    }

    @Override
    public void setUserQuitTimeById(Integer id, String quitTime) {
        userDAO.setUserQuitTimeById(id,quitTime);
    }

    @Override
    public void setUserStayTimeById(Integer id, String stayTime) {
        userDAO.setUserStayTimeById(id,stayTime);
    }

    @Override
    public void insertUser(User user) {
        userDAO.insertUser(user);
    }

    @Override
    public List<User> getUser(String userNum, String middleArg, String uname) {

        List<User> userList = null;

        if (middleArg != null) {

            String[] splitMiddle = middleArg.split(",");
            //    System.out.println(splitMiddle.length);
            List<String> strMiddle = Arrays.asList(splitMiddle);

            System.out.println("strMiddle.size() = " + strMiddle.size());

            if ("".equals(userNum) && uname == null) {

                if (strMiddle.size() == 2) {

                    userList = getUserListByDate(splitMiddle[0], splitMiddle[1]);
                }
            } else {

                userList = getIsOrNotUserList(userNum,uname);
            }
        }else{

            userList = getIsOrNotUserList(userNum,uname);
        }

        return userList;
    }

}
