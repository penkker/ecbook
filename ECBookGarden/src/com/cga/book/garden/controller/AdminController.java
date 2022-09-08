package com.cga.book.garden.controller;

import com.cga.book.garden.pojo.Admin;
import com.cga.book.garden.pojo.Book;
import com.cga.book.garden.pojo.Tea;
import com.cga.book.garden.pojo.User;
import com.cga.book.garden.service.AdminService;
import com.cga.book.garden.service.BookService;
import com.cga.book.garden.service.TeaService;
import com.cga.book.garden.service.UserService;
import com.google.gson.Gson;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class AdminController {

    private AdminService adminService;
    private BookService bookService;
    private UserService userService;
    private TeaService teaService;

    public String login(String uname, String pwd, HttpSession session){

        Admin admin = adminService.login(uname, pwd);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String adminTime = sdf.format(new Date());

        session.setAttribute("currAdmin",admin);

        if(admin != null){
            Admin adminData = new Admin(0,adminTime,admin.getUname(),admin.getPwd());

            adminService.loginData(adminData);

            return "admin/index_admin";

        }

        return "user/login_regist";

    }

    //根据图书编号查询图书信息,图书编号为5位
    public String getBook(String bookNum,String middleArg,String bookName) {

        //测试日期
//        System.out.println(middleArg);
        Gson gson = new Gson();
        String json;
        List<Book> bookList = bookService.getBook(bookNum, middleArg, bookName);

        json = gson.toJson(bookList);

        return "json:" + json;

    }

    //book_three页面
    public String delBookItem(Integer bookId){

        bookService.delBookItem(bookId);

        return "register:<script language='JavaScript'>alert('删除成功');" +
                "window.location.href='page.do?operate=page&page=admin/book_three';</script>";

    }

    //index_admin页面
    public String delBookItemIndex(Integer bookId){

        bookService.delBookItem(bookId);

        return "register:<script language='JavaScript'>alert('删除成功');" +
                "window.location.href='page.do?operate=page&page=admin/index_admin';</script>";

    }

    public String getAdmin(String middleArg){

        String[] splitTime = middleArg.split(",");

        //查看客户端发送来的时间数据
        System.out.println(Arrays.toString(splitTime));

        List<Admin> adminList = adminService.getAdminListByDate(splitTime[0],splitTime[1]);

        Gson gson = new Gson();
        String json = gson.toJson(adminList);

        return "json:" + json;
    }

    public String delAdminItem(Integer adminId){

        adminService.delAdminItemById(adminId);

        return "register:<script language='JavaScript'>alert('删除成功');" +
                "window.location.href='page.do?operate=page&page=admin/look_one';</script>";

    }


    //管理员退出登录
    public String quitLogin(){

        //此时id为最大的id
        Integer maxId = adminService.getMaxId();
        Admin admin = new Admin();
        admin.setId(maxId);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Admin adminById = adminService.getAdminById(admin.getId());
        String quitTime = sdf.format(new Date());

        admin.setQuitTime(quitTime);
        adminService.insertQuit(admin);

        adminById.setQuitTime(quitTime);
        String currLoginTime = adminById.getLoginTime();
        String currQuitTime = adminById.getQuitTime();

        try {
            Date parseLoginTime = sdf.parse(currLoginTime);
            Date parseQuitTime = sdf.parse(currQuitTime);

            long parseLoginTimeMinutes = parseLoginTime.getTime();
            long parseQuitTimeMinutes = parseQuitTime.getTime();

            System.out.println("parseLoginTimeTime = " + parseLoginTimeMinutes);
            System.out.println("parseQuitTimeTime = " + parseQuitTimeMinutes);

            long continueTimeMill = parseQuitTimeMinutes - parseLoginTimeMinutes;

            System.out.println("continueTimeMill = " + continueTimeMill);

            String continueTime = sdf.format(continueTimeMill);
            String[] split = continueTime.split(" ");
            String subPre = split[1].substring(0, 2);
            String subLast = split[1].substring(2);
            String newContinueTime = "00" + subLast;

            System.out.println("newContinueTime = " + newContinueTime);

            admin.setContinueTime(newContinueTime);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        adminService.insertContinue(admin);
        return "user/login_regist";
    }

    public String getUser(String userNum,String middleArg,String uname){

        Gson gson = new Gson();
        String json;

        List<User> userList = userService.getUser(userNum, middleArg, uname);

        json = gson.toJson(userList);

        return "json:" + json;
    }
    //删除一条用户信息
    public String delUserItem(Integer userId){

        userService.delUserItem(userId);

        return "register:<script language='JavaScript'>alert('删除成功');" +
                "window.location.href='page.do?operate=page&page=admin/user_three';</script>";

    }

    public String getTradeInfo(String bookNum,String middleArg,String bookName) {

        //测试日期
//        System.out.println(middleArg);
        Gson gson = new Gson();
        String json;
        List<Book> bookList = bookService.getTradeInfo(bookNum, middleArg, bookName);

        json = gson.toJson(bookList);

        System.out.println();

        return "json:" + json;

    }

    public String setUser(Integer booKId,String uname,String pwd,String headImg){

        userService.insertUser(new User(booKId,uname,pwd));
        return "admin/set_index";
    }


    public String setBook(Integer bookId,String bookName,String bookPrice,String bookImg){

        bookService.insertBook(new Book(bookId,bookName,Double.valueOf(bookPrice)));

        return "admin/set_index";
    }

    public String setTea(Integer teaId,String teaName,String teaPrice,String teaImg){

        teaService.insertTea(new Tea(teaId,teaName,teaPrice));

        return "admin/set_index";
    }

    public String delUserItemLookTwo(Integer userId){

        userService.delUserItem(userId);

        return "register:<script language='JavaScript'>alert('删除成功');" +
                "window.location.href='page.do?operate=page&page=admin/look_two';</script>";
    }
}