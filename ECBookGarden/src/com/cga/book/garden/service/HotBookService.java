package com.cga.book.garden.service;

import com.cga.book.garden.pojo.HotBook;

import java.util.List;

public interface HotBookService {

    List<HotBook> getBookListByType(String type);

    //根据id查询hotBook信息
    HotBook getHotBookById(Integer id);

    //设置畅销书
    void setLoveHotBook(HotBook hotBook);
}
