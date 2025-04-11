package com.study.exception.pojo;

public class ExistStudentException extends RuntimeException{
    public ExistStudentException(String message){
        super(message);
    }
}
