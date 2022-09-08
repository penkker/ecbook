package com.cga.book.garden.dao.Impl;

import com.cga.book.garden.dao.LoveDAO;
import com.cga.book.garden.pojo.Book;
import com.cga.book.garden.pojo.Love;
import com.cga.book.garden.pojo.Tea;
import com.cga.book.myssm.basedao.BaseDAO;

import java.util.List;

public class LoveDAOImpl extends BaseDAO<Love> implements LoveDAO {
    @Override
    public void setLoveTea(Tea tea) {
         super.executeUpdate("insert into e_love(id,loveTime,teaId,loveImg,lovePrice,loveName,tempId) values(?,?,?,?,?,?,?) ",0,tea.getLoveTime(),tea.getId(),tea.getTeaImgName(),tea.getTeaPrice(),tea.getTeaName(),tea.getId());
    }

    @Override
    public void setLoveBook(Book book) {
        super.executeUpdate("insert into e_love(id,loveTime,bookId,loveImg,lovePrice,loveName,tempId) values(?,?,?,?,?,?,?)",0,book.getLoveTime(),book.getId(), book.getBookImg(),book.getSellPrice(), book.getBookName(),book.getId());
    }

    @Override
    public List<Love> getLoveList() {
        return super.executeQuery("select * from e_love");
    }

    @Override
    public void delLoveById(Integer id) {
        super.executeUpdate("delete from e_love where id = ?",id);
    }

    @Override
    public Love getLoveById(Integer id) {
        return super.load("select * from e_love where id = ?",id);
    }

    @Override
    public void setLoveTypeCount(Integer count,Integer bookId) {
        super.executeUpdate("update e_love set count = count + ? where bookId = ?",count,bookId);
    }

    @Override
    public void setLoveTypeCountOne(Integer count,Integer bookId) {
        super.executeUpdate("update e_love set count = ? where bookId = ?",count,bookId);
    }

    @Override
    public void setLoveType(String type,Integer bookId) {
        super.executeUpdate("update e_love set type = ? where bookId = ?",type,bookId);
    }

    @Override
    public Love getLOveByLoveTime(String loveTime) {
        return super.load("select * from e_love where loveTime = ?",loveTime);
    }
}
