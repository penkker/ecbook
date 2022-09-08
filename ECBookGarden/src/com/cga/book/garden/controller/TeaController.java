package com.cga.book.garden.controller;

import com.cga.book.garden.pojo.Tea;
import com.cga.book.garden.service.HotBookService;
import com.cga.book.garden.service.TeaService;
import com.cga.book.garden.sort.MyComparatorPrice;
import com.cga.book.garden.sort.MyComparatorSellCount;
import com.google.gson.Gson;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TeaController {

    private TeaService teaService;
    private HotBookService hotBookService;

    public String getTeaList(){

        List<Tea> teaList = teaService.getTeaList("热门");

        for (Tea tea: teaList){
            tea.setTeaPrice(tea.getTeaPrice());
        }

        Gson gson = new Gson();
        String json = gson.toJson(teaList);

        return "json:" + json;
    }

    //重定向到商品详情页面
    public String getGoodsInfo(Integer id, HttpSession session){
        int ids = id;
        session.setAttribute("teaId",ids);
        if(ids > 80000){
            return "redirect:page.do?operate=page&page=bookdetail/product";
        }else {
            return "redirect:love.do?operate=getLoveList";
        }
    }

    //展示商品详情
    //方法改动加入热门图书
    public String showGoodsInfo(HttpSession session){

        Integer id = (Integer)session.getAttribute("teaId");
        int newId = id;
        Gson gson = new Gson();
        Tea tea = teaService.getTeaById(id);

        if(tea != null){

            tea.setTeaPrice(tea.getTeaPrice());
        }

        session.setAttribute("tea",tea);
        String json = gson.toJson(tea);

        return "json:" + json;
    }

    //获取推荐的茶信息
    public String getTeaListReco(){

        List<Tea> teaList = teaService.getTeaList("推荐");
        for (Tea tea: teaList){
            tea.setTeaPrice(tea.getTeaPrice());
        }

        Gson gson = new Gson();
        String json = gson.toJson(teaList);

        return "json:" + json;
    }

    //获取纪念品信息
    public String getTeaListAdvan(){
        List<Tea> teaList = teaService.getTeaList("高档");
        for (Tea tea: teaList){
            tea.setTeaPrice(tea.getTeaPrice());
        }

        Gson gson = new Gson();
        String json = gson.toJson(teaList);

        return "json:" + json;
    }

    //获取茶壶信息
    public String getTeaListSet(){
        List<Tea> teaList = teaService.getTeaList("茶壶");
        for (Tea tea : teaList){
            tea.setTeaPrice(tea.getTeaPrice());
        }

        Gson gson = new Gson();
        String json = gson.toJson(teaList);

        return "json:" + json;
    }

    //查询茶信息
    public String getDesignTea(String keyName,HttpSession session){

        List<Tea> teaListByTeaKeyName = teaService.getTeaListByTeaKeyName(keyName);
        for (Tea tea: teaListByTeaKeyName){
            tea.setTeaPrice(tea.getTeaPrice());
        }
        session.setAttribute("teaListByTeaKeyName",teaListByTeaKeyName);

        return "tea/tea_all";
    }

    //排序茶信息
    public String sortGoods(String sort,HttpSession session){

        List<Tea> teaListByTeaKeyName = (List<Tea>)session.getAttribute("teaListByTeaKeyName");
        if(sort != null){

            if("价格排序".equals(sort)){

                Collections.sort(teaListByTeaKeyName,new MyComparatorPrice());

            }else if("销量排序".equals(sort)){

                Collections.sort(teaListByTeaKeyName,new MyComparatorSellCount());

            }else{
                Collections.sort(teaListByTeaKeyName, new Comparator<Tea>() {
                    @Override
                    public int compare(Tea o1, Tea o2) {
                        double aDouble = Double.parseDouble(o1.getTeaPrice());
                        double bDouble = Double.parseDouble(o2.getTeaPrice());

                        if(aDouble > bDouble){

                            return -1;
                        }else{

                            return 1;
                        }
                    }
                });
            }

        }

        session.setAttribute("teaListByTeaKeyName",teaListByTeaKeyName);

        return "tea/tea_all";
    }

    //查询金额区间茶信息
    public String selectTea(String left,String right,HttpSession session){

        List<Tea> teaListByPrice = teaService.getTeaListByPrice(left, right);
        for (Tea tea: teaListByPrice){

            tea.setTeaPrice(tea.getTeaPrice());
        }

        session.setAttribute("teaListByTeaKeyName",teaListByPrice);

        return "tea/tea_all";
    }

}
