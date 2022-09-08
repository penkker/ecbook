package com.cga.book.garden.pojo;

import java.sql.Date;
import java.util.List;

public class User {

    private Integer id;
    private String uname;
    private String pwd;
    private String bookLike;
    private String paperLike;
    private String nickName;
    private String email;
    private String sex;
    private Date birthDate;
    private String perSign;
    private String headImg;
    private String stayTime;
    private String loginTime;
    private Integer age;
    private String userNum;
    private String quitTime;
    private String registTime;
    private String constellation;  //星座

    private List<Paper> paperList; //1:n
    private List<Book> bookList; //1:n
    private Cart cart; //1:1
    private List<Order> orderList; //1:n

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String uname, String pwd) {
        this.id = id;
        this.uname = uname;
        this.pwd = pwd;
    }

    public User(String uname, String pwd, String nickName, String email) {
        this.uname = uname;
        this.pwd = pwd;
        this.nickName = nickName;
        this.email = email;
    }

    public User(Integer id, String uname, String pwd, String bookLike, String paperLike, String nickName, String email, String sex, Date birthDate, String perSign, String headImg) {
        this.id = id;
        this.uname = uname;
        this.pwd = pwd;
        this.bookLike = bookLike;
        this.paperLike = paperLike;
        this.nickName = nickName;
        this.email = email;
        this.sex = sex;
        this.birthDate = birthDate;
        this.perSign = perSign;
        this.headImg = headImg;
    }

    public User(Integer id,String nickName, String email, String sex, String perSign, Integer age, String constellation) {
        this.id = id;
        this.nickName = nickName;
        this.email = email;
        this.sex = sex;
        this.perSign = perSign;
        this.age = age;
        this.constellation = constellation;
    }

    public User(Integer id, String loginTime) {
        this.id = id;
        this.loginTime = loginTime;
    }

    public String getConstellation() {
        return constellation;
    }

    public void setConstellation(String constellation) {
        this.constellation = constellation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getRegistTime() {
        return registTime;
    }

    public void setRegistTime(String registTime) {
        this.registTime = registTime;
    }

    public String getBookLike() {
        return bookLike;
    }

    public void setBookLike(String bookLike) {
        this.bookLike = bookLike;
    }

    public String getPaperLike() {
        return paperLike;
    }

    public void setPaperLike(String paperLike) {
        this.paperLike = paperLike;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPerSign() {
        return perSign;
    }

    public void setPerSign(String perSign) {
        this.perSign = perSign;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public List<Paper> getPaperList() {
        return paperList;
    }

    public void setPaperList(List<Paper> paperList) {
        this.paperList = paperList;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public String getStayTime() {
        return stayTime;
    }

    public void setStayTime(String stayTime) {
        this.stayTime = stayTime;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum;
    }

    public String getQuitTime() {
        return quitTime;
    }

    public void setQuitTime(String quitTime) {
        this.quitTime = quitTime;
    }
}
