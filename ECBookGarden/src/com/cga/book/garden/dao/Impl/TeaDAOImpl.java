package com.cga.book.garden.dao.Impl;

import com.cga.book.garden.dao.TeaDAO;
import com.cga.book.garden.pojo.Tea;
import com.cga.book.myssm.basedao.BaseDAO;

import java.util.List;

public class TeaDAOImpl extends BaseDAO<Tea> implements TeaDAO {
    @Override
    public void insertTea(Tea tea) {
        super.executeUpdate("insert into e_tea values(?,?,?)",tea.getId(),tea.getTeaName(),tea.getTeaPrice());
    }

    @Override
    public List<Tea> getTeaList(String type) {
        return super.executeQuery("select * from e_tea where type = ?",type);
    }

    @Override
    public Tea getTeaById(Integer teaId) {
        return super.load("select * from e_tea where id = ?",teaId);
    }

    @Override
    public List<Tea> getTeaListByTeaKeyName(String keyName) {
        return super.executeQuery("select * from e_tea where teaName like ?","%" + keyName + "%");
    }

    @Override
    public List<Tea> getTeaListByPrice(String left, String right) {
        return super.executeQuery("select * from e_tea where teaPrice between ? and ?",left,right);
    }

    @Override
    public List<Tea> getTeaListByLimitId(Integer left, Integer right) {
        return super.executeQuery("select * from e_tea where id between ? and ?",left,right);
    }
}
