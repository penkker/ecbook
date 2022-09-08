package com.cga.book.garden.service.impl;

import com.cga.book.garden.dao.PaperDAO;
import com.cga.book.garden.pojo.Paper;
import com.cga.book.garden.service.PaperService;

public class PaperServiceImpl implements PaperService {

    private PaperDAO paperDAO;

    @Override
    public Paper getPaperByDate(String journalTime) {
        return paperDAO.getPaperByDate(journalTime);
    }
}
