package com.cga.book.garden.service;

import com.cga.book.garden.pojo.Book;

import java.util.List;

public interface BookService {

    //根据关键字查询图书信息
    List<Book> getBookListByKeyName(String bookName);

    //根据id查询图书信息
    Book getBookById(Integer id);

    //根部图书编号查询图书信息
    List<Book> getBookByBookNum(String bookNum);

    //根据进货出货日期查询图书日期
    List<Book> getBookListByDate(String enterDate,String exportDate);

    List<Book> getIsOrNotBookList(String bookNum,String bookName);

    //根据id删除指定图书
    void delBookItem(Integer bookId);

    //获取图书总数
    Long getBookCount();

    //获取总价
    void setTotalPrice();

    //获取所有图书信息
    List<Book> getBookList();

    //获取图书信息
    List<Book> getBook(String bookNum,String middleArg,String bookName);

    //获取商品信息
    List<Book> getTradeInfo(String bookNum,String middleArg,String bookName);

    //根据销售日期获取商品信息
    List<Book> getTradeInfoByDate(String sellPre, String sellLast);

    //插入一条图书记录
    void insertBook(Book book);

    List<Book> getBookByLimitId(Integer left,Integer right);

    //根据bookTypeA获取图书信息
    List<Book> getBookListByBookType(String bookType);
}
