package com.cga.book.garden.controller;

import com.cga.book.garden.pojo.Book;
import com.cga.book.garden.pojo.HotBook;
import com.cga.book.garden.pojo.Tea;
import com.cga.book.garden.service.BookService;
import com.cga.book.garden.service.HotBookService;
import com.cga.book.garden.sort.MyComparatorPrice;
import com.cga.book.garden.sort.MyComparatorSellCount;
import com.google.gson.Gson;
import com.sun.istack.internal.Nullable;

import javax.servlet.http.HttpSession;
import java.util.*;

public class BookController {

    private BookService bookService;
    private HotBookService hotBookService;

    //正常用户访问的书
    public String getBookList(String bookName, HttpSession session){
        //根据图书名字关键字查询图书信息,若无bookName则查询所有图书
        List<Book> bookListByKeyName = null;
        if(bookName == null){

            String newBookName = "";
            bookListByKeyName = bookService.getBookListByKeyName(newBookName);
        }else{

            bookListByKeyName = bookService.getBookListByKeyName(bookName);
        }

        session.setAttribute("bookListByKeyName",bookListByKeyName);
        session.setAttribute("bookSizes",bookListByKeyName.size());

        //新页面
        return "redirect:page.do?operate=page&page=search/bookclass";

    }

    //访客登录访问的书
    public String getBookListGuest(String bookName, HttpSession session){
        //根据图书名字关键字查询图书信息,若无bookName则查询所有图书

        List<Book> bookListByKeyName = bookService.getBookListByKeyName(bookName);
        session.setAttribute("bookListByKeyName",bookListByKeyName);

        return "redirect:page.do?operate=page&page=guest/show_book_guest";


    }

    public String getBookListAdmin(){
        List<Book> bookListByKeyName = bookService.getBookListByKeyName("");

        Gson gson = new Gson();
        String json = gson.toJson(bookListByKeyName);

        return "json:" + json;
    }

    public String getThBook(String bookType,HttpSession session){

        List<Book> bookTypeAList = bookService.getBookListByBookType(bookType);

        session.setAttribute("bookTypeAList",bookTypeAList);

        if("文学".equals(bookType)){

            return "redirect:page.do?operate=page&page=search/wenx_class";
        }else if ("科技".equals(bookType)){

            return "redirect:page.do?operate=page&page=search/keji_class";
        }else if("小说".equals(bookType)){

            return "redirect:page.do?operate=page&page=search/novel_class";
        }else if("生活".equals(bookType)){

            return "redirect:page.do?operate=page&page=search/life_class";

        }

        return "redirect:page.do?operate=page&page=search/bookclass";

    }

    //查询图书信息
    public String getDesignBook(String keyName,HttpSession session){

        List<Book> bookListByKeyName = bookService.getBookListByKeyName(keyName);

        session.setAttribute("bookListByKeyName",bookListByKeyName);
        session.setAttribute("bookSizes",bookListByKeyName.size());

        return "search/bookclass";
    }

    //排序图书信息
    public String sortBook(String sort,HttpSession session){

        List<Book> bookListByKeyName = (List<Book>)session.getAttribute("bookListByKeyName");
        if(sort != null){

            if("价格排序".equals(sort)){

                Collections.sort(bookListByKeyName, new Comparator<Book>() {
                    @Override
                    public int compare(Book o1, Book o2) {
                        double aDouble = o1.getSellPrice();
                        double bDouble = o2.getSellPrice();

                        if(aDouble> bDouble){

                            return -1;
                        }else{

                            return 1;
                        }
                    }
                });

            }else if("销量排序".equals(sort)){

                Collections.sort(bookListByKeyName, new Comparator<Book>() {
                    @Override
                    public int compare(Book o1, Book o2) {

                        int aIntsssss = Integer.parseInt(o1.getSellCount());
                        int bInts = Integer.parseInt(o2.getSellCount());

                        if(aIntsssss > bInts){

                            return -1;
                        }else{

                            return 1;
                        }
                    }
                });

            }else{
                Collections.sort(bookListByKeyName, new Comparator<Book>() {
                    @Override
                    public int compare(Book o1, Book o2) {
                        int aDouble = o1.getId();
                        int bDouble = o2.getId();

                        if(aDouble > bDouble){

                            return -1;
                        }else{

                            return 1;
                        }
                    }
                });
            }

        }

        session.setAttribute("bookListByKeyName",bookListByKeyName);
        session.setAttribute("bookSizes",bookListByKeyName.size());

        return "search/bookclass";
    }

    public String hotBook(HttpSession session){

        Map<String,List<HotBook>> hotBookMap = new HashMap<>();

        List<HotBook> hotBookListLiterature = hotBookService.getBookListByType("文学");
        List<HotBook> hotBookListTechnology = hotBookService.getBookListByType("科技");
        List<HotBook> hotBookListNovel = hotBookService.getBookListByType("小说");
        List<HotBook> hotBookListLife = hotBookService.getBookListByType("生活");

        hotBookMap.put("hotBookListLiterature",hotBookListLiterature);
        hotBookMap.put("hotBookListTechnology",hotBookListTechnology);
        hotBookMap.put("hotBookListNovel",hotBookListNovel);
        hotBookMap.put("hotBookListLife",hotBookListLife);

        session.setAttribute("hotBookMap",hotBookMap);

        return "view/view_book";
    }

    //重定向到商品详情页面
    public String getGoodsInfo(Integer id, HttpSession session){

        session.setAttribute("hotBookId",id);
        return "redirect:page.do?operate=page&page=bookdetail/product_book";

    }

    //展示商品详情
    //方法改动加入热门图书
    public String showGoodsInfo(HttpSession session){

        Integer id = (Integer)session.getAttribute("hotBookId");
        int newId = id;
        Gson gson = new Gson();
        HotBook hotBook = hotBookService.getHotBookById(id);


        session.setAttribute("hotBook",hotBook);
        String json = gson.toJson(hotBook);

        return "json:" + json;
    }

}