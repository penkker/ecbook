package com.cga.book.garden.service.impl;

import com.cga.book.garden.dao.ReplyDAO;
import com.cga.book.garden.pojo.Reply;
import com.cga.book.garden.service.ReplyService;

import java.util.List;

public class ReplyServiceImpl implements ReplyService {

    private ReplyDAO replyDAO;

    @Override
    public void setReply(Integer userId, String remark,String replyDate,Integer dsid) {
        replyDAO.setReply(userId,remark,replyDate,dsid);
    }

    @Override
    public List<Reply> getReplyList() {
        return replyDAO.getReplyList();
    }

    @Override
    public void setReplyByDiscussion(Integer userId, String remark, String replyDate, Integer dsid) {
        replyDAO.setReplyByDiscussion(userId,remark,replyDate,dsid);
    }

    @Override
    public List<Reply> getReplyListBydsId(Integer dsId) {
        return replyDAO.getReplyListBydsId(dsId);
    }

    @Override
    public Reply getReplyById(Integer id) {
        return replyDAO.getReplyById(id);
    }
}
