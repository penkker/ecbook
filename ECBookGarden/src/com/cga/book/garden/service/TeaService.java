package com.cga.book.garden.service;

import com.cga.book.garden.pojo.Tea;

import java.util.List;

public interface TeaService {
    //插入一条茶点记录
    void insertTea(Tea tea);

    //获取所有茶信息
    List<Tea> getTeaList(String type);

    //根据茶id查询茶信息
    Tea getTeaById(Integer teaId);

    //根据关键字查询茶信息
    List<Tea> getTeaListByTeaKeyName(String keyName);

    //根据金额区间查询茶信息
    List<Tea> getTeaListByPrice(String left,String right);

    //根据id区间查询茶信息
    List<Tea> getTeaListByLimitId(Integer left, Integer right);
}
