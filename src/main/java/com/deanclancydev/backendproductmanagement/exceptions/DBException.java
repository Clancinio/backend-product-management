package com.deanclancydev.backendproductmanagement.exceptions;

public class DBException extends RuntimeException{

    public DBException(final String message, final Throwable throwable){
        super(message, throwable);
    }
    public DBException(final String message){
        super(message);
    }
}
