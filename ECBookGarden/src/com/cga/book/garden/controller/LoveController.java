package com.cga.book.garden.controller;

import com.cga.book.garden.pojo.HotBook;
import com.cga.book.garden.pojo.Love;
import com.cga.book.garden.service.HotBookService;
import com.cga.book.garden.service.LoveService;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public class LoveController {

    private LoveService loveService;
    private HotBookService hotBookService;

    public String showLove(Integer id, HttpSession session){

        List<Love> goodsLoveList = loveService.getGoodsLove(id);
        Map<String, List<Object>> relevantList = loveService.getRelevantList(goodsLoveList);
        List<Object> relevantData = relevantList.get("relevantData");

        session.setAttribute("goodsLoveList",goodsLoveList);
        session.setAttribute("relevantList",relevantData);

        return "redirect:page.do?operate=page&page=love/love_page";

    }

    //对于index页面
    public String getLoveList(HttpSession session){

        List<Love> goodsLoveList = loveService.getLoveList();
        Map<String, List<Object>> relevantList = loveService.getRelevantList(goodsLoveList);
        List<Object> relevantData = relevantList.get("relevantData");

        session.setAttribute("goodsLoveList",goodsLoveList);
        session.setAttribute("relevantList",relevantData);

        return "redirect:page.do?operate=page&page=love/love_page";

    }

    //对于收藏中心页面
    public String cancelLove(Integer id,HttpSession session){

        loveService.delLoveById(id);

        List<Love> loveList = loveService.getLoveList();
        Map<String, List<Object>> relevantList = loveService.getRelevantList(loveList);
        List<Object> relevantData = relevantList.get("relevantData");

        session.setAttribute("goodsLoveList",loveList);
        session.setAttribute("relevantList",relevantData);

        return "redirect:page.do?operate=page&page=love/love_page";

    }

    //展示收藏的热门书籍和普通藏品
    public String showHotLove(Integer id, HttpSession session){

        List<Love> goodsLoveList = loveService.getGoodsLoveHot(id);
        List<Love> list = loveService.getLoveList();
        Map<String, List<Object>> relevantList = loveService.getRelevantList(list);
        List<Object> relevantData = relevantList.get("relevantData");

        HotBook hotBook = hotBookService.getHotBookById(id);

        session.setAttribute("goodsLoveList",goodsLoveList);
        session.setAttribute("relevantList",relevantData);

        return "redirect:page.do?operate=page&page=love/love_page";

    }

}