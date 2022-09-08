package com.cga.book.garden.dao;

import com.cga.book.garden.pojo.Book;

import java.util.List;

public interface BookDAO {
    //根据图书名关键字查询图书信息
    List<Book> getBookListByKeyName(String bookName);

    //根据id查询图书信息
    Book getBookById(Integer id);

    //根据图书编号查询图书信息
    List<Book> getBookByBookNum(String bookNum);

    //根据进货出货日期查询图书日期
    List<Book> getBookListByDate(String enterDate,String exportDate);

    //根据id删除图书信息
    void delBookItem(Integer bookId);

    //获取图书总数
    Long getBookCount();

    //获取所有图书信息
    List<Book> getBookList();

    //根据销售日期获取商品信息
    List<Book> getTradeInfoByDate(String sellPre, String sellLast);

    void insertBook(Book book);

    //根据id区间查询图书信息
    List<Book> getBookByLimitId(Integer left, Integer right);

    //根据bookTypeA获取图书信息
    List<Book> getBookListByBookType(String bookType);
}
