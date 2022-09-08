package com.cga.book.garden.service;

import com.cga.book.garden.pojo.Paper;

public interface PaperService {

    //根据指定日期获取指定报纸
    Paper getPaperByDate(String journalTime);

}
