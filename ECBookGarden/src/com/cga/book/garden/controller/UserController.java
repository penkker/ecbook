package com.cga.book.garden.controller;

import com.cga.book.garden.pojo.Love;
import com.cga.book.garden.pojo.Reply;
import com.cga.book.garden.pojo.User;
import com.cga.book.garden.service.LoveService;
import com.cga.book.garden.service.ReplyService;
import com.cga.book.garden.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class UserController {

    private UserService userService;
    private ReplyService replyService;
    private LoveService loveService;

    //登录
    public String login(String uname, String pwd, HttpSession session){

        //用户登录
        User user = userService.login(uname, pwd);
        List<Reply> replyListTea = replyService.getReplyListBydsId(0);
        for (Reply reply : replyListTea){
            Integer id = reply.getUserId().getId();
            User userById = userService.getUserById(id);

            reply.setUserId(userById);
            reply.setHeadImg(userById.getHeadImg());
        }

        List<Reply> replyListBook = replyService.getReplyListBydsId(2);
        for (Reply reply : replyListBook){
            Integer id = reply.getUserId().getId();
            User userById = userService.getUserById(id);

            reply.setUserId(userById);
            reply.setHeadImg(userById.getHeadImg());
        }

        //刷新聚源有你回复
        int k = 1;
        List<Reply> replyListds = replyService.getReplyListBydsId(1);
        for (Reply reply : replyListds){
            Integer id = reply.getUserId().getId();
            User userById = userService.getUserById(id);

            reply.setUserId(userById);
            reply.setHeadImg(userById.getHeadImg());
            reply.setTemp(k++);

        }

        session.setAttribute("replyListdsId",replyListds);
        //

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String userTime = sdf.format(new Date());
        User userData = new User(user.getId(),userTime);

        userService.updateUserLoginTime(userData);
        //管理员登陆
//        Admin admin = adminService.login(uname, pwd);
//        Object kaptcha = session.getAttribute("KAPTCHA_SESSION_KEY");
//        session.setAttribute("currAdmin",admin);
        session.setAttribute("currUser",user);
        session.setAttribute("replyListTea",replyListTea);
        session.setAttribute("replyListBook",replyListBook);

        //用户存在
        if(user != null){
            return "index";
        }
//        //管理员存在
//        if(admin != null){
//            return "admin/index_admin";
//        }

            return "redirect:page.do?operate=page&page=user/login_regist";
    }


    public String regist(){

        return "redirect:page.do?operate=page&page=user/regist";

    }

    public String registSuccess(String uname,String pwd,String deterPwd,String nickName,String email){
        String registSuccessPage = userService.registSuccess(new User(uname, pwd, nickName, email), deterPwd);

        if("error".equals(registSuccessPage)){
            return "register:<script language='JavaScript'>alert('用户名已存在');" +
                    "window.location.href='page.do?operate=page&page=user/login_regist';</script>";
        }else if("true".equals(registSuccessPage)){

            //注册成功
            return registSuccessPage();

        }
        //弃用
//        //确定密码或复选框错误则返回注册界面
//        if ("verError".equals(registSuccessPage)){
//
//            return "json:<script language='JavaScript'>alert('请重新输入密码或阅读协议');" +
//                    "window.location.href='page.do?operate=page&page=user/regist'"+
//                    "</script>";
//        }

        return "register:<script language='JavaScript'>alert('密码两次天写不匹配');" +
                "window.location.href='page.do?operate=page&page=user/login_regist';</script>";

    }

    //注册成功
    public String registSuccessPage(){

        return "register:<script language='JavaScript'>alert('注册成功');" +
                "window.location.href='page.do?operate=page&page=user/login_regist';</script>";
    }

    //访客登录
    public String guestLogin(HttpSession session){
        String guest = "guest";
        session.setAttribute("userGuest",guest);
        return "redirect:page.do?operate=page&page=index_guest";

    }

    public String personCenter(){

        return "";
    }

    //保存用户
    public String saveUser(Integer userId, String nickName, String sex, Integer age, String birthDate, String constellation, String email, String perSign){

        System.out.println(nickName);

//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String bd = sdf.format(sdf);
        String newSex;
        if("1".equals(sex)){
            newSex = "男";
        }else{
            newSex = "女";
        }

        User user = new User(userId,nickName,email,newSex,perSign,age,constellation);

        userService.setUserById(user,birthDate);

        return "personcenter/user_base_info";

    }

    //修改密码
    public String modifyPwd(String curPwd, String newPwd,String confirmPwd,HttpSession session){

        User currUser = (User) session.getAttribute("currUser");

        if(currUser.getPwd().equals(curPwd)){
            if(confirmPwd.equals(newPwd)){
                userService.modifyPwdById(currUser.getId(),confirmPwd);
                return "register:<script language='JavaScript'>alert('修改成功!');" +
                        "window.location.href='page.do?operate=page&page=personcenter/user_pass_info';</script>";

            }else{
                return "register:<script language='JavaScript'>alert('两次输入密码错误!');" +
                        "window.location.href='page.do?operate=page&page=personcenter/user_pass_info';</script>";
            }
        }else{
            return "register:<script language='JavaScript'>alert('请重新输入密码!');" +
                    "window.location.href='page.do?operate=page&page=personcenter/user_pass_info';</script>";
        }

    }

    //用户退出登录
    public String quitLogin(HttpSession session){

        User currUser = (User)session.getAttribute("currUser");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String quitTime = sdf.format(new Date());

        userService.setUserQuitTimeById(currUser.getId(),quitTime);
        currUser.setQuitTime(quitTime);

        Date parseLoginTime = null;
        Date parseQuitTime = null;
        try {
            parseLoginTime = sdf.parse(currUser.getLoginTime());
            parseQuitTime = sdf.parse(currUser.getQuitTime());

            long parseLoginTimeMinutes = parseLoginTime.getTime();
            long parseQuitTimeMinutes = parseQuitTime.getTime();

            long continueTimeMill = parseQuitTimeMinutes - parseLoginTimeMinutes;

            String continueTime = sdf.format(continueTimeMill);
            String[] split = continueTime.split(" ");
            String subPre = split[1].substring(0, 2);
            String subLast = split[1].substring(2);
            String newContinueTime = "00" + subLast;
            currUser.setStayTime(newContinueTime);

            //打印时间
            System.out.println("parseLoginTimeTime = " + parseLoginTimeMinutes);
            System.out.println("parseQuitTimeTime = " + parseQuitTimeMinutes);
            System.out.println("continueTimeMill = " + continueTimeMill);
            System.out.println("newContinueTime = " + newContinueTime);

            userService.setUserStayTimeById(currUser.getId(),currUser.getStayTime());

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "user/login_regist";

    }

    @Deprecated
    public String setHead(String args, HttpServletRequest request){

        try {
            BufferedReader reader = request.getReader();

            FileWriter fileWriter = new FileWriter(new File("a.PNG"));
            char[] bytes = new char[1024];
            char[] bs = new char[1024];
            int len = 0;

            while ((len = reader.read(bytes))!=-1){
               fileWriter.write(bs,0,len);
            }

            reader.close();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(args);

        return "json:" + "";
    }

    //全站搜索
    public String jumpPage(String page,HttpSession session){

        if("个人中心".equals(page)){

            List<Love> goodsLoveList = loveService.getLoveList();
            session.setAttribute("goodsLoveList",goodsLoveList);
            return "personcenter/user";

        }else if("和韵茶坊".equals(page)){

            return "tea/come_tea";
        }else if("联系我们".equals(page)){

            return "contact/contact";
        }

        return "index";
    }

    //获取运营时长
    public String getTime(HttpSession session){

        Date date = new Date();
        long time = date.getTime();

        String strTime = time + "";
        String runTimeStr = strTime.substring(0, 9);
        long runTime = Long.parseLong(runTimeStr);

        session.setAttribute("runTime", runTime);

        return "review/review";
    }

    //个人中心收藏
    public String personStore(HttpSession session){

        List<Love> goodsLoveList = loveService.getLoveList();

        session.setAttribute("goodsLoveList",goodsLoveList);

        return "personcenter/user";
    }

}