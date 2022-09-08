package com.cga.book.garden.service.impl;

import com.cga.book.garden.dao.HotBookDAO;
import com.cga.book.garden.pojo.HotBook;
import com.cga.book.garden.service.HotBookService;

import java.util.List;

public class HotBookServiceImpl implements HotBookService {

    private HotBookDAO hotBookDAO;

    @Override
    public List<HotBook> getBookListByType(String type) {
        return hotBookDAO.getBookListByType(type);
    }

    @Override
    public HotBook getHotBookById(Integer id) {
        return hotBookDAO.getHotBookById(id);
    }

    @Override
    public void setLoveHotBook(HotBook hotBook) {
        hotBookDAO.setLoveHotBook(hotBook);
    }
}
