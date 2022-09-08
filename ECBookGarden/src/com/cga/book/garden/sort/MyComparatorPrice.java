package com.cga.book.garden.sort;

import com.cga.book.garden.pojo.Tea;

import java.util.Comparator;

public class MyComparatorPrice implements Comparator<Tea> {
    @Override
    public int compare(Tea o1, Tea o2) {

        double aDouble = Double.parseDouble(o1.getTeaPrice());
        double bDouble = Double.parseDouble(o2.getTeaPrice());

        if(aDouble> bDouble){
            return 1;
        }else{
            return -1;
        }

    }
}
