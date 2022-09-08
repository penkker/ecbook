package com.cga.book.garden.dao.Impl;

import com.cga.book.garden.dao.BookDAO;
import com.cga.book.garden.pojo.Book;
import com.cga.book.myssm.basedao.BaseDAO;

import java.util.List;

public class BookDAOImpl extends BaseDAO<Book> implements BookDAO {
    @Override
    public List<Book> getBookListByKeyName(String bookName) {
        return super.executeQuery("select * from e_book where bookName like ?","%" + bookName +"%");
    }

    @Override
    public Book getBookById(Integer id) {
        return super.load("select * from e_book where id = ?",id);
    }

    @Override
    public List<Book> getBookByBookNum(String bookNum) {
        return super.executeQuery("select * from e_book where bookNum = ?",bookNum);
    }

    @Override
    public List<Book> getBookListByDate(String enterDate, String exportDate) {
        return super.executeQuery("select * from e_book where enterDate between ? and ? and exportDate between ? and ?",enterDate,exportDate,enterDate,exportDate);
    }

    @Override
    public void delBookItem(Integer bookId) {
        super.executeUpdate("delete from e_book where id = ?",bookId);
    }

    @Override
    public Long getBookCount() {
        return (Long) super.executeComplexQuery("select count(*) from e_book")[0];
    }

    @Override
    public List<Book> getBookList() {
        return super.executeQuery("select * from e_book");
    }

    @Override
    public List<Book> getTradeInfoByDate(String sellPre, String sellLast) {
        return super.executeQuery("select * from e_book where exportDate between ? and ?",sellPre,sellLast);
    }

    @Override
    public void insertBook(Book book) {
        super.executeUpdate("insert into e_book(id,bookName,price) values(?,?,?)",book.getId(),book.getBookName(),book.getPrice());
    }

    @Override
    public List<Book> getBookByLimitId(Integer left, Integer right) {
        return super.executeQuery("select * from e_book where id between ? and ?",left,right);
    }

    @Override
    public List<Book> getBookListByBookType(String bookType) {
        return super.executeQuery("select * from e_book where bookTypeA = ?",bookType);
    }
}
