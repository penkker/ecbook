package com.cga.book.garden.dao.Impl;

import com.cga.book.garden.dao.HostReplyDAO;
import com.cga.book.garden.pojo.HostReply;
import com.cga.book.myssm.basedao.BaseDAO;

import java.util.List;

public class  HostReplyDAOImpl extends BaseDAO<HostReply> implements HostReplyDAO {
    @Override
    public void setHostReply(Integer id, String hostReply, String replyDate, Integer replyId) {
        super.executeUpdate("insert into e_host_reply set userId = ?,content = ?,replyId = ?,hostReplyDate = ?",id,hostReply,replyId,replyDate);
    }

    @Override
    public List<HostReply> getHostReplyListByReplyId(Integer replyId) {
        return super.executeQuery("select * from e_host_reply where replyId = ?",replyId);
    }
}
