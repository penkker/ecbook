package com.cga.book.garden.dao;

import com.cga.book.garden.pojo.Book;
import com.cga.book.garden.pojo.Love;
import com.cga.book.garden.pojo.Tea;

import java.util.List;

public interface LoveDAO {

    //设置茶作为爱好信息
    void setLoveTea(Tea tea);

    //向收藏表里添加图书信息
    void setLoveBook(Book book);

    //获取所有收藏信息
    List<Love> getLoveList();

    //删除指定id的收藏信息
    void delLoveById(Integer id);

    Love getLoveById(Integer id);

    //根据收藏时间获取收藏信息
    Love getLOveByLoveTime(String loveTime);

    //设置收藏数量加1
    void setLoveTypeCount(Integer count,Integer bookId);

    //设置收藏数量为1
    void setLoveTypeCountOne(Integer count,Integer bookId);

    //设置收藏类型
    void setLoveType(String type,Integer bookId);
}
