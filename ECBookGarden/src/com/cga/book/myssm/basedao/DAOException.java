package com.cga.book.myssm.basedao;

public class DAOException extends RuntimeException{
    static final long serialVersionUID = -7034897190745939L;

    public DAOException(){

    }

    public DAOException(String msg){
        super(msg);
    }
}
