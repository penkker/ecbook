package com.cga.book.garden.sort;

import com.cga.book.garden.pojo.Tea;

import java.util.Comparator;

public class MyComparatorSellCount implements Comparator<Tea> {

    @Override
    public int compare(Tea o1, Tea o2) {

        int aIntsssss = o1.getSellCount();
        int bInts = o2.getSellCount();

        if(aIntsssss > bInts){

            return -1;
        }else{

            return 1;
        }

    }
}
