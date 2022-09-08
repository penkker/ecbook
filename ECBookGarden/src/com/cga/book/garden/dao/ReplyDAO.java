package com.cga.book.garden.dao;

import com.cga.book.garden.pojo.Reply;

import java.util.List;

public interface ReplyDAO{
    //设置回复信息
    void setReply(Integer userId, String remark,String replyDate,Integer dsid);

    //查询所有回复信息
    List<Reply> getReplyList();

    void setReplyByDiscussion(Integer userId, String remark, String replyDate,Integer dsid);

    List<Reply> getReplyListBydsId(Integer dsId);

    //根据id获取回复信息
    Reply getReplyById(Integer id);
}
