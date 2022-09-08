package com.cga.book.garden.service.impl;

import com.cga.book.garden.dao.HostReplyDAO;
import com.cga.book.garden.pojo.HostReply;
import com.cga.book.garden.service.HostReplyService;

import java.util.List;

public class HostReplyServiceImpl implements HostReplyService {
    private HostReplyDAO hostReplyDAO;

    @Override
    public void setHostReply(Integer id, String hostReply, String replyDate, Integer replyId) {
        hostReplyDAO.setHostReply(id,hostReply,replyDate,replyId);
    }

    @Override
    public List<HostReply> getHostReplyListByReplyId(Integer replyId) {
        return hostReplyDAO.getHostReplyListByReplyId(replyId);
    }
}
