package com.fundoonotes.exception;

public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }
}

//Used when resource exist and operation not allowed