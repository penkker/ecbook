package com.cga.book.garden.pojo;

public class Admin {

    private Integer id;
    private String loginTime;
    private String uname;
    private String pwd;
    private String continueTime;
    private String quitTime;

    public Admin() {
    }

    public Admin(Integer id) {
        this.id = id;
    }

    public Admin(Integer id, String loginTime) {
        this.id = id;
        this.loginTime = loginTime;
    }

    public Admin(Integer id, String loginTime, String uname, String pwd, String continueTime, String quitTime) {
        this.id = id;
        this.loginTime = loginTime;
        this.uname = uname;
        this.pwd = pwd;
        this.continueTime = continueTime;
        this.quitTime = quitTime;
    }

    public Admin(Integer id, String loginTime, String uname, String pwd) {
        this.id = id;
        this.loginTime = loginTime;
        this.uname = uname;
        this.pwd = pwd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
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

    public String getContinueTime() {
        return continueTime;
    }

    public void setContinueTime(String continueTime) {
        this.continueTime = continueTime;
    }

    public String getQuitTime() {
        return quitTime;
    }

    public void setQuitTime(String quitTime) {
        this.quitTime = quitTime;
    }
}
