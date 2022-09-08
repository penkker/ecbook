package com.cga.book.garden.controller;

import com.cga.book.garden.pojo.Paper;
import com.cga.book.garden.service.PaperService;

import javax.servlet.http.HttpSession;

public class PaperController {

    private PaperService paperService;

    public String showPaper(String journalTime, HttpSession session){

        Paper paper = paperService.getPaperByDate(journalTime);
        session.setAttribute("paper",paper);

        return "readonline/read_online";


    }

}
