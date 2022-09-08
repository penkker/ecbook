package com.cga.book.garden.dao;

import com.cga.book.garden.pojo.Paper;

public interface PaperDAO {

    //根据日期获取指定报纸
    Paper getPaperByDate(String journalTime);

}
