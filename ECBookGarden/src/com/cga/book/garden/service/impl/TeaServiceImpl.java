package com.cga.book.garden.service.impl;

import com.cga.book.garden.dao.TeaDAO;
import com.cga.book.garden.pojo.Tea;
import com.cga.book.garden.service.TeaService;

import java.util.List;

public class TeaServiceImpl implements TeaService {

    private TeaDAO teaDAO;

    @Override
    public void insertTea(Tea tea) {
        teaDAO.insertTea(tea);
    }

    @Override
    public List<Tea> getTeaList(String type) {
        return teaDAO.getTeaList(type);
    }

    @Override
    public Tea getTeaById(Integer teaId) {
        return teaDAO.getTeaById(teaId);
    }

    @Override
    public List<Tea> getTeaListByTeaKeyName(String keyName) {
        return teaDAO.getTeaListByTeaKeyName(keyName);
    }

    @Override
    public List<Tea> getTeaListByPrice(String left, String right) {
        return teaDAO.getTeaListByPrice(left,right);
    }

    @Override
    public List<Tea> getTeaListByLimitId(Integer left, Integer right) {
        return teaDAO.getTeaListByLimitId(left,right);
    }

}
