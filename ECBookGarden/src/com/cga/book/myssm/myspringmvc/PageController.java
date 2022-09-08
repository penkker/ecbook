package com.cga.book.myssm.myspringmvc;

public class PageController {

    public String page(String page){
        return page;
    }

    //获取图片资源
    public String img(String img){
        return "redirect:" + img;
    }
}
