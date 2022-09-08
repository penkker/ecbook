package com.cga.book.garden.dao.Impl;

import com.cga.book.garden.dao.HotBookDAO;
import com.cga.book.garden.pojo.HotBook;
import com.cga.book.myssm.basedao.BaseDAO;

import java.util.List;

public class HotBookDAOImpl extends BaseDAO<HotBook> implements HotBookDAO {
    @Override
    public List<HotBook> getBookListByType(String type) {
        return super.executeQuery("select * from e_book_hot where type = ?",type);
    }

    @Override
    public HotBook getHotBookById(Integer id) {
        return super.load("select * from e_book_hot where id = ?",id);
    }

    @Override
    public void setLoveHotBook(HotBook hotBook) {
        super.executeUpdate("insert into e_love(id,loveTime,bookId,loveImg,lovePrice,loveName,tempId) values(?,?,?,?,?,?,?)",0,hotBook.getLoveTime(),hotBook.getId(),hotBook.getBookImg(),hotBook.getPrice(),hotBook.getBookName(),hotBook.getId());
    }
}
