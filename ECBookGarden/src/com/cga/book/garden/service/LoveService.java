package com.cga.book.garden.service;

import com.cga.book.garden.pojo.Love;

import java.util.List;
import java.util.Map;

public interface LoveService {

    //获取收藏信息
    List<Love> getGoodsLove(Integer id);

    //获取所有收藏信息
    List<Love> getLoveList();

    //删除指定id的收藏信息
    void delLoveById(Integer id);

    //根据id查询收藏信息
    Love getLoveById(Integer id);

    //获取相关商品
    Map<String,List<Object>> getRelevantList(List<Love> loveList);

    //热门图书
    List<Love> getGoodsLoveHot(Integer id);
}
