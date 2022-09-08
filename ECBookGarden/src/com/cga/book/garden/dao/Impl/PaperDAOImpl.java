package com.cga.book.garden.dao.Impl;

import com.cga.book.garden.dao.PaperDAO;
import com.cga.book.garden.pojo.Paper;
import com.cga.book.myssm.basedao.BaseDAO;

public class PaperDAOImpl extends BaseDAO<Paper> implements PaperDAO {
    @Override
    public Paper getPaperByDate(String journalTime) {
        return super.load("select id,paperName,likeStatus,journalTime,userId,content from paper where journalTime = ?",journalTime);
    }
}
